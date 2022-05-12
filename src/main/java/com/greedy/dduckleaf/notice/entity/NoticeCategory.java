package com.greedy.dduckleaf.notice.entity;

import javax.persistence.*;

@Entity(name = "NoticeCategory")
@Table(name = "TBL_NOTICE_CATEGORY")
public class NoticeCategory {

    @Id
    @Column(name = "NOTICE_CATEGORY_NO")
    private int noticeCategoryNo;

    @Column(name = "NOTICE_CATEGORY_NAME")
    private String noticeCategoryName;

    public NoticeCategory() {}

    public NoticeCategory(int noticeCategoryNo, String noticeCategoryName) {
        this.noticeCategoryNo = noticeCategoryNo;
        this.noticeCategoryName = noticeCategoryName;
    }

    public int getNoticeCategoryNo() {
        return noticeCategoryNo;
    }

    public void setNoticeCategoryNo(int noticeCategoryNo) {
        this.noticeCategoryNo = noticeCategoryNo;
    }

    public String getNoticeCategoryName() {
        return noticeCategoryName;
    }

    public void setNoticeCategoryName(String noticeCategoryName) {
        this.noticeCategoryName = noticeCategoryName;
    }

    @Override
    public String toString() {
        return "NoticeCategory{" +
                "noticeCategoryNo=" + noticeCategoryNo +
                ", noticeCategoryName='" + noticeCategoryName + '\'' +
                '}';
    }
}
