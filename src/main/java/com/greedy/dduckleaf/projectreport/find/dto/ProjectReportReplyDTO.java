package com.greedy.dduckleaf.projectreport.find.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectReportReplyDTO {

    private int projectReportReplyNo;               //신고답변번호
    private String projectReportReplyContent;       //답변내용
    private Date projectReportReplyDate;            //답변발신일
    private int projectReportNo;                    //신고번호
    private int adminNo;                            //신고 답변 관리자
    private String deleteYn;                        //삭제여부
}
