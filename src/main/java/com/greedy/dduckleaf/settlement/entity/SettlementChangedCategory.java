package com.greedy.dduckleaf.settlement.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "SettlementChangedCategory")
@Table(name = "TBL_SETTLEMENT_CHANGED_CATEGORY")
public class SettlementChangedCategory {

    @Id
    @Column(name = "SETTLEMENT_CHANGED_CATEGORY")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //정산정보 변경 구분 번호
    private int settlementChangedCategory;

    @Column(name = "SETTLEMENT_CHANGED_NAME")
    private String settlementChangedName;               //정산정보 변경 구분명

    @OneToMany(mappedBy = "settlementChangedCategory")
    private List<SettlementChangedCategory> settlementChangedCategoryList;

    @Override
    public String toString() {
        return "SettlementChangedCategory{" +
                "settlementChangedCategory=" + settlementChangedCategory +
                ", settlementChangedName='" + settlementChangedName + '\'' +
                '}';
    }
}
