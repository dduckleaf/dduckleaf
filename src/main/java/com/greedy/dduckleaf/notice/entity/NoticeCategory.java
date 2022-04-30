package com.greedy.dduckleaf.notice.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "NoticeCategory")
@Table(name = "TBL_NOTICE_CATEGORY")
public class NoticeCategory {

    @Id
    @Column(name = "NOTICE_CATEGORY_NO")
    private int noticeCategoryNo;

    @Column(name = "NOTICE_CATEGORY_NAME")
    private String noticeCategoryName;
}
