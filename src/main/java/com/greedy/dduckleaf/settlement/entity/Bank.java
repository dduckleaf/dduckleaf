package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "BankForSettlement")
@Table(name = " TBL_BANK")
public class Bank {

    @Id
    @Column(name = "BANK_NO")
    private int bankNo;                                     //은행번호

    @Column(name =  "BANK_NAME")
    private String bankName;                                //은행명

    @OneToMany(mappedBy = "bank")
    private List<FarmerFinancialInfo> farmerFinancialInfos;

    @Override
    public String toString() {
        return "Bank{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
