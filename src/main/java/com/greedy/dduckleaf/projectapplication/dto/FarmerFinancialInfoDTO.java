package com.greedy.dduckleaf.projectapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FarmerFinancialInfoDTO { //파머 금융정보

    private int financialInfoNo;
    private int farmerNo;               //파머번호
    private int bankNo;                 //은행번호
    private String taxReceiveEmail;     //세금계산서 발행 이메일
    private String farmerAccount;       //계좌번호
    private String farmerName;          //예금주

}
