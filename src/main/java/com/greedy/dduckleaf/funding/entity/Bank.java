package com.greedy.dduckleaf.funding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "BankForFundingRegist")
@Table(name = "TBL_BANK")
public class Bank {

    @Id
    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Override
    public String toString() {
        return "Bank{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
