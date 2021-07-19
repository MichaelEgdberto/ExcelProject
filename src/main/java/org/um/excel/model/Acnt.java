package org.um.excel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "A3L_ACNT")
public class Acnt implements Serializable {

    @Id
    @Column(name = "ACNT_CODE")
    private	String	acntCode;

    @Column(name = "UPDATE_COUNT")
    private	Integer	updateCount;

    @Column(name = "LAST_CHANGE_USER_ID")
    private	String	lastChangeUserId;

    @Column(name = "LAST_CHANGE_DATETIME")
    private Date lastChangeDatetime;

    @Column(name = "DESCR")
    private	String	descr;

    @Column(name = "S_HEAD")
    private	String	sHead;

    @Column(name = "LOOKUP")
    private	String	lookup;

    @Column(name = "DAG_CODE")
    private	Integer	dagCode;

    @Column(name = "ACNT_TYPE")
    private	Integer	acntType;

    @Column(name = "BAL_TYPE")
    private	Integer	balType;

    @Column(name = "STATUS")
    private	Integer	status;

    @Column(name = "SUPPRESS_REVAL")
    private	Integer	suppressReval;

    @Column(name = "LONG_DESCR")
    private	String	longDescr;

    @Column(name = "CONV_CODE_CTRL")
    private	Integer	convCodeCtrl;

    @Column(name = "DFLT_CURR_CODE")
    private	String	dfltCurrCode;

//    @Column(name = "ALLOCN_IN_PROGRESS")
//    private	Integer	allocn_in_progress;
//
//    @Column(name = "LINK_ACNT")
//    private	Integer	link_acnt;
//
//    @Column(name = "RPT_CONV_CTRL")
//    private	Integer	rpt_conv_ctrl;
//
//    @Column(name = "USER_AREA")
//    private	Integer	user_area;
//
//    @Column(name = "CR_LIMIT")
//    private	Integer	cr_limit;

    @Column(name = "ENTER_ANL_1")
    private	Integer	enterAnl1;

    @Column(name = "ENTER_ANL_2")
    private	Integer	enterAnl2;

    @Column(name = "ENTER_ANL_3")
    private	Integer	enterAnl3;

    @Column(name = "ENTER_ANL_4")
    private	Integer	enterAnl4;

    @Column(name = "ENTER_ANL_5")
    private	Integer	enterAnl5;

    @Column(name = "ENTER_ANL_6")
    private	Integer	enterAnl6;

    @Column(name = "ENTER_ANL_7")
    private	Integer	enterAnl7;

    @Column(name = "ENTER_ANL_8")
    private	Integer	enterAnl8;

    @Column(name = "ENTER_ANL_9")
    private	Integer	enterAnl9;

    @Column(name = "ENTER_ANL_10")
    private	Integer	enterAnl10;

//    @Column(name = "OIL")
//    private	Integer	oil;
//
//    @Column(name = "CV4_DFLT_CURR_CODE")
//    private	String	cv4DfltCurrCode;
//
//    @Column(name = "CV4_CONV_CODE_CTRL")
//    private	Integer	cv4ConvCodeCtrl;
//
//    @Column(name = "CV5_DFLT_CURR_CODE")
//    private	String	cv5DfltCurrCode;
//
//    @Column(name = "CV5_CONV_CODE_CTRL")
//    private	Integer	cv5ConvCodeCtrl;
//
//    @Column(name = "BANK_CURR_REQD")
//    private	Integer	bankCurrReqd;
//
//    @Column(name = "ACNT_LINKS_ALLOWED")
//    private	Integer	acntLinksAllowed;
//
//    @Column(name = "PASP_ACNT_TYPE")
//    private	Integer	paspAcntType;
//
//    @Column(name = "DR_CR")
//    private	Integer	drCr;
//
//    @Column(name = "ACNT_SUB_TYPE")
//    private	Integer	acntSubType;




}
