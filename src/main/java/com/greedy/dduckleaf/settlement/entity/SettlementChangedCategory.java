package com.greedy.dduckleaf.settlement.entity;

import javax.persistence.*;

@Entity(name = "SettlementChangedCategory")
@Table(name = "TBL_SETTLEMENT_CHANGED_CATEGORY")
public class SettlementChangedCategory {

    @Id
    @Column(name = "SETTLEMENT_CHANGED_CATEGORY")
    private int settlementChangedCategory;                          //정산정보 변경 구분 번호

    @Column(name = "SETTLEMENT_CHANGED_NAME")
    private String settlementChangedName;                           //정산정보 변경 구분명

    public SettlementChangedCategory() {}

    public SettlementChangedCategory(int settlementChangedCategory, String settlementChangedName) {
        this.settlementChangedCategory = settlementChangedCategory;
        this.settlementChangedName = settlementChangedName;
    }

    public int getSettlementChangedCategory() {
        return settlementChangedCategory;
    }

    public void setSettlementChangedCategory(int settlementChangedCategory) {
        this.settlementChangedCategory = settlementChangedCategory;
    }

    public String getSettlementChangedName() {
        return settlementChangedName;
    }

    public void setSettlementChangedName(String settlementChangedName) {
        this.settlementChangedName = settlementChangedName;
    }

    @Override
    public String toString() {
        return "SettlementChangedCategory{" +
                "settlementChangedCategory=" + settlementChangedCategory +
                ", settlementChangedName='" + settlementChangedName + '\'' +
                '}';
    }
}
