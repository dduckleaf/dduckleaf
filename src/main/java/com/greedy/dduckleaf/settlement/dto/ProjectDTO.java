package com.greedy.dduckleaf.settlement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectDTO {

    private int projectNo;                              //프로젝트번호
    private String projectName;                         //프로젝트명
    private int progressStatus;                      //진행상태
    private String projectStatus;                       //취소여부
    private int achievementRate;                        //달성률
    private int fundTargetAmount;                       //목표펀딩금액
    private FarmerInfoDTO farmer;                       //파머정보
    private String openDate;                            //오픈일
    private String endDate;                             //종료일
    private String examineStatus;                       //심사상태
    private String projectExamineStatus;                //심사결과
    private int maxTargetAmount;                        //목표최대금액

    @Override
    public String toString() {
        return "Project{" +
                "projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", achievementRate=" + achievementRate +
                ", fundTargetAmount=" + fundTargetAmount +
                ", farmer=" + farmer +
                ", openDate='" + openDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", examineStatus='" + examineStatus + '\'' +
                ", projectExamineStatus='" + projectExamineStatus + '\'' +
                ", maxTargetAmount=" + maxTargetAmount +
                '}';
    }
}
