package org.um.excel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "ADDR")
public class Addr {


    @Id
    @Column(name = "[ADDR_CODE]")
    private String addrCode;

    @Column(name = "[ADDR_LINE_1]")
    private String addrLine1;

    @Column(name = "[ADDR_LINE_2]")
    private String addrLine2;

    @Column(name = "[ADDR_LINE_3]")
    private String addrLine3;

    @Column(name = "[ADDR_LINE_4]")
    private String addrLine4;

    @Column(name = "[TELEPHONE_NO]")
    private String telephoneNo;

    @Column(name = "[TELEx_FAX_NO]")
    private String telexFaxNo;

}
