package com.greedy.dduckleaf.settlement.calculate.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FundingInfoForSettlement")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;                  //펀딩 신청내역 번호

    @Column(name = "FUNDING_AMOUNT")
    private int fundingAmount;                  //펀딩금

    @Column(name = "DONATE_AMOUNT")
    private int donateAmount;                   //후원금

    @Column(name = "FUNDING_STATUS")
    private String fundingStatus;               //펀딩상태

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_NO")
    private Project project;                    //프로젝트 번호

    @OneToMany(mappedBy = "fundingInfo")
    private List<RefundingInfo> refundingInfos;

    @Override
    public String toString() {
        return "FundingInfo{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", fundingAmount=" + fundingAmount +
                ", donateAmount=" + donateAmount +
                ", fundingStatus='" + fundingStatus + '\'' +
                ", project=" + project +
                '}';
    }
}
