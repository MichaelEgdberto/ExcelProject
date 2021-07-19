package org.um.excel.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.um.excel.model.*;


import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpAsalFldgDaoEdoCta {

    private static final Logger log = LoggerFactory.getLogger(SpAsalFldgDaoEdoCta.class);

    @Autowired
    EntityManager em;
//
//    @Qualifier("spbEntityManagerFactory")
//    @Autowired
//    EntityManager emb;



    private EntityManager entityManager(String union){
        EntityManager eman = null;
        if(union.toUpperCase().equals("A")){
            eman = em;
            System.out.println("conectado a SunSystemsAGC111");
        }else{
            eman = em;
            System.out.println("conectado a SunSystemsAGU111");
        }
        return eman;
    }


    public Map<String, Acnt> listActn(String bu, String union ){
        String a = "SELECT * FROM %s ";
        String asql = String.format(a, bu + "_ACNT" );
        System.out.println("****** _A_ACNT ------ "+ asql);

        List<Acnt> lsAcnt = entityManager(union).createNativeQuery(asql,Acnt.class).getResultList();

        Map<String, Acnt> mapAcnt = new HashMap<>();
        for(Acnt acnt : lsAcnt){
            mapAcnt.put(acnt.getAcntCode().trim(),acnt);
        }
        return mapAcnt;

    }

    public List<ASalFldg> listMovsSunPlusByJrnalNo(String bu, Integer jrnalNo, String union ){

        String s = "SELECT * " +
              " FROM %s  " +
              " WHERE [JRNAL_NO]=%d  order by [JRNAL_LINE]";
        String sql = String.format(s,bu + "_A_SALFLDG",  jrnalNo);

        Map<String,Acnt> mapAcnt = listActn(bu,union);

        //System.out.println(sql);
        List<ASalFldg> test = entityManager(union).createNativeQuery(sql,ASalFldg.class).getResultList();

        List<ASalFldg> salida = new ArrayList<>();

        for(ASalFldg aSalFldg : test){
            if(mapAcnt.containsKey(aSalFldg.getAccntCode().getAcntCode().trim())){
                aSalFldg.setAcnt(mapAcnt.get(aSalFldg.getAccntCode().getAcntCode().trim()));
                salida.add(aSalFldg);
            }
        }

        return salida;
    }


    public AnlCode selectAnlCodeByAnlCodeIdAndCode(String bu, String anlCatId, String anlCode, String union) {


        String tablename = bu.toUpperCase() +"_ANL_CODE";

        String s =  "SELECT * FROM %s WHERE [ANL_CAT_ID] = '%s' AND [ANL_CODE]= '%s'";
        String sql = String.format(s,tablename,anlCatId,anlCode);

        return (AnlCode) entityManager(union).createNativeQuery(sql,AnlCode.class).getSingleResult();
    }

    public Addr selectAddres(String bu, String union){


        String  s = "SELECT * FROM  %s WHERE [ADDR_CODE]= '0000000000     ' ";

        String tablename = bu.toUpperCase() + "_ADDR";

        String sql = String.format(s,tablename);

        return (Addr) entityManager(union).createNativeQuery(sql,Addr.class).getSingleResult();
    }


    public Map<String, List<EdoCtaMovs>> listaMovimientos(String union,
                                                          String bu, List<String> accntCode, String pi, String pf, List<String> t1,
                                                          List<String> t2, List<String> t3, List<String> t4, List<String> t5, List<String> t6,
                                                          List<String> t7, List<String> t8, List<String> t9, List<String> t10,
                                                          String journalType, String sel){

        Map<String,Acnt> mapAcnt = listActn(bu,union);


        String ordenadorPrincipal = "ACCNT_CODE,";
        if(sel.equals("t1")){
            ordenadorPrincipal="ANAL_T0,";
        }
        if(sel.equals("t2")){
            ordenadorPrincipal="ANAL_T1,";
        }
        if(sel.equals("t3")){
            ordenadorPrincipal="ANAL_T2,";
        }
        if(sel.equals("t4")){
            ordenadorPrincipal="ANAL_T3,";
        }
        if(sel.equals("t5")){
            ordenadorPrincipal="ANAL_T4,";
        }
        if(sel.equals("t6")){
            ordenadorPrincipal="ANAL_T5,";
        }
        if(sel.equals("t7")){
            ordenadorPrincipal="ANAL_T6,";
        }
        if(sel.equals("t8")){
            ordenadorPrincipal="ANAL_T7,";
        }
        if(sel.equals("t9")){
            ordenadorPrincipal="ANAL_T8,";
        }
        if(sel.equals("t10")){
            ordenadorPrincipal="ANAL_T9,";
        }

        List<ASalFldg> lsMovs = entityManager(union).createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,journalType, "EC", ordenadorPrincipal,0),ASalFldg.class).getResultList();
//        lsMovs.addAll();
        List<String> lsCtasMv = new ArrayList<>();
        List<String> lsCtasUtil = new ArrayList<>();
        List<String> lsFnd = new ArrayList();
        //log.info("tamaño lista {}", lsMovs.size());
        for(ASalFldg mv : lsMovs){

            if(!lsFnd.contains(mv.getAnalT2().trim())){
                lsFnd.add(mv.getAnalT2().trim());
            }
            if(!lsCtasUtil.contains(mv.getAccntCode().getAcntCode().trim())){
                lsCtasUtil.add(mv.getAccntCode().getAcntCode().trim());
            }

            //log.info("mv {}", mv.toString());
            if(sel.equals("t0")) {
                if (!lsCtasMv.contains(mv.getAccntCode().getAcntCode().trim())) {
                    lsCtasMv.add(mv.getAccntCode().getAcntCode().trim());
                }
            }
            if(sel.equals("t1")) {
                if (!lsCtasMv.contains(mv.getAnalT0().trim())) {
                    lsCtasMv.add(mv.getAnalT0().trim());
                }
            }
            if(sel.equals("t2")) {
                if (!lsCtasMv.contains(mv.getAnalT1().trim())) {
                    lsCtasMv.add(mv.getAnalT1().trim());
                }
            }
            if(sel.equals("t3")) {
                if (!lsCtasMv.contains(mv.getAnalT2().trim())) {
                    lsCtasMv.add(mv.getAnalT2().trim());
                }
            }
            if(sel.equals("t4")) {
                if (!lsCtasMv.contains(mv.getAnalT3().trim())) {
                    lsCtasMv.add(mv.getAnalT3().trim());
                }
            }
            if(sel.equals("t5")) {
                if (!lsCtasMv.contains(mv.getAnalT4().trim())) {
                    lsCtasMv.add(mv.getAnalT4().trim());
                }
            }
            if(sel.equals("t6")) {
                if (!lsCtasMv.contains(mv.getAnalT5().trim())) {
                    lsCtasMv.add(mv.getAnalT5().trim());
                }
            }
            if(sel.equals("t7")) {
                if (!lsCtasMv.contains(mv.getAnalT6().trim())) {
                    lsCtasMv.add(mv.getAnalT6().trim());
                }
            }
            if(sel.equals("t8")) {
                if (!lsCtasMv.contains(mv.getAnalT7().trim())) {
                    lsCtasMv.add(mv.getAnalT7().trim());
                }
            }
            if(sel.equals("t9")) {
                if (!lsCtasMv.contains(mv.getAnalT8().trim())) {
                    lsCtasMv.add(mv.getAnalT8().trim());
                }
            }
            if(sel.equals("t10")) {
                if (!lsCtasMv.contains(mv.getAnalT9().trim())) {
                    lsCtasMv.add(mv.getAnalT9().trim());
                }
            }
        }


        //log.info("tamaño lista {}", lsCtasMv.size());
        Map<String, BigDecimal> mapSalidoInicial = new HashMap<>();
        if(sel.equals("t0")){
            for(String cta : lsCtasMv){
                Acnt acnt = mapAcnt.get(cta);
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,ctals,pi,pf,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,journalType, "SA", "", acnt.getAcntType())).
                        getSingleResult());
            }
        }
        Integer typeAcnt = 0;
        if(!sel.equals("t0")){
            for(String salida : lsCtasUtil){
                typeAcnt = mapAcnt.get(salida).getAcntType();
            }
        }


        if(sel.equals("t1")){
            for(String dim : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(dim);
                mapSalidoInicial.put(dim,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,ctals,t2,t3,t4,t5,t6,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t2")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,ctals,t3,t4,t5,t6,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t3")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,ctals,t4,t5,t6,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t4")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,ctals,t5,t6,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t5")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,ctals,t6,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t6")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,ctals,t7,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t7")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,t6,ctals,t8,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t8")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,t6,t7,ctals,t9,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t9")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,t6,t7,t8,ctals,t10,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }

        if(sel.equals("t10")){
            for(String cta : lsCtasMv){
                List<String> ctals = new ArrayList<>();
                ctals.add(cta);
                mapSalidoInicial.put(cta,(BigDecimal) entityManager(union).
                        createNativeQuery(consultaEdoCta(bu,accntCode,pi,pf,t1,t2,t3,t4,t5,t6,t7,t8,t9,ctals,journalType, "SA", "",typeAcnt)).
                        getSingleResult());
            }
        }




        Map<String, List<EdoCtaMovs>> mapSalida = new HashMap<>();
        for(String cta : lsCtasMv){
            //log.info("cta {}",cta);
            BigDecimal saldo = BigDecimal.ZERO;
            List<EdoCtaMovs> lsMv = new ArrayList<>();
            EdoCtaMovs mv = new EdoCtaMovs();
            mv.setCredito(null);
            mv.setDebito(null);
            mv.setReferencia("");
            mv.setDiario("");
            mv.setPeriodo(pi.trim());
            mv.setDescripcion("SALDO DE APERTURA");
            mv.setTotal(mapSalidoInicial.containsKey(cta) && mapSalidoInicial.get(cta)!=null ? mapSalidoInicial.get(cta).abs() : BigDecimal.ZERO);
            mv.setCrDb((mapSalidoInicial.containsKey(cta) && mapSalidoInicial.get(cta)!=null ? mapSalidoInicial.get(cta) : BigDecimal.ZERO).compareTo(BigDecimal.ZERO)>0 ? "Cr" : "");
            saldo = saldo.add(mapSalidoInicial.containsKey(cta) && mapSalidoInicial.get(cta)!=null ? mapSalidoInicial.get(cta) : BigDecimal.ZERO);


            String periodo = lsMovs.get(0).getPeriod().toString();
            //mv.setPeriodo(periodo);
            lsMv.add(mv);
            //log.info("movs size {} {}", lsMovs.size(), saldo);
            for(ASalFldg mov : lsMovs){
                if(sel.equals("t0")) {
                    if (mov.getAccntCode().getAcntCode().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t1")) {
                    if (mov.getAnalT0().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t2")) {
                    if (mov.getAnalT1().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t3")) {
                    if (mov.getAnalT2().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t4")) {
                    if (mov.getAnalT3().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t5")) {
                    if (mov.getAnalT4().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t6")) {
                    if (mov.getAnalT5().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t7")) {
                    if (mov.getAnalT6().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t8")) {
                    if (mov.getAnalT7().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t9")) {
                    if (mov.getAnalT8().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
                if(sel.equals("t10")) {
                    if (mov.getAnalT9().trim().equals(cta)) {
                        saldo = saldo.add(mov.getAmount());
                        mv = setData(mov, saldo);
                        lsMv.add(mv);
                    }
                }
            }
            if(!lsMv.isEmpty()){
                mapSalida.put(cta,lsMv);
            }
            //log.info("tamaño mapa de movimientos {}", mapSalida.size());

        }
        return mapSalida;
    }

    private EdoCtaMovs setData(ASalFldg mov, BigDecimal saldo){
        EdoCtaMovs  mv = new EdoCtaMovs();
        mv.setFecha(mov.getTransDatetime());
        mv.setReferencia(mov.getVchrNum());
        mv.setDiario(mov.getJrnalNo() + "-"+ mov.getJrnalLine());
        mv.setCredito(mov.getDC().trim().equals("C") ? mov.getAmount().abs() : null);
        mv.setDebito(mov.getDC().trim().equals("D") ? mov.getAmount().abs() : null);
        mv.setDescripcion(mov.getDescriptn());
        mv.setPeriodo(mov.getPeriod().toString());
        mv.setFondo(mov.getAnalT2().trim());

        mv.setTotal(saldo.abs());
        mv.setCrDb(saldo.compareTo(BigDecimal.ZERO)>0 ? "Cr" : "");
        return mv;
    }

    public String consultaEdoCta(String bu, List<String> accntCode, String pi, String pf, List<String> t1,
                                 List<String> t2, List<String> t3, List<String> t4, List<String> t5, List<String> t6,
                                 List<String> t7, List<String> t8, List<String> t9, List<String> t10,
                                 String journalType, String accion, String ordenadorPrincipal, Integer acntType) {


        StringBuilder stb = new StringBuilder();
        stb.append("\n");
        if(accion.equals("") || accion.equals("EC")) {
            stb.append("SELECT * FROM dbo." + bu.trim().toUpperCase() + "_A_SALFLDG WHERE JRNAL_NO IS NOT NULL  and ALLOCATION<>'C'  \n");
            if(pf.equals("") || pf.equals(pi)){
                stb.append(" and PERIOD=" + pi + " \n");
            }else{
                stb.append(" and PERIOD between " + pi + " and " + pf + " \n");
            }
        }else{
            stb.append("SELECT SUM(AMOUNT) FROM dbo." + bu.trim().toUpperCase() + "_A_SALFLDG WHERE JRNAL_NO IS NOT NULL   and ALLOCATION<>'C'  \n");
//            if(acntType!=3) {
                stb.append(" and PERIOD < " + pi + " \n");
//            }else{
//                Integer pei = new Integer(pi);
//                Integer pef = new Integer(pf);
//                Integer peZero = new Integer(pf.substring(0,4) + "000");
//                if(pei>(peZero+1)){
//                    stb.append(" and PERIOD between " + peZero + " and " + (pei-1) + " \n");
//                }else{
//                    stb.append(" and PERIOD = " + peZero + " \n");
//                }
//            }

        }

        if(!journalType.equals("")){
            if(journalType.contains("%")){
                stb.append(" and JRNAL_TYPE LIKE '" + journalType + "' \n");
            }else{
                stb.append(" and JRNAL_TYPE = '" + journalType + "' \n");
            }
        }

        stb.append(generaCode(accntCode, "ACCNT_CODE"));
        stb.append(generaCode(t1,"ANAL_T0"));
        stb.append(generaCode(t2,"ANAL_T1"));
        stb.append(generaCode(t3,"ANAL_T2"));
        stb.append(generaCode(t4,"ANAL_T3"));
        stb.append(generaCode(t5,"ANAL_T4"));
        stb.append(generaCode(t6,"ANAL_T5"));
        stb.append(generaCode(t7,"ANAL_T6"));
        stb.append(generaCode(t8,"ANAL_T7"));
        stb.append(generaCode(t9,"ANAL_T8"));
        stb.append(generaCode(t10,"ANAL_T9"));

        if(accion.equals("") || accion.equals("EC"))
            stb.append(" ORDER BY "+ ordenadorPrincipal +" PERIOD, TRANS_DATETIME \n");

        return stb.toString();
    }

    private String generaCode(List<String> datos, String columna){
        StringBuilder salida = new StringBuilder();

        if(!datos.isEmpty()){
            if(datos.size()==1){
                if(datos.get(0).contains("-")){
                    String[] data = datos.get(0).split("-");
                    if(data.length >1 )
                        salida.append(" and "+ columna +" between '" + data[0] + "' and '" + data[1] +"' \n");
                }else if(datos.get(0).contains("%")){
                    salida.append(" and "+ columna +" like '" + datos.get(0) + "' \n");
                }else{
                    salida.append(" and "+ columna +" = '" + datos.get(0) + "' \n");
                }
            }else{
                int lsSize = datos.size();
                int contador = 0;
                salida.append(" and "+ columna +" in (");
                for(String dt : datos){
                    salida.append("'" + dt + "' ");
                    contador++;
                    if(contador<lsSize){
                        salida.append(",");
                    }

                }
                salida.append(") \n");
            }
        }
        return salida.toString();
    }

}
