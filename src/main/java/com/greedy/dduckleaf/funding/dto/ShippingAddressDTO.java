package com.greedy.dduckleaf.funding.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShippingAddressDTO {

    private String shippingMemberName;
    private String shippingMemberPhone;
    private String zipCode;
    private String address1;
    private String address2;
    private String shippingRequire;

}
