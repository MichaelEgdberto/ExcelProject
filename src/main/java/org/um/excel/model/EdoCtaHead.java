package org.um.excel.model;

import lombok.Data;

import java.util.List;

@Data
public class EdoCtaHead {

    private String direccion1;

    private String direccion2;

    private String direccion3;

    private String nombreEntidad;

    private String fondoOperacion;

    private String periodo;

    private String nombreCuenta;

    private String lookup;

    private String codigoCuenta;

//    private JRDataSource dataSource;

    private List<EdoCtaMovs> lsEdoCtaMovs;

    private String formula;







}
