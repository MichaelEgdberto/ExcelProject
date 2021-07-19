package org.um.excel.model;

import lombok.Data;


import java.util.List;

@Data
public class ReportesFondosAsignados {

    AnlCode dimension;

    String periodo;

    SaldoAnteriorDimension salAnt;

    List<MovimientosDimension> lsDatos;


}
