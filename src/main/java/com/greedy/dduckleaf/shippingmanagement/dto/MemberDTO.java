package com.greedy.dduckleaf.shippingmanagement.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {

    private int memberNo;
    private String memberName;
    private FarmerDTO farmerInfo;
}
