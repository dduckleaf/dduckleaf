package com.greedy.dduckleaf.mockfund.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MockFundRewardCategory")
@Table(name = "TBL_PROJECT_REWARD_CATEGORY")
public class RewardCategory {

    @Id
    @Column(name = "PROJECT_CATEGORY_NO")
    private int projectCategoryNo;

    @Column(name = "PROJECT_CATEGORY_NAME")
    private String projectCategoryName;

    @OneToMany(mappedBy = "rewardCategory")
    private List<MockFundInfo> mockFundInfoList;

    public RewardCategory() {}

    public RewardCategory(int projectCategoryNo, String projectCategoryName) {
        this.projectCategoryNo = projectCategoryNo;
        this.projectCategoryName = projectCategoryName;
        this.mockFundInfoList = mockFundInfoList;
    }

    public int getProjectCategoryNo() {
        return projectCategoryNo;
    }

    public void setProjectCategoryNo(int projectCategoryNo) {
        this.projectCategoryNo = projectCategoryNo;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public List<MockFundInfo> getMockFundInfoList() {
        return mockFundInfoList;
    }

    public void setMockFundInfoList(List<MockFundInfo> mockFundInfoList) {
        this.mockFundInfoList = mockFundInfoList;
    }

    @Override
    public String toString() {
        return "RewardCategory{" +
                "projectCategoryNo=" + projectCategoryNo +
                ", projectCategoryName='" + projectCategoryName + '\'' +
                '}';
    }
}
