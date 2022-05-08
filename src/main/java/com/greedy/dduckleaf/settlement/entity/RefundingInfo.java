//package com.greedy.dduckleaf.settlement.entity;
//import com.greedy.dduckleaf.settlement.calculate.entity.RefundingStatus;
//import lombok.*;
//
//import javax.persistence.*;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@Entity(name = "RefundingInfoForSettlement")
//@Table(name = "TBL_REFUNDING")
//public class RefundingInfo {
//
//    @Id
//    @Column(name = "")
//    private int refundingInfo;
//
//    @Column(name = "")
//    private String refundingDate;
//
//    @Column(name = "REFUNDING_CATEGORY_NO")
//    private int refundingCategoryNo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "REFUNDING_STATUS_NO")
//    private RefundingStatus refundingStatus;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PROJECT_NO")
//    private Project project;
//
//    @Column(name = "REFUNDING_END_DATE")
//    private String refundingEndDate;
//}
