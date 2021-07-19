package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data

public class MovimientosDimension {

    private Date transDatetime;

    private String periodo;

    private String jrnalType;

    private Integer jrnalNo;

    private Integer jrnalLine;

    private String acntCode;

    private String descr;

    private String descriptn;

    private String treference;

    private String dim01;

    private String dim02;

    private String dim03;

    private String dim04;

    private String dim05;

    private String dim06;

    private String dim07;

    private String dim08;

    private String dim09;

    private String dim10;

    private String desDim01;

    private String desDim02;

    private String desDim03;

    private String desDim04;

    private String desDim05;

    private String desDim06;

    private String desDim07;

    private String desDim08;

    private String desDim09;

    private String desDim10;

    private BigDecimal debitos;

    private BigDecimal creditos;

    private BigDecimal saldo;

    private String secondReference;
}
