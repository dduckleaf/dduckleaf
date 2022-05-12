package com.greedy.dduckleaf.projectapplication.dto;

public class ExamineProjectStatusDTO {

    private int examineProjectStatusCode;
    private String examineProjectStatusName;

    public ExamineProjectStatusDTO() {}

    public ExamineProjectStatusDTO(int examineProjectStatusCode, String examineProjectStatusName) {
        this.examineProjectStatusCode = examineProjectStatusCode;
        this.examineProjectStatusName = examineProjectStatusName;
    }

    public int getExamineProjectStatusCode() {
        return examineProjectStatusCode;
    }

    public void setExamineProjectStatusCode(int examineProjectStatusCode) {
        this.examineProjectStatusCode = examineProjectStatusCode;
    }

    public String getExamineProjectStatusName() {
        return examineProjectStatusName;
    }

    public void setExamineProjectStatusName(String examineProjectStatusName) {
        this.examineProjectStatusName = examineProjectStatusName;
    }

    @Override
    public String toString() {
        return "ExamineProjectStatusDTO{" +
                "examineProjectStatusCode=" + examineProjectStatusCode +
                ", examineProjectStatusName='" + examineProjectStatusName + '\'' +
                '}';
    }
}
