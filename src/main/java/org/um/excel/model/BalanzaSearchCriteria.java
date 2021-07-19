package org.um.excel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data

public class BalanzaSearchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> fondo;

    private List<String> recurso;

    private List<String> orgid;

    private Date fechainicial;

    private Date fechafinal;

}
