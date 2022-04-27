package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerFinancialInfoForProjectApplication")
@Table(name = "TBL_FARMER_FINANCIAL_INFO")
@DynamicInsert
public class FarmerFinancialInfo {

    @Id
    @Column(name = "FINANCIAL_INFO_NO")
    private int financialInfoNo;

    @Column(name = "FARMER_NO")
    private int farmerNo;               //파머번호

    @Column(name = "BANK_NO")
    private int bankNo;                 //은행번호

    @Column(name = "TAX_RECEIVE_EMAIL")
    private String taxReceiveEmail;     //세금계산서 발행 이메일

    @Column(name = "FARMER_ACCOUNT")
    private String farmerAccount;       //계좌번호

    @Column(name = "FARMER_NAME")
    private String farmerName;          //예금주

    @Override
    public String toString() {
        return "FarmerFinancialInfo{" +
                "financialInfoNo=" + financialInfoNo +
                ", farmerNo=" + farmerNo +
                ", bankNo=" + bankNo +
                ", taxReceiveEmail='" + taxReceiveEmail + '\'' +
                ", farmerAccount='" + farmerAccount + '\'' +
                ", farmerName='" + farmerName + '\'' +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.farmerName = this.farmerName  == null ? "예금주" : this.farmerName ;
        this.taxReceiveEmail = this.taxReceiveEmail  == null ? "세금계산서 발행 이메일" : this.taxReceiveEmail ;
        this.farmerAccount = this.farmerAccount  == null ? "계좌번호" : this.farmerAccount ;

    }
}
