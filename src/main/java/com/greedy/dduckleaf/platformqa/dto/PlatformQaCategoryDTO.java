package com.greedy.dduckleaf.platformqa.dto;

public class PlatformQaCategoryDTO {

    private int platformQaCategoryNo;
    private String platformQaCategoryName;

    public PlatformQaCategoryDTO() {}

    public PlatformQaCategoryDTO(int platformQaCategoryNo, String platformQaCategoryName) {
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
        return "PlatformQaCategoryDTO{" +
                "platformQaCategoryNo=" + platformQaCategoryNo +
                ", platformQaCategoryName='" + platformQaCategoryName + '\'' +
                '}';
    }
}
