package com.greedy.dduckleaf.settlement.calculate.dto;
import com.greedy.dduckleaf.settlement.calculate.entity.FarmerInfo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectNo;                  //프로젝트 번호
    private String projectName;             //프로젝트명
    private String openDate;                //오픈일
    private String endDate;                 //종료일
    private String achievementRate;         //달성률
    private String progressStatus;          //진행상태
    private FarmerInfo farmer;              //파머번호
}
