package com.greedy.dduckleaf.shippingmanagement.dto;

public class ShippingAddressDTO {

    private int shippingAddressNo;          //배송지 번호
    private String shippingAddress;         //배송지 주소
    private FundingInfoDTO fundingInfo;     //펀딩 신청 내역 정보

    public ShippingAddressDTO() {}

    public ShippingAddressDTO(int shippingAddressNo, String shippingAddress, FundingInfoDTO fundingInfo) {
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

    public FundingInfoDTO getFundingInfo() {
        return fundingInfo;
    }

    public void setFundingInfo(FundingInfoDTO fundingInfo) {
        this.fundingInfo = fundingInfo;
    }

    @Override
    public String toString() {
        return "ShippingAddressDTO{" +
                "shippingAddressNo=" + shippingAddressNo +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}
