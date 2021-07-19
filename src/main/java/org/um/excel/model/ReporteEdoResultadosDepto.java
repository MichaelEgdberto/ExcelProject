package org.um.excel.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ReporteEdoResultadosDepto {

    private String periodo;

    private List<EstadoResultado> lsEdoResultado;

    private List<String> lsFunciones;

    private List<String> lsCuentas;

    private Map<String,String> mapCtasNombres;

    private Map<String,String> mapFuncionesNombre;

}
