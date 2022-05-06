package com.greedy.dduckleaf.main.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FarmerDTO {

    private int memberNo;
    private String businessName;
}
