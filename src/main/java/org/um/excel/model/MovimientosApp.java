package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MovimientosApp {

    private Date transactionDate;

    private String descripcion;

    private BigDecimal amount;

    private BigDecimal saldo;

    private String crDb;

    private Integer id;


}
