package com.greedy.dduckleaf.refund.find.entity;


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
@Entity(name = "RefundingCategoryForRefundingFind")
@Table(name = "TBL_REFUNDING_CATEGORY")
public class RefundingCategory {

    @Id
    @Column(name = "REFUNDING_CATEGORY_NO")
    private int refundingCategoryNo;

    @Column(name = "REFUNDING_CATEGORY_NAME")
    private String refundingCategoryName;
}
