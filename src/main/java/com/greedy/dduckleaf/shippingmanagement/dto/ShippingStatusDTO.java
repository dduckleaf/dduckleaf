package com.greedy.dduckleaf.shippingmanagement.dto;

public class ShippingStatusDTO {

    private int shippingStatusNo;       //발송 상태 번호
    private String shippingStatusName;  //발송 상태 이름

    public ShippingStatusDTO() {}

    public ShippingStatusDTO(int shippingStatusNo, String shippingStatusName) {
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
        return "ShippingStatusDTO{" +
                "shippingStatusNo=" + shippingStatusNo +
                ", shippingStatusName='" + shippingStatusName + '\'' +
                '}';
    }
}
