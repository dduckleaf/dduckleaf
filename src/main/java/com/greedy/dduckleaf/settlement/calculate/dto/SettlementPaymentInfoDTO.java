package com.greedy.dduckleaf.settlement.calculate.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SettlementPaymentInfoDTO {

    private int settlementPaymentInfoNo;                                        //회차별정산금지급내역번호
    private int settlementPaymentAmount;                                        //지급금액
    private String farmerSettlementCheckStatus;                                 //파머 확인여부
    private String settlementPaymentDate;                                       //지급일
//    private SettlementInfoDTO settlementInfo;                                      //정산정보
    private String settlementPaymentStatus;                                     //지급상태
    private SettlementPaymentStandardDTO settlementPaymentStandard;             //정산금지급기준

}
