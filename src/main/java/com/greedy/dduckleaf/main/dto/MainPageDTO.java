package com.greedy.dduckleaf.main.dto;

import java.util.List;

public class MainPageDTO {

    private List<ProjectDTO> dduckleafRecommendList;
    private List<ProjectDTO> rankingList;

    public MainPageDTO() {
    }

    public MainPageDTO(List<ProjectDTO> dduckleafRecommendList, List<ProjectDTO> rankingList) {
        this.dduckleafRecommendList = dduckleafRecommendList;
        this.rankingList = rankingList;
    }

    public List<ProjectDTO> getDduckleafRecommendList() {
        return dduckleafRecommendList;
    }

    public void setDduckleafRecommendList(List<ProjectDTO> dduckleafRecommendList) {
        this.dduckleafRecommendList = dduckleafRecommendList;
    }

    public List<ProjectDTO> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<ProjectDTO> rankingList) {
        this.rankingList = rankingList;
    }

    @Override
    public String toString() {
        return "MainPageDTO{" +
                "dduckleafRecommendList=" + dduckleafRecommendList +
                ", rankingList=" + rankingList +
                '}';
    }
}
