package com.greedy.dduckleaf.project.find.dto;

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
public class FarmerDTO {

    private int farmerNo;
    private String farmerName;
    private int memberNo;
    private String businessName;
}
