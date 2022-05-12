package com.greedy.dduckleaf.platformqa.entity;

import javax.persistence.*;

@Entity(name = "PlatformQaCategory")
@Table(name = "TBL_PLATFORM_QA_CATEGORY")
public class PlatformQaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLATFORM_QA_CATEGORY_NO")
    private int platformQaCategoryNo;

    @Column(name = "PLATFORM_QA_CATEGORY_NAME")
    private String platformQaCategoryName;

    public PlatformQaCategory() {}

    public PlatformQaCategory(int platformQaCategoryNo, String platformQaCategoryName) {
        this.platformQaCategoryNo = platformQaCategoryNo;
        this.platformQaCategoryName = platformQaCategoryName;
    }

    public int getPlatformQaCategoryNo() {
        return platformQaCategoryNo;
    }

    public void setPlatformQaCategoryNo(int platformQaCategoryNo) {
        this.platformQaCategoryNo = platformQaCategoryNo;
    }

    public String getPlatformQaCategoryName() {
        return platformQaCategoryName;
    }

    public void setPlatformQaCategoryName(String platformQaCategoryName) {
        this.platformQaCategoryName = platformQaCategoryName;
    }

    @Override
    public String toString() {
        return "PlatformQaCategory{" +
                "platformQaCategoryNo=" + platformQaCategoryNo +
                ", platformQaCategoryName='" + platformQaCategoryName + '\'' +
                '}';
    }
}
