package com.greedy.dduckleaf.refund.examine.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundingStatusForRefundingFarmerExamine")
@Table(name = "TBL_REFUNDING_STATUS")
public class RefundingStatus {
    @Id
    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;

    @Column(name = "REFUNDING_STATUS_NAME")
    private String refundingStatusName;

}
