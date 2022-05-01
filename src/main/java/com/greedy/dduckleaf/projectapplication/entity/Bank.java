package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "Bank")
@Table(name = "TBL_BANK")
@DynamicInsert
public class Bank {

    @Id
    @Column(name = "BANK_NO")
    private int bankNo;

    @Column(name = "BANK_NAME")
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<FarmerFinancialInfo> financialInfoList;

    @Override
    public String toString() {
        return "Bank{" +
                "bankNo=" + bankNo +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
