package com.greedy.dduckleaf.refund.regist.entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * <pre>
 * Class : Refunding
 * Comment :
 *
 * History
 * 2022-05-03 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public class Refunding {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;

    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;

    @Column(name = "REFUNDING_REASON")
    private String refundingReason;

    @Column(name = "REFUNDING_STATUS")
    private String refundingStatus;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "REFUNDING_ACCOUNT")
    private String refundingAccount;

    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "REFUNDING_MEMBER_NAME")
    private String refundingMemberName;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PAYMENT_HISTORY_NO")
    private int paymentHistoryNo;

}
