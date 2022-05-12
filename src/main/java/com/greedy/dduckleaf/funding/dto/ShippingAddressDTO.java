package com.greedy.dduckleaf.funding.dto;

public class ShippingAddressDTO {

    private String shippingMemberName;
    private String shippingMemberPhone;
    private String zipCode;
    private String address1;
    private String address2;
    private String shippingRequire;
    private int fundingInfoNo;

    public ShippingAddressDTO() {
    }

    public ShippingAddressDTO(String shippingMemberName, String shippingMemberPhone, String zipCode, String address1, String address2, String shippingRequire, int fundingInfoNo) {
        this.shippingMemberName = shippingMemberName;
        this.shippingMemberPhone = shippingMemberPhone;
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
        this.shippingRequire = shippingRequire;
        this.fundingInfoNo = fundingInfoNo;
    }

    public String getShippingMemberName() {
        return shippingMemberName;
    }

    public String getShippingMemberPhone() {
        return shippingMemberPhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getShippingRequire() {
        return shippingRequire;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setShippingMemberName(String shippingMemberName) {
        this.shippingMemberName = shippingMemberName;
    }

    public void setShippingMemberPhone(String shippingMemberPhone) {
        this.shippingMemberPhone = shippingMemberPhone;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setShippingRequire(String shippingRequire) {
        this.shippingRequire = shippingRequire;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    @Override
    public String toString() {
        return "ShippingAddressDTO{" +
                "shippingMemberName='" + shippingMemberName + '\'' +
                ", shippingMemberPhone='" + shippingMemberPhone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", shippingRequire='" + shippingRequire + '\'' +
                ", fundingInfoNo=" + fundingInfoNo +
                '}';
    }
}
