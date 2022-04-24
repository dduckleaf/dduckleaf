package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Funding")
@Table(name = "TBL_FUNDING_INFO")
public class Funding {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fundingInfoNo;

    @Column(name = "FUNDING_DATE")
    private java.sql.Date fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "PROJECT_NO")
    private Project project;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "SHIPPING_FEE_NO")
    private ProjectShippingFee projectShippingFee;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "EXTRA_SHIPPING_FEE_STATUS")
    private String extraShippingFeeStatus;

    @Column(name = "REFUND_BANK_CODE")
    private int refundBankCode;

    @Column(name = "REFUND_ACCOUNT")
    private int refundAccount;

    @Override
    public String toString() {
        return "Funding{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate=" + fundingDate +
                ", fundingAmount=" + fundingAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", donateAmount=" + donateAmount +
                ", project=" + project +
                ", projectShippingFee=" + projectShippingFee +
                ", memberNo=" + memberNo +
                ", extraShippingFeeStatus='" + extraShippingFeeStatus + '\'' +
                ", refundBankCode=" + refundBankCode +
                ", refundAccount=" + refundAccount +
                '}';
    }
}
