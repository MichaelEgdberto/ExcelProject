package org.um.excel.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@IdClass(ASalFldgId.class)
@Table(name = "A3L_A_SALFLDG")
public class ASalFldg implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ACCNT_CODE")
    private Acnt accntCode;
    @Id
    @Column(name = "PERIOD")
    private Integer period;
    @Id
    @Column(name = "TRANS_DATETIME")
    private Date transDatetime;
    @Id
    @Column(name = "JRNAL_NO")
    private Integer jrnalNo;
    @Id
    @Column(name = "JRNAL_LINE")
    private Integer jrnalLine;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "D_C")
    private String dC;

    @Column(name = "ALLOCATION")
    private String allocation;

    @Column(name = "JRNAL_TYPE")
    private String jrnalType;

    @Column(name = "JRNAL_SRCE")
    private String jrnalSrce;

    @Column(name = "TREFERENCE")
    private String treference;

    @Column(name = "DESCRIPTN")
    private String descriptn;
    @Column(name = "ENTRY_DATETIME")
    private Date entryDatetime;

    @Column(name = "ENTRY_PRD")
    private Integer entryPrd;
    @Column(name = "DUE_DATETIME")
    private Date dueDatetime;

    @Column(name = "ALLOC_REF")
    private Integer allocRef;

    @Column(name = "ALLOC_DATETIME")
    private Date allocDatetime;

    @Column(name = "ALLOC_PERIOD")
    private Integer allocPeriod;

    @Column(name = "ASSET_IND")
    private String assetInd;

    @Column(name = "ASSET_CODE")
    private String assetCode;

    @Column(name = "ASSET_SUB")
    private String assetSub;

    @Column(name = "CONV_CODE")
    private String convCode;

    @Column(name = "CONV_RATE")
    private BigDecimal convRate;

    @Column(name = "OTHER_AMT")
    private BigDecimal otherAmt;

    @Column(name = "OTHER_DP")
    private String otherDp;

    @Column(name = "CLEARDOWN")
    private String cleardown;

    @Column(name = "REVERSAL")
    private String reversal;

    @Column(name = "LOSS_GAIN")
    private String lossGain;

    @Column(name = "ROUGH_FLAG")
    private String roughFlag;

    @Column(name = "IN_USE_FLAG")
    private String inUseFlag;

    @Column(name = "ANAL_T0")
    private String analT0;

    @Column(name = "ANAL_T1")
    private String analT1;

    @Column(name = "ANAL_T2")
    private String analT2;

    @Column(name = "ANAL_T3")
    private String analT3;

    @Column(name = "ANAL_T4")
    private String analT4;

    @Column(name = "ANAL_T5")
    private String analT5;

    @Column(name = "ANAL_T6")
    private String analT6;

    @Column(name = "ANAL_T7")
    private String analT7;

    @Column(name = "ANAL_T8")
    private String analT8;

    @Column(name = "ANAL_T9")
    private String analT9;

    @Transient
    private Date fini;

    @Transient
    private Date ffin;

    @Transient
    private Acnt acnt;

//    @Column(name = "POSTING_DATETIME")
//    private Date postingDatetime;
//
//@Column(name = "ALLOC_IN_PROGRESS")
//    private String allocInProgress;
//
//@Column(name = "HOLD_REF")
//    private Integer holdRef;
//
//@Column(name = "HOLD_OP_ID")
//    private String holdOpId;
//
//@Column(name = "BASE_RATE")
//    private BigDecimal baseRate;
//
//@Column(name = "BASE_OPERATOR")
//    private String baseOperator;
//
//@Column(name = "CONV_OPERATOR")
//    private String convOperator;
//
//@Column(name = "REPORT_RATE")
//    private BigDecimal reportRate;
//
//@Column(name = "REPORT_OPERATOR")
//    private String reportOperator;
//
//@Column(name = "REPORT_AMT")
//    private BigDecimal reportAmt;
//
@Column(name = "MEMO_AMT")
    private BigDecimal memoAmt;

//@Column(name = "EXCLUDE_BAL")
//    private Integer excludeBal;
//
//@Column(name = "LE_DETAILS_IND")
//    private String leDetailsInd;
//
//@Column(name = "CONSUMED_BDGT_ID")
//    private Integer consumedBdgtId;
//
//@Column(name = "CV4_CONV_CODE")
//    private String cv4ConvCode;
//
//@Column(name = "CV4_AMT")
//    private BigDecimal cv4Amt;
//
//@Column(name = "CV4_CONV_RATE")
//    private BigDecimal cv4ConvRate;
//
//@Column(name = "CV4_OPERATOR")
//    private String cv4Operator;
//
//@Column(name = "CV4_DP")
//    private String cv4Dp;
//
//@Column(name = "CV5_CONV_CODE")
//    private String cv5ConvCode;
//
//@Column(name = "CV5_AMT")
//    private BigDecimal cv5Amt;
//
//@Column(name = "CV5_CONV_RATE")
//    private BigDecimal cv5ConvRate;
//
//@Column(name = "CV5_OPERATOR")
//    private String cv5Operator;
//
//@Column(name = "CV5_DP")
//    private String cv5Dp;
//
//@Column(name = "LINK_REF_1")
//    private String linkRef1;
//
//@Column(name = "LINK_REF_2")
//    private String linkRef2;
//
//@Column(name = "LINK_REF_3")
//    private String linkRef3;
//
//@Column(name = "ALLOCN_CODE")
//    private String allocnCode;
//
////@Column(name = "ALLOCN_STMNTS")
////    private Integer allocnStmnts;
//
//@Column(name = "OPR_CODE")
//    private String oprCode;
//
//@Column(name = "SPLIT_ORIG_LINE")
//    private Integer splitOrigLine;
//
//@Column(name = "VAL_DATETIME")
//    private Date val_datetime;
//
//@Column(name = "SIGNING_DETAILS")
//    private String signingDetails;
//
//@Column(name = "INSTLMT_DATETIME")
//    private Date instlmt_datetime;
//
//@Column(name = "PRINCIPAL_REQD")
//    private Integer principalReqd;
//
//@Column(name = "BINDER_STATUS")
//    private String binderStatus;
//
//@Column(name = "AGREED_STATUS")
//    private Integer agreedStatus;
//
//@Column(name = "SPLIT_LINK_REF")
//    private String splitLinkRef;
//
//@Column(name = "PSTG_REF")
//    private String pstgRef;
//
//@Column(name = "TRUE_RATED")
//    private Integer trueRated;
//
//@Column(name = "HOLD_DATETIME")
//    private Date holdDatetime;
//
//@Column(name = "HOLD_TEXT")
//    private String holdText;
//
//@Column(name = "INSTLMT_NUM")
//    private Integer instlmtNum;
//
//@Column(name = "SUPPLMNTRY_EXTSN")
//    private Integer supplmntryExtsn;
//
//@Column(name = "APRVLS_EXTSN")
//    private Integer aprvlsExtsn;
//
////@Column(name = "REVAL_LINK_REF")
////    private Integer revalLinkRef;
//
////@Column(name = "SAVED_SET_NUM")
////    private BigDecimal savedSetNum;
////
////@Column(name = "AUTHORISTN_SET_REF")
////    private Integer authoristnSetRef;
////
////@Column(name = "PYMT_AUTHORISTN_SET_REF")
////    private Integer pymtAuthoristnSetRef;
//
//@Column(name = "MAN_PAY_OVER")
//    private Integer manPayOver;
//
//@Column(name = "PYMT_STAMP")
//    private String pymtStamp;
//
//@Column(name = "AUTHORISTN_IN_PROGRESS")
//    private Integer authoristnInProgress;
//
//@Column(name = "SPLIT_IN_PROGRESS")
//    private Integer splitInProgress;
//
@Column(name = "VCHR_NUM")
    private String vchrNum;

//@Column(name = "JNL_CLASS_CODE")
//    private String jnlClassCode;
//
//@Column(name = "ORIGINATOR_ID")
//    private String originatorId;
//
//@Column(name = "ORIGINATED_DATETIME")
//    private Date originatedDatetime;
//
//@Column(name = "LAST_CHANGE_USER_ID")
//    private String lastChangeUserId;
//
//@Column(name = "LAST_CHANGE_DATETIME")
//    private Date lastChangeDatetime;
//
//@Column(name = "AFTER_PSTG_ID")
//    private String after_pstg_id;
//
//@Column(name = "AFTER_PSTG_DATETIME")
//    private Date afterPstgDatetime;
//
//@Column(name = "POSTER_ID")
//    private String poster_id;
//
//@Column(name = "ALLOC_ID")
//    private String allocId;
//
//@Column(name = "JNL_REVERSAL_TYPE")
//    private Integer jnlReversalType;
    @Transient
    BigDecimal saldo;

}
