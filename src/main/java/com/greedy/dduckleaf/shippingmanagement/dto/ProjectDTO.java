package com.greedy.dduckleaf.shippingmanagement.dto;

import lombok.*;

/**
 * <pre>
 * Class : ProjectDTO
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectNo;
    private String projectName;
    private int fundTargetAmount;
    private String openDate;
    private String endDate;
    private String projectStatus;
    private double achievementRate;
    private ExamineProjectStatusDTO examineStatus;
    private String projectExamineStatus;
    private ProjectProgressStatusDTO progressStatus;
    private int maxTargetAmount;
    private MemberDTO farmer;
}
