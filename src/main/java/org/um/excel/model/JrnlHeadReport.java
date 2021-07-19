package org.um.excel.model;

import lombok.Data;


import java.math.BigDecimal;
import java.util.List;

@Data
public class JrnlHeadReport {

    String empresa;

    String rfcEmpresa;

    String jrnlNo;

    String direccionEmpresa;

    String secondReference;

    String periodo;

    String transactionDate;

    String captureDate;

    String source;

    String jrnlType;

    BigDecimal totalCredito;

    BigDecimal totalDebito;

    String moneda;

    List<JrnlMovsReport> lsMovs;


}
