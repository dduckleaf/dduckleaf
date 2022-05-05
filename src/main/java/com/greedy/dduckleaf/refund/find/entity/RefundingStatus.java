package com.greedy.dduckleaf.refund.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "RefundingStatusForRefundingFind")
@Table(name = "TBL_REFUNDING_STATUS")
public class RefundingStatus {
    @Id
    @Column(name = "REFUNDING_STATUS_NO")
    private int refundingStatusNo;

    @Column(name = "REFUNDING_STATUS_NAME")
    private String refundingStatusName;

}
