package com.greedy.dduckleaf.settlement.calculate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RefundingInfoForSettlement")
@Table(name = "TBL_REFUNDING")
public class RefundingInfo {

    @Id
    @Column(name = "REFUNDING_INFO_NO")
    private int refundingInfoNo;                    //환불 신청 번호

    @Column(name = "REFUNDING_DATE")
    private String refundingDate;                   //환불 신청일

    @Transient
    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;                //환불 구분 번호

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REFUNDING_STATUS_NO")
    private RefundingStatus refundingStatus;        //환불상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                        //프로젝트 번호

    @Column(name = "REFUNDING_END_DATE")
    private String refundingEndDate;                //환불처리종료일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private FundingInfo fundingInfo;                //펀딩내역번호

    @Override
    public String toString() {
        return "RefundingInfo{" +
                "refundingInfoNo=" + refundingInfoNo +
                ", refundingDate='" + refundingDate + '\'' +
                ", refundingCategoryNo=" + refundingCategoryNo +
                ", refundingStatus=" + refundingStatus +
                ", project=" + project +
                ", refundingEndDate='" + refundingEndDate + '\'' +
                '}';
    }
}
