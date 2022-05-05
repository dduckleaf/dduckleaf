package com.greedy.dduckleaf.projectreport.find.dto;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {

    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPwd;
    private String email;
    private String phone;
    private int memberRole;
    private String withdrawalStatus;
    List<ProjectReport> projectReportList;

}
