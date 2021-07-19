package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JrnlMovsReport {

    Integer noMovto;

    String cuenta;

    String descripcion;

    String dimenciones;

    BigDecimal credito;

    BigDecimal debito;

    String cuentaTxt;



}
