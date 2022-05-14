package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

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
    private String fundingDate;

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;

    @Column(name = "REWARD_AMOUNT")
    private int rewardAmount;

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;

    @Column(name = "REFUND_NAME")
    private String refundName;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "REFUND_BANK_CODE")
    private Bank refundBankCode;

    @Column(name = "REFUND_ACCOUNT")
    private String refundAccount;

    @Override
    public String toString() {
        return "Funding{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingDate=" + fundingDate +
                ", fundingAmount=" + fundingAmount +
                ", rewardAmount=" + rewardAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", donateAmount=" + donateAmount + "\n" +
                ", project=" + project + "\n" +
                ", projectShippingFee=" + projectShippingFee + "\n" +
                ", memberNo=" + memberNo +
                ", extraShippingFeeStatus='" + extraShippingFeeStatus + '\'' +
                ", refundBankCode=" + refundBankCode +
                ", refundAccount=" + refundAccount +
                '}';
    }
}
