package org.um.excel.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ASalFldgId implements Serializable {

     Acnt accntCode;

     Integer period;

     Date transDatetime;

     Integer jrnalNo;

     Integer jrnalLine;

}
