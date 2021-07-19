package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EdoCtaMovs {

    private Date fecha;

    private String diario;

    private String referencia;

    private String descripcion;

    private BigDecimal debito;

    private BigDecimal credito;

    private BigDecimal total;

    private String crDb;

    private String periodo;

    private String fondo;

}
