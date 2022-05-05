package com.greedy.dduckleaf.platformqa.entity;

import lombok.*;

import javax.persistence.*;

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
