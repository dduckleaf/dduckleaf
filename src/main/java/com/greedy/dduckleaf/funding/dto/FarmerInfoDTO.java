package com.greedy.dduckleaf.funding.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FarmerInfoDTO {

    private int memberNo;
    private String businessName;
}
