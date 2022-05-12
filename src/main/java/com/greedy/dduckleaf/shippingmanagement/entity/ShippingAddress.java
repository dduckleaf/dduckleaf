package com.greedy.dduckleaf.shippingmanagement.entity;

import javax.persistence.*;

@Entity(name = "ShippingForShippingAddress")
@Table(name = "TBL_SHIPPING_ADDRESS")
public class ShippingAddress {

    @Id
    @Column(name = "SHIPPING_ADDRESS_NO")
    private int shippingAddressNo;      //배송지 번호

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;     //배송지 주소

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FUNDING_INFO_NO")
    private FundingInfo fundingInfo;    //펀딩 신청 내역 정보

    public ShippingAddress() {}

    public ShippingAddress(int shippingAddressNo, String shippingAddress, FundingInfo fundingInfo) {
        this.shippingAddressNo = shippingAddressNo;
        this.shippingAddress = shippingAddress;
        this.fundingInfo = fundingInfo;
    }

    public int getShippingAddressNo() {
        return shippingAddressNo;
    }

    public void setShippingAddressNo(int shippingAddressNo) {
        this.shippingAddressNo = shippingAddressNo;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public FundingInfo getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfo fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "shippingAddressNo=" + shippingAddressNo +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}
