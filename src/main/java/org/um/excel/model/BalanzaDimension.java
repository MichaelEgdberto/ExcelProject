package org.um.excel.model;


import lombok.Data;

import java.math.BigDecimal;

@Data

public class BalanzaDimension {



    String dimCode;
    String dimDescr;
    BigDecimal saldoAnt;
    BigDecimal creditos;
    BigDecimal debitos;
    BigDecimal saldo;

}
