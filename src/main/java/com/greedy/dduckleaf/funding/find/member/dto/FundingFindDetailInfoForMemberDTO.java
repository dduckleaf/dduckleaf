package com.greedy.dduckleaf.funding.find.member.dto;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.PaymentHistoryDTO;
import com.greedy.dduckleaf.funding.dto.ShippingAddressDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingFindDetailInfoForMemberDTO {
    private ShippingAddressDTO shippingAddress;
    private FundingDTO funding;
    private PaymentHistoryDTO paymentHistory;
}
