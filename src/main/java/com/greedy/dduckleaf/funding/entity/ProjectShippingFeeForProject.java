package com.greedy.dduckleaf.funding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectShippingFeeForFundingRegistProject")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
public class ProjectShippingFeeForProject {


    @Column(name = "SHIPPING_FEE_NO")
    private int shppingFeeNo;


    @Column(name = "SHIPPING_FEE")
    private int shippingFee;

    @Column(name = "EXTRA_SHIPPING_FEE")
    private int extraShippingFee;


    @Column(name = "EXTRA_SHIPPING_FEE_INFO")
    private String extraShippingFeeInfo;

    @Id
    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Override
    public String toString() {
        return "ProjectShippingFee{" +
                "shppingFeeNo=" + shppingFeeNo +
                ", shippingFee=" + shippingFee +
                ", extraShippingFee=" + extraShippingFee +
                ", extraShippingFeeInfo='" + extraShippingFeeInfo + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}
