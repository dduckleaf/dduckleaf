package com.greedy.dduckleaf.platformqa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : Category
 * Comment : 1:1 문의 카테고리
 * History
 * 2022-05-01 (차화응)
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "PlatformQaCategory")
@Table(name = "TBL_PLATFORM_QA_CATEGORY")
public class PlatformQaCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLATFORM_QA_CATEGORY_NO")
    private int platformQaCategoryNo;

    @Column(name = "PLATFORM_QA_CATEGORY_NAME")
    private String platformQaCategoryName;
}
