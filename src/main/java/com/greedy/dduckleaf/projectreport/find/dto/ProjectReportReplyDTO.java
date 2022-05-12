package com.greedy.dduckleaf.projectreport.find.dto;

public class ProjectReportReplyDTO {

    private int projectReportReplyNo;               //신고답변번호
    private String projectReportReplyContent;       //답변내용
    private String projectReportReplyDate;            //답변발신일
    private int projectReportNo;                    //신고번호
    private int adminNo;                            //신고 답변 관리자
    private String deleteYn;                        //삭제여부

    public ProjectReportReplyDTO() {}

    public ProjectReportReplyDTO(int projectReportReplyNo, String projectReportReplyContent, String projectReportReplyDate,
                                 int projectReportNo, int adminNo, String deleteYn) {
        this.projectReportReplyNo = projectReportReplyNo;
        this.projectReportReplyContent = projectReportReplyContent;
        this.projectReportReplyDate = projectReportReplyDate;
        this.projectReportNo = projectReportNo;
        this.adminNo = adminNo;
        this.deleteYn = deleteYn;
    }

    public int getProjectReportReplyNo() {
        return projectReportReplyNo;
    }

    public void setProjectReportReplyNo(int projectReportReplyNo) {
        this.projectReportReplyNo = projectReportReplyNo;
    }

    public String getProjectReportReplyContent() {
        return projectReportReplyContent;
    }

    public void setProjectReportReplyContent(String projectReportReplyContent) {
        this.projectReportReplyContent = projectReportReplyContent;
    }

    public String getProjectReportReplyDate() {
        return projectReportReplyDate;
    }

    public void setProjectReportReplyDate(String projectReportReplyDate) {
        this.projectReportReplyDate = projectReportReplyDate;
    }

    public int getProjectReportNo() {
        return projectReportNo;
    }

    public void setProjectReportNo(int projectReportNo) {
        this.projectReportNo = projectReportNo;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }

    @Override
    public String toString() {
        return "ProjectReportReplyDTO{" +
                "projectReportReplyNo=" + projectReportReplyNo +
                ", projectReportReplyContent='" + projectReportReplyContent + '\'' +
                ", projectReportReplyDate='" + projectReportReplyDate + '\'' +
                ", projectReportNo=" + projectReportNo +
                ", adminNo=" + adminNo +
                ", deleteYn='" + deleteYn + '\'' +
                '}';
    }
}
