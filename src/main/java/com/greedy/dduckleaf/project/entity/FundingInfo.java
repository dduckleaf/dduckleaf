package com.greedy.dduckleaf.project.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FundingInfoForProjectDetail")
@Table(name = "TBL_FUNDING_INFO")
public class FundingInfo {

    @Id
    @Column(name = "FUNDING_INFO_NO")
    private int fundingInfoNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Override
    public String toString() {
        return "FundingInfo{" +
                "fundingInfoNo=" + fundingInfoNo +
                ", memberNo=" + memberNo +
                ", projectNo=" + projectNo +
                '}';
    }
}
