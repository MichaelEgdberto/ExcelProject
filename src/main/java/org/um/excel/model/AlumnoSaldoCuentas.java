package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlumnoSaldoCuentas {

    private String alumno;

    private String fondo;

    private BigDecimal salActivo;

    private BigDecimal salPasivo;

    private BigDecimal salIncobrable;

    private String status;


}
