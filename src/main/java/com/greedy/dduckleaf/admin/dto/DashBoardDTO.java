package com.greedy.dduckleaf.admin.dto;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DashBoardDTO {

    List<Object[]> totalFundingAmountList;
    List<Object[]> successProjectAmountList;
    List<Object[]> failedProjectAmountList;
    List<Object[]> registMemberAmountList;
    List<Object[]> removeMemberAmountList;

}
