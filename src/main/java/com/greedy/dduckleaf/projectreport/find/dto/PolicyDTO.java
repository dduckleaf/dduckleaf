package com.greedy.dduckleaf.projectreport.find.dto;

public class PolicyDTO {

    private int policyNo;                                   //약관 및 규정 정책 번호
    private String policyRegistDate;                        //약관 및 규정 정책 등록일자
    private PolicyCategoryDTO policyCategory;                  //구분
    private String policyExpirationDate;                    //약관 및 규정 정책 만료일자
    private String policyName;                              //정책명

    public PolicyDTO() {}

    public PolicyDTO(int policyNo, String policyRegistDate, PolicyCategoryDTO policyCategory, String policyExpirationDate, String policyName) {
        this.policyNo = policyNo;
        this.policyRegistDate = policyRegistDate;
        this.policyCategory = policyCategory;
        this.policyExpirationDate = policyExpirationDate;
        this.policyName = policyName;
    }

    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyRegistDate() {
        return policyRegistDate;
    }

    public void setPolicyRegistDate(String policyRegistDate) {
        this.policyRegistDate = policyRegistDate;
    }

    public PolicyCategoryDTO getPolicyCategory() {
        return policyCategory;
    }

    public void setPolicyCategory(PolicyCategoryDTO policyCategory) {
        this.policyCategory = policyCategory;
    }

    public String getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    public void setPolicyExpirationDate(String policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNo=" + policyNo +
                ", policyRegistDate='" + policyRegistDate + '\'' +
                ", policyCategory=" + policyCategory +
                ", policyExpirationDate='" + policyExpirationDate + '\'' +
                '}';
    }
}
