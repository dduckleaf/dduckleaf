package com.greedy.dduckleaf.settlement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SettlementChangedCategoryDTO {

    private int settlementChangedCategory;              //정산정보 변경 구분번호
    private String settlementChangedName;               //정산정보 변경 구분명
    private List<SettlementChangedCategoryDTO> settlementChangedCategoryList;

    @Override
    public String toString() {
        return "SettlementChangedCategory{" +
                "settlementChangedCategory=" + settlementChangedCategory +
                ", settlementChangedName='" + settlementChangedName + '\'' +
                '}';
    }
}
