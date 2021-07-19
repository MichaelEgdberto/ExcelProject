package org.um.excel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.um.excel.model.ASalFldg;


import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ASalFldgNQDao {

    @Autowired
    EntityManager em;


    public List<ASalFldg> listASalFldg(Integer jrnsalno, String accntCode, String jrnalType,
                                       String fini, String ffin,
                                       String t1, String t2, String t3, String t4, String t5,
                                       String t6, String t7, String t8, String t9, String t10){

        StringBuilder stb = new StringBuilder();

        List<ASalFldg> lsSalida = new ArrayList<>();

        String strCheck = accntCode + jrnalType + t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 ;
        strCheck = strCheck!=null ? strCheck : "";
        fini = fini!=null ? fini : "";
        if(!strCheck.trim().equals("") && !fini.equals("")){

            BigDecimal  salida = saldoAnterior(jrnsalno,accntCode,jrnalType,fini,ffin,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);


            ASalFldg mv = new ASalFldg();
            mv.setDescriptn("SALDO ANTERIOR");
            mv.setAmount(salida);
            mv.setDC(salida.compareTo(BigDecimal.ZERO)<0 ? "D":"C");
            lsSalida.add(mv);
        }

        stb.append("SELECT * FROM A3L_A_SALFLDG WHERE JRNAL_NO IS NOT NULL ");
        if(jrnsalno != 0){
            stb.append(" AND JRNAL_NO=" + jrnsalno);
        }else{

            stb.append(" AND TRANS_DATETIME ");

            if(!ffin.equals("")){
                stb.append(" BETWEEN convert(DATE, '"+fini+"', 105) and convert(DATE, '"+ffin+"', 105) " );
            }else{
                stb.append(" = convert(DATE, '"+fini+"', 105)  ");
            }

            if(!accntCode.equals("")){
                if(accntCode.contains("%")){
                    stb.append(" and ACCNT_CODE LIKE '" + accntCode + "' ");
                }else{
                    stb.append(" and ACCNT_CODE = '" + accntCode + "' ");
                }
            }

            if(!jrnalType.equals("")){
                if(jrnalType.contains("%")){
                    stb.append(" and JRNAL_TYPE LIKE '" + jrnalType + "' ");
                }else{
                    stb.append(" and JRNAL_TYPE = '" + jrnalType + "' ");
                }
            }

            if(!t1.equals("")){
                if(t1.contains("%")){
                    stb.append(" and ANAL_T0 LIKE '" + t1 + "' ");
                }else if(t1.contains("*")) {
                    stb.append(" and ANAL_T0 IS NOT NULL AND REPLACE(ANAL_T0,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T0 = '" + t1 + "' ");
                }
            }
            if(!t2.equals("")){
                if(t2.contains("%")){
                    stb.append(" and ANAL_T1 LIKE '" + t2 + "' ");
                }else if(t2.contains("*")) {
                    stb.append(" and ANAL_T1 IS NOT NULL AND REPLACE(ANAL_T1,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T1 = '" + t2 + "' ");
                }
            }
            if(!t3.equals("")){
                if(t3.contains("%")){
                    stb.append(" and ANAL_T2 LIKE '" + t3 + "' ");
                }else if(t3.contains("*")) {
                    stb.append(" and ANAL_T2 IS NOT NULL AND REPLACE(ANAL_T2,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T2 = '" + t3 + "' ");
                }
            }
            if(!t4.equals("")){
                if(t4.contains("%")){
                    stb.append(" and ANAL_T3 LIKE '" + t4 + "' ");
                }else if(t4.contains("*")) {
                    stb.append(" and ANAL_T3 IS NOT NULL AND REPLACE(ANAL_T3,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T3 = '" + t4 + "' ");
                }
            }
            if(!t5.equals("")){
                if(t5.contains("%")){
                    stb.append(" and ANAL_T4 LIKE '" + t5 + "' ");
                }else if(t5.contains("*")) {
                    stb.append(" and ANAL_T4 IS NOT NULL AND REPLACE(ANAL_T4,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T4 = '" + t5 + "' ");
                }
            }
            if(!t6.equals("")){
                if(t6.contains("%")){
                    stb.append(" and ANAL_T5 LIKE '" + t6 + "' ");
                }else if(t6.contains("*")) {
                    stb.append(" and ANAL_T5 IS NOT NULL AND REPLACE(ANAL_T5,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T5 = '" + t6 + "' ");
                }
            }
            if(!t7.equals("")){
                if(t7.contains("%")){
                    stb.append(" and ANAL_T6 LIKE '" + t7 + "' ");
                }else if(t7.contains("*")) {
                    stb.append(" and ANAL_T6 IS NOT NULL AND REPLACE(ANAL_T6,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T6 = '" + t7 + "' ");
                }
            }
            if(!t8.equals("")){
                if(t8.contains("%")){
                    stb.append(" and ANAL_T7 LIKE '" + t8 + "' ");
                }else if(t8.contains("*")) {
                    stb.append(" and ANAL_T7 IS NOT NULL AND REPLACE(ANAL_T7,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T7 = '" + t8 + "' ");
                }
            }
            if(!t9.equals("")){
                if(t9.contains("%")){
                    stb.append(" and ANAL_T8 LIKE '" + t9 + "' ");
                }else if(t9.contains("*")) {
                    stb.append(" and ANAL_T8 IS NOT NULL AND REPLACE(ANAL_T8,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T8 = '" + t9 + "' ");
                }
            }
            if(!t10.equals("")){
                if(t10.contains("%")){
                    stb.append(" and ANAL_T9 LIKE '" + t10 + "' ");
                }else if(t10.contains("*")) {
                    stb.append(" and ANAL_T9 IS NOT NULL AND REPLACE(ANAL_T9,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T9 = '" + t10 + "' ");
                }
            }

            stb.append(" ORDER BY ACCNT_CODE, TRANS_DATETIME ");


        }

      lsSalida.addAll(em.createNativeQuery(stb.toString(),ASalFldg.class).getResultList());
        BigDecimal saldo = BigDecimal.ZERO;
        for(ASalFldg s : lsSalida){
            saldo = saldo.add(s.getAmount().negate());
            s.setAmount(s.getAmount().negate()   );
            s.setSaldo(saldo);
        }

        return lsSalida;

    }

    public BigDecimal saldoAnterior(Integer jrnsalno, String accntCode, String jrnalType,
                                       String fini, String ffin,
                                       String t1, String t2, String t3, String t4, String t5,
                                       String t6, String t7, String t8, String t9, String t10){

        StringBuilder stb = new StringBuilder();
        stb.append("SELECT SUM(AMOUNT) FROM A3L_A_SALFLDG WHERE JRNAL_NO IS NOT NULL ");

        BigDecimal lsSalida = BigDecimal.ZERO;

        if(fini!=null && !fini.equals("")){
            stb.append(" AND TRANS_DATETIME ");
            stb.append(" < convert(DATE, '"+fini+"', 105)  ");

            if(!accntCode.equals("")){
                if(accntCode.contains("%")){
                    stb.append(" and ACCNT_CODE LIKE '" + accntCode + "' ");
                }else{
                    stb.append(" and ACCNT_CODE = '" + accntCode + "' ");
                }
            }

            if(!jrnalType.equals("")){
                if(jrnalType.contains("%")){
                    stb.append(" and JRNAL_TYPE LIKE '" + jrnalType + "' ");
                }else{
                    stb.append(" and JRNAL_TYPE = '" + jrnalType + "' ");
                }
            }

            if(!t1.equals("")){
                if(t1.contains("%")){
                    stb.append(" and ANAL_T0 LIKE '" + t1 + "' ");
                }else if(t1.contains("*")) {
                    stb.append(" and ANAL_T0 IS NOT NULL AND REPLACE(ANAL_T0,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T0 = '" + t1 + "' ");
                }
            }
            if(!t2.equals("")){
                if(t2.contains("%")){
                    stb.append(" and ANAL_T1 LIKE '" + t2 + "' ");
                }else if(t2.contains("*")) {
                    stb.append(" and ANAL_T1 IS NOT NULL AND REPLACE(ANAL_T1,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T1 = '" + t2 + "' ");
                }
            }
            if(!t3.equals("")){
                if(t3.contains("%")){
                    stb.append(" and ANAL_T2 LIKE '" + t3 + "' ");
                }else if(t3.contains("*")) {
                    stb.append(" and ANAL_T2 IS NOT NULL AND REPLACE(ANAL_T2,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T2 = '" + t3 + "' ");
                }
            }
            if(!t4.equals("")){
                if(t4.contains("%")){
                    stb.append(" and ANAL_T3 LIKE '" + t4 + "' ");
                }else if(t4.contains("*")) {
                    stb.append(" and ANAL_T3 IS NOT NULL AND REPLACE(ANAL_T3,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T3 = '" + t4 + "' ");
                }
            }
            if(!t5.equals("")){
                if(t5.contains("%")){
                    stb.append(" and ANAL_T4 LIKE '" + t5 + "' ");
                }else if(t5.contains("*")) {
                    stb.append(" and ANAL_T4 IS NOT NULL AND REPLACE(ANAL_T4,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T4 = '" + t5 + "' ");
                }
            }
            if(!t6.equals("")){
                if(t6.contains("%")){
                    stb.append(" and ANAL_T5 LIKE '" + t6 + "' ");
                }else if(t6.contains("*")) {
                    stb.append(" and ANAL_T5 IS NOT NULL AND REPLACE(ANAL_T5,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T5 = '" + t6 + "' ");
                }
            }
            if(!t7.equals("")){
                if(t7.contains("%")){
                    stb.append(" and ANAL_T6 LIKE '" + t7 + "' ");
                }else if(t7.contains("*")) {
                    stb.append(" and ANAL_T6 IS NOT NULL AND REPLACE(ANAL_T6,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T6 = '" + t7 + "' ");
                }
            }
            if(!t8.equals("")){
                if(t8.contains("%")){
                    stb.append(" and ANAL_T7 LIKE '" + t8 + "' ");
                }else if(t8.contains("*")) {
                    stb.append(" and ANAL_T7 IS NOT NULL AND REPLACE(ANAL_T7,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T7 = '" + t8 + "' ");
                }
            }
            if(!t9.equals("")){
                if(t9.contains("%")){
                    stb.append(" and ANAL_T8 LIKE '" + t9 + "' ");
                }else if(t9.contains("*")) {
                    stb.append(" and ANAL_T8 IS NOT NULL AND REPLACE(ANAL_T8,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T8 = '" + t9 + "' ");
                }
            }
            if(!t10.equals("")){
                if(t10.contains("%")){
                    stb.append(" and ANAL_T9 LIKE '" + t10 + "' ");
                }else if(t10.contains("*")) {
                    stb.append(" and ANAL_T9 IS NOT NULL AND REPLACE(ANAL_T9,' ','')<>'' ");
                }else{
                    stb.append(" and ANAL_T9 = '" + t10 + "' ");
                }
            }
             lsSalida = (BigDecimal) em.createNativeQuery(stb.toString()).getSingleResult();
        }


        if(lsSalida==null)
            lsSalida = BigDecimal.ZERO;
            return lsSalida;

    }


}
