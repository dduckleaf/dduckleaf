package com.greedy.dduckleaf.settlement.check.dto;

import java.util.List;

public class SettlementInfoPackage {

    private SettlementInfoDTO settlementInfo;
    private ProjectApplyFeeInfoDTO feeInfo;
    private List<SettlementPaymentInfoDTO> settlementPaymentInfos;

    public SettlementInfoPackage() {}

    public SettlementInfoPackage(SettlementInfoDTO settlementInfo, ProjectApplyFeeInfoDTO feeInfo,
                                 List<SettlementPaymentInfoDTO> settlementPaymentInfos) {
        this.settlementInfo = settlementInfo;
        this.feeInfo = feeInfo;
        this.settlementPaymentInfos = settlementPaymentInfos;
    }

    public SettlementInfoDTO getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfoDTO settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public ProjectApplyFeeInfoDTO getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(ProjectApplyFeeInfoDTO feeInfo) {
        this.feeInfo = feeInfo;
    }

    public List<SettlementPaymentInfoDTO> getSettlementPaymentInfos() {
        return settlementPaymentInfos;
    }

    public void setSettlementPaymentInfos(List<SettlementPaymentInfoDTO> settlementPaymentInfos) {
        this.settlementPaymentInfos = settlementPaymentInfos;
    }

    @Override
    public String toString() {
        return "SettlementInfoPackage{" +
                "settlementInfo=" + settlementInfo +
                ", feeInfo=" + feeInfo +
                ", settlementPaymentInfos=" + settlementPaymentInfos +
                '}';
    }
}
