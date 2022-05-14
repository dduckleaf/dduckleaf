package com.greedy.dduckleaf.funding.dto;

public class CancelFundingDTO {
    private int cancelFundingNo;
    private int cancelFundingCategoryNo;
    private String cancelFundingContent;
    private int fundingInfoNo;

    public CancelFundingDTO() {
    }

    public CancelFundingDTO(int cancelFundingNo, int cancelFundingCategoryNo, String cancelFundingContent, int fundingInfoNo) {
        this.cancelFundingNo = cancelFundingNo;
        this.cancelFundingCategoryNo = cancelFundingCategoryNo;
        this.cancelFundingContent = cancelFundingContent;
        this.fundingInfoNo = fundingInfoNo;
    }

    public int getCancelFundingNo() {
        return cancelFundingNo;
    }

    public void setCancelFundingNo(int cancelFundingNo) {
        this.cancelFundingNo = cancelFundingNo;
    }

    public int getCancelFundingCategoryNo() {
        return cancelFundingCategoryNo;
    }

    public void setCancelFundingCategoryNo(int cancelFundingCategoryNo) {
        this.cancelFundingCategoryNo = cancelFundingCategoryNo;
    }

    public String getCancelFundingContent() {
        return cancelFundingContent;
    }

    public void setCancelFundingContent(String cancelFundingContent) {
        this.cancelFundingContent = cancelFundingContent;
    }

    public int getFundingInfoNo() {
        return fundingInfoNo;
    }

    public void setFundingInfoNo(int fundingInfoNo) {
        this.fundingInfoNo = fundingInfoNo;
    }

    @Override
    public String toString() {
        return "CancelFundingDTO{" +
                "cancelFundingNo=" + cancelFundingNo +
                ", cancelFundingCategoryNo=" + cancelFundingCategoryNo +
                ", cancelFundingContent='" + cancelFundingContent + '\'' +
                ", fundingInfoNo=" + fundingInfoNo +
                '}';
    }
}
