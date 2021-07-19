package org.um.excel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "[A3L_ANL_CODE]")
@IdClass(AnlCodeId.class)
public class AnlCode {

    @Id
    @Column(name = "[ANL_CAT_ID]")
    private String anlCatId;
    @Id
    @Column(name = "[ANL_CODE]")
    private String anlCode;
    @Column(name = "[UPDATE_COUNT]")
    private Integer updateCount;
    @Column(name = "[LAST_CHANGE_USER_ID]")
    private String lastChangeUserId;
    @Column(name = "[LAST_CHANGE_DATETIME]")
    private Date lastChangeDatetime;
    @Column(name = "[STATUS]")
    private Integer status;
    @Column(name = "[LOOKUP]")
    private String lookup;
    @Column(name = "[NAME]")
    private String name;
    @Column(name = "[DAG_CODE]")
    private String dagCode;
    @Column(name = "[BDGT_CHECK]")
    private Integer bdgtCheck;
    @Column(name = "[BDGT_STOP]")
    private Integer bdgtStop;
    @Column(name = "[PROHIBIT_POSTING]")
    private Integer prohibitPosting;
    @Column(name = "[NAVIGATION_OPTION]")
    private Integer navigationOption;
    @Column(name = "[COMBINED_BDGT_CHCK]")
    private Integer combinedBdgtChck;


}
