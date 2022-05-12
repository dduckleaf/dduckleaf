package com.greedy.dduckleaf.funding.find.member.dto;

import com.greedy.dduckleaf.funding.dto.BankDTO;
import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.PaymentHistoryDTO;
import com.greedy.dduckleaf.funding.dto.ShippingAddressDTO;

import java.util.List;

public class FundingFindDetailInfoForMemberDTO {
    private ShippingAddressDTO shippingAddress;
    private FundingDTO funding;
    private List<BankDTO> bankList;

    public FundingFindDetailInfoForMemberDTO() {
    }

    public FundingFindDetailInfoForMemberDTO(ShippingAddressDTO shippingAddress, FundingDTO funding, List<BankDTO> bankList) {
        this.shippingAddress = shippingAddress;
        this.funding = funding;
        this.bankList = bankList;
    }

    public ShippingAddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public FundingDTO getFunding() {
        return funding;
    }

    public List<BankDTO> getBankList() {
        return bankList;
    }

    public void setShippingAddress(ShippingAddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setFunding(FundingDTO funding) {
        this.funding = funding;
    }

    public void setBankList(List<BankDTO> bankList) {
        this.bankList = bankList;
    }

    @Override
    public String toString() {
        return "FundingFindDetailInfoForMemberDTO{" +
                "shippingAddress=" + shippingAddress +
                ", funding=" + funding +
                ", bankList=" + bankList +
                '}';
    }
}
