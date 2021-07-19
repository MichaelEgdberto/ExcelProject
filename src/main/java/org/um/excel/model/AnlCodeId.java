package org.um.excel.model;

import lombok.Data;

import java.io.Serializable;

@Data

public class AnlCodeId implements Serializable {

    private String anlCatId;

    private String anlCode;
}
