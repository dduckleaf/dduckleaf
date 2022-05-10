package com.greedy.dduckleaf.refund.find.dto;

import com.greedy.dduckleaf.refund.find.entity.Farmer;
import com.greedy.dduckleaf.refund.find.entity.ProjectProgressStatus;
import com.greedy.dduckleaf.refund.find.entity.RewardInfo;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectForAdminListDTO {

    private int projectNo;
    private String projectName;
    private ProjectProgressStatus progressStatus;
    private Farmer farmer;
    private int fundingCount;
    private int refundingCount;
    private String openDate;
    private String endDate;
}
