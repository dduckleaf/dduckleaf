package com.greedy.dduckleaf.settlement.dto;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SettlementOverview {

    private SettlementInfoDTO settlementInfo;
    private List<SettlementPaymentInfoDTO> settlementPaymentInfos;
}
