package com.greedy.dduckleaf.settlement.calculate.dto;

import com.greedy.dduckleaf.settlement.calculate.entity.FundingInfo;
import com.greedy.dduckleaf.settlement.calculate.entity.Project;
import com.greedy.dduckleaf.settlement.calculate.entity.RefundingInfo;
import com.greedy.dduckleaf.settlement.calculate.entity.RefundingStatus;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FundingInfoDTO {

    private int fundingInfoNo;                  //펀딩 신청내역 번호
    private int fundingAmount;                  //펀딩금
    private int donateAmount;                   //후원금
    private String fundingStatus;               //펀딩상태
    private Project project;                    //프로젝트 번호

}
