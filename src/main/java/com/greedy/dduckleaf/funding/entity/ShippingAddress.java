package com.greedy.dduckleaf.funding.entity;

import javax.persistence.*;

@Entity(name = "ShippingAddressForFunding")
@Table(name = "TBL_SHIPPING_ADDRESS")
public class ShippingAddress {

    @Id
    @Column(name = "SHIPPING_ADDRESS_NO")
    private int shippingAddresNo;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "FUNDING_INFO_NO")
    private Funding funding;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Column(name = "SHIPPING_REQUIRE")
    private String shippingRequire;

    public ShippingAddress() {
    }

    public ShippingAddress(int shippingAddresNo, Funding funding, int memberNo, String shippingAddress, String memberName, String memberPhone, String shippingRequire) {
        this.shippingAddresNo = shippingAddresNo;
        this.funding = funding;
        this.memberNo = memberNo;
        this.shippingAddress = shippingAddress;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.shippingRequire = shippingRequire;
    }

    public int getShippingAddresNo() {
        return shippingAddresNo;
    }

    public void setShippingAddresNo(int shippingAddresNo) {
        this.shippingAddresNo = shippingAddresNo;
    }

    public Funding getFunding() {
        return funding;
    }

    public void setFunding(Funding funding) {
        this.funding = funding;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getShippingRequire() {
        return shippingRequire;
    }

    public void setShippingRequire(String shippingRequire) {
        this.shippingRequire = shippingRequire;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "shippingAddresNo=" + shippingAddresNo +
                ", memberNo=" + memberNo +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", shippingRequire='" + shippingRequire + '\'' +
                '}';
    }
}
