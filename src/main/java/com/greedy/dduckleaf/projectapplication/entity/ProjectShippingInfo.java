package com.greedy.dduckleaf.projectapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectShippingInfoForProjectApplication")
@Table(name = "TBL_PROJECT_SHIPPING_FEE")
@DynamicInsert
public class ProjectShippingInfo {

    @Id
    @Column(name = "SHIPPING_FEE_NO")
    private int projectShippingInfoNo;

    @Column(name = "SHIPPING_FEE")
    private int shippingFee;

    @Column(name = "SHIPPING_DUE_DATE")
    private String shippingDueDate;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "EXTRA_SHIPPING_FEE")
    private int extraShippingFee;

    @Column(name = "EXTRA_SHIPPING_FEE_INFO")
    private String extraShippingFeeInfo;

    @Override
    public String toString() {
        return "ProjectShippingInfo{" +
                "projectShippingInfoNo=" + projectShippingInfoNo +
                ", shippingFee=" + shippingFee +
                ", shippingDueDate=" + shippingDueDate +
                ", projectNo=" + projectNo +
                ", extraShippingFee=" + extraShippingFee +
                '}';
    }

    @PrePersist
    public void prePersist() {

        this.shippingDueDate = this.shippingDueDate  == null ? java.sql.Date.valueOf(LocalDate.now().plusMonths(3)).toString() : this.shippingDueDate ;

    }
}