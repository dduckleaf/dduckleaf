package com.greedy.dduckleaf.myfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "ProjectForMyFunding")
@Table(name = "TBL_PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PROGRESS_STATUS")
    private ProjectProgressStatus projectProgressStatus;
}
