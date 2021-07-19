package org.um.excel.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class EstadoResultado {

    private String cta;

    private String nombreCta;

    private String who;

    private BigDecimal actividadMensual;

    private BigDecimal acumActividad;

    private Map<String,BigDecimal> mapFuncionAcumActividad;


    private Boolean url = false;



}
