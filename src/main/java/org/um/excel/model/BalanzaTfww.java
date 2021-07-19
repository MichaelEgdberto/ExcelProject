package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanzaTfww {

    private String cuenta;
    private String nombre;
    private BigDecimal saldoInicial;
    private BigDecimal creditos;
    private BigDecimal debitos;
    private BigDecimal saldo;
    private BigDecimal saldoacredor;

}
