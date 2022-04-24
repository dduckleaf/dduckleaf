package com.greedy.dduckleaf.notice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : Admin
 * Comment :
 *
 * History
 * 2022-04-24 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@Entity(name = "AdminForNotice")
@Table(name = "TBL_MEMBER")
public class Admin {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;
}
