package com.greedy.dduckleaf.shippingmanagement.dto;

import lombok.*;

import java.util.List;

public class ExamineProjectStatusDTO {

    private int examineProjectStatusCode;       //심사중 프로젝트 상태 코드
    private String examineProjectStatusName;    //심사중 프로젝트 상태 이름

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
