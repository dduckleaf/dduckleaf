package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerInfoForSettlement")
@Table(name = "TBL_FARMER_INFO")
public class FarmerInfo {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;                               //회원번호

    @Column(name = "FARMER_NAME")
    private String farmerName;                          //파머 이름

    @Column(name = "REPRESENTATIVE_NAME")
    private String representativeName;                  //대표자명

    @Column(name = "REPRESENTATIVE_EMAIL")
    private String representativeEmail;                 //대표자이메일

    @OneToOne(mappedBy = "farmer")
    private FarmerFinancialInfo farmerFinancialInfo;

    @OneToMany(mappedBy = "farmer")
    private List<Project> projects;

    @Override
    public String toString() {
        return "FarmerInfo{" +
                "memberNo=" + memberNo +
                ", farmerName='" + farmerName + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                '}';
    }
}
