package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "PolicyCategoryForProjectReport")
@Table(name = "TBL_POLICY_CATEGORY")
public class PolicyCategory {

    @Id
    @Column(name = "POLICY_CATEOGY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyCategoryNo;                       //구분번호

    @Column(name = "POLICY_CATEOGY_NAME")
    private String policyCategoryName;                  //구분명

    @Override
    public String toString() {
        return "PolicyCategory{" +
                "policyCategoryNo=" + policyCategoryNo +
                ", policyCategoryName='" + policyCategoryName + '\'' +
                '}';
    }
}
