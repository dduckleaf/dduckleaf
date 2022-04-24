package com.greedy.dduckleaf.projectreport.find.entity;

import javax.persistence.*;

import com.greedy.dduckleaf.projectreport.detail.entity.Member;
import com.greedy.dduckleaf.projectreport.detail.entity.ProjectReport;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ProjectReportReply")
@Table(name = "TBL_PROJECT_REPORT_REPLY")
public class ProjectReportReply {

    @Id
    @Column(name = "PROJECT_REPORT_REPLY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectReportReplyNo;                       //신고답변번호

    @Column(name = "PROJECT_REPORT_REPLY_CONTENT")
    private String projectReportReplyContent;               //답변내용

    @Column(name = "PROJECT_REPORT_REPLY_DATE")
    private Date projectReportReplyDate;                    //답변발신일

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_REPORT_NO")
    private ProjectReport projectReport;                    //신고번호

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADMIN_NO")
    private Member adminNo;                                 //신고 답변 관리자

    @Column(name = "DELETE_YN")
    private String deleteYn;

    @Override
    public String toString() {
        return "ProjectReportReply{" +
                "projectReportReplyNo=" + projectReportReplyNo +
                ", projectReportReplyContent='" + projectReportReplyContent + '\'' +
                ", projectReportReplyDate=" + projectReportReplyDate +
                ", projectReport=" + projectReport +
                ", adminNo=" + adminNo +
                ", deleteYn='" + deleteYn + '\'' +
                '}';
    }
}
