package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

@Entity(name = "ShippingForShippingStatus")
@Table(name = "TBL_SHIPPING_STATUS")
public class ShippingStatus {

    @Id
    @Column(name = "SHIPPING_STATUS_NO")
    private int shippingStatusNo;       //발송 상태 번호

    @Column(name = "SHIPPING_STATUS_NAME")
    private String shippingStatusName;  //발송 상태 이름

    public ShippingStatus() {}

    public ShippingStatus(int shippingStatusNo, String shippingStatusName) {
        this.shippingStatusNo = shippingStatusNo;
        this.shippingStatusName = shippingStatusName;
    }

    public int getShippingStatusNo() {
        return shippingStatusNo;
    }

    public void setShippingStatusNo(int shippingStatusNo) {
        this.shippingStatusNo = shippingStatusNo;
    }

    public String getShippingStatusName() {
        return shippingStatusName;
    }

    public void setShippingStatusName(String shippingStatusName) {
        this.shippingStatusName = shippingStatusName;
    }

    @Override
    public String toString() {
        return "ShippingStatus{" +
                "shippingStatusNo=" + shippingStatusNo +
                ", shippingStatusName='" + shippingStatusName + '\'' +
                '}';
    }
}
