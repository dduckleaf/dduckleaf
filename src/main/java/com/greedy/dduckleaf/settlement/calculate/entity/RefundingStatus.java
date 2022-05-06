package com.greedy.dduckleaf.settlement.calculate.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "RefundingStatusForSettlement")
@Table(name = "TBL_REFUNDING_STATUS")
public class RefundingStatus {

    @Id
    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;              //환불상태번호

    @Column(name = "REFUNDING_STATUS_NAME")
    private String refundingStatusName;         //환불상태명

    @Override
    public String toString() {
        return "RefundingStatus{" +
                "refundingStatusNo=" + refundingStatusNo +
                ", refundingStatusName='" + refundingStatusName + '\'' +
                '}';
    }
}
