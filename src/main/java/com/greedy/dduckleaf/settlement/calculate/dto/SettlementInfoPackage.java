package com.greedy.dduckleaf.settlement.calculate.dto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SettlementInfoPackage {

    private SettlementInfoDTO settlementInfo;
    private ProjectApplyFeeInfoDTO feeInfo;
    private List<SettlementPaymentInfoDTO> settlementPaymentInfos;
}
