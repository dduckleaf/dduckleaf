package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementOverview {

    private SettlementInfoDTO settlementInfo;
    private List<SettlementPaymentInfoDTO> settlementPaymentInfos;

    public SettlementOverview() {}

    public SettlementOverview(SettlementInfoDTO settlementInfo, List<SettlementPaymentInfoDTO> settlementPaymentInfos) {
        this.settlementInfo = settlementInfo;
        this.settlementPaymentInfos = settlementPaymentInfos;
    }

    public SettlementInfoDTO getSettlementInfo() {
        return settlementInfo;
    }

    public void setSettlementInfo(SettlementInfoDTO settlementInfo) {
        this.settlementInfo = settlementInfo;
    }

    public List<SettlementPaymentInfoDTO> getSettlementPaymentInfos() {
        return settlementPaymentInfos;
    }

    public void setSettlementPaymentInfos(List<SettlementPaymentInfoDTO> settlementPaymentInfos) {
        this.settlementPaymentInfos = settlementPaymentInfos;
    }

    @Override
    public String toString() {
        return "SettlementOverview{" +
                "settlementInfo=" + settlementInfo +
                ", settlementPaymentInfos=" + settlementPaymentInfos +
                '}';
    }
}
