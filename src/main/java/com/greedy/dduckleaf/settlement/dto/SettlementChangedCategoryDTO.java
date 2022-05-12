package com.greedy.dduckleaf.settlement.dto;

import java.util.List;

public class SettlementChangedCategoryDTO {

    private int settlementChangedCategory;              //정산정보 변경 구분번호
    private String settlementChangedName;               //정산정보 변경 구분명
    private List<SettlementChangedCategoryDTO> settlementChangedCategoryList;

    public SettlementChangedCategoryDTO() {}

    public SettlementChangedCategoryDTO(int settlementChangedCategory, String settlementChangedName,
                                        List<SettlementChangedCategoryDTO> settlementChangedCategoryList) {
        this.settlementChangedCategory = settlementChangedCategory;
        this.settlementChangedName = settlementChangedName;
        this.settlementChangedCategoryList = settlementChangedCategoryList;
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

    public List<SettlementChangedCategoryDTO> getSettlementChangedCategoryList() {
        return settlementChangedCategoryList;
    }

    public void setSettlementChangedCategoryList(List<SettlementChangedCategoryDTO> settlementChangedCategoryList) {
        this.settlementChangedCategoryList = settlementChangedCategoryList;
    }

    @Override
    public String toString() {
        return "SettlementChangedCategory{" +
                "settlementChangedCategory=" + settlementChangedCategory +
                ", settlementChangedName='" + settlementChangedName + '\'' +
                '}';
    }
}
