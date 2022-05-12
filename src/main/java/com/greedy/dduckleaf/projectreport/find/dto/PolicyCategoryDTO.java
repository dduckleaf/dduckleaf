package com.greedy.dduckleaf.projectreport.find.dto;

public class PolicyCategoryDTO {

    private int policyCategoryNo;                       //구분번호
    private String policyCategoryName;                  //구분명

    public PolicyCategoryDTO() {}

    public PolicyCategoryDTO(int policyCategoryNo, String policyCategoryName) {
        this.policyCategoryNo = policyCategoryNo;
        this.policyCategoryName = policyCategoryName;
    }

    public int getPolicyCategoryNo() {
        return policyCategoryNo;
    }

    public void setPolicyCategoryNo(int policyCategoryNo) {
        this.policyCategoryNo = policyCategoryNo;
    }

    public String getPolicyCategoryName() {
        return policyCategoryName;
    }

    public void setPolicyCategoryName(String policyCategoryName) {
        this.policyCategoryName = policyCategoryName;
    }

    @Override
    public String toString() {
        return "PolicyCategory{" +
                "policyCategoryNo=" + policyCategoryNo +
                ", policyCategoryName='" + policyCategoryName + '\'' +
                '}';
    }
}
