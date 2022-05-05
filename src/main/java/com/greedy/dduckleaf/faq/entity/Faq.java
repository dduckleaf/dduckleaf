package com.greedy.dduckleaf.faq.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity(name = "Faq")
@Table(name = "TBL_FAQ")
public class Faq {

    @Id
    @Column(name = "FAQ_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faqNo;

    @Column(name = "FAQ_TITLE")
    private String faqTitle;

    @Column(name = "FAQ_CONTENT")
    private String faqContent;

    @Column(name = "FAQ_STATUS")
    private String faqStatus;

//    @Column(name = "ADMIN_NO")
//    private int adminNo;

    @Column(name = "FAQ_SUBTITLE")
    private String faqSubTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADMIN_NO")
    private Member member;

}