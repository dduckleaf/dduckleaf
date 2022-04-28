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
@Table(name = "TBL_PROJECT_SHIPPING_INFO")
@DynamicInsert
public class ProjectShippingInfo {

    @Id
    @Column(name = "PROJECT_SHIPPING_INFO_NO")
    private int projectShippingInfoNo;

    @Column(name = "SHIPPING_FEE")
//    @ColumnDefault("0")
    private int shippingFee;

    @Column(name = "SHIPPING_DUE_DATE")
//    @Temporal(value = TemporalType.TIMESTAMP)
//    @ColumnDefault("")
    private java.sql.Date shippingDueDate;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "EXTRA_SHIPPING_FEE")
//    @ColumnDefault("0")
    private int extraShippingFee;

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

        this.shippingDueDate = this.shippingDueDate  == null ? Date.valueOf(LocalDate.now()) : this.shippingDueDate ;

    }
}