package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementChangedCategory")
@Table(name = "TBL_SETTLEMENT_CHANGED_CATEGORY")
public class SettlementChangedCategory {

    @Id
    @Column(name = "SETTLEMENT_CHANGED_CATEGORY")
    private int settlementChangedCategory;                          //정산정보 변경 구분 번호

    @Column(name = "SETTLEMENT_CHANGED_NAME")
    private String settlementChangedName;                           //정산정보 변경 구분명

    @Override
    public String toString() {
        return "SettlementChangedCategory{" +
                "settlementChangedCategory=" + settlementChangedCategory +
                ", settlementChangedName='" + settlementChangedName + '\'' +
                '}';
    }
}
