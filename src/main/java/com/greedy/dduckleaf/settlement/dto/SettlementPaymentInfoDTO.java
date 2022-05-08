package com.greedy.dduckleaf.settlement.dto;

import com.greedy.dduckleaf.settlement.calculate.dto.SettlementPaymentStandardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SettlementPaymentInfoDTO {

    private int settlementPaymentInfoNo;                            //회차별정산금지급내역번호
    private int settlementPaymentAmount;                            //지급금액
    private String farmerSettlementCheckStatus;                     //파머 확인여부
    private String settlementPaymentDate;                           //지급일
    private SettlementInfoDTO settlementInfo;                       //정산정보
    private String settlementPaymentStatus;                         //지급상태
    private SettlementPaymentStandardDTO settlementPaymentStandard;    //정산금지급기준
    private List<SettlementPaymentHistoryDTO> settlementPaymentHistoryList;

    @Override
    public String toString() {
        return "SettlementPaymentInfo{" +
                "settlementPaymentInfoNo=" + settlementPaymentInfoNo +
                ", settlementPaymentAmount=" + settlementPaymentAmount +
                ", farmerSettlementCheckStatus='" + farmerSettlementCheckStatus + '\'' +
                ", settlementPaymentDate='" + settlementPaymentDate + '\'' +
                ", settlementInfo=" + settlementInfo +
                ", settlementPaymentStatus='" + settlementPaymentStatus + '\'' +
                ", settlementPaymentStandard=" + settlementPaymentStandard +
                '}';
    }
}
