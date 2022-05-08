package com.greedy.dduckleaf.farmingrecord.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "FarmingRecord")
@Table(name = "TBL_FARMING_RECORD")
public class FarmingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FARMING_RECORD_NO")
    private int farmingRecordNo;

    @Column(name = "PROJECT_NO")
    private int projectNo;

    @Column(name = "FARMING_RECORD_TITLE")
    private String farmingRecordTitle;

    @Column(name = "FARMING_RECORD_CONTENT")
    private String farmingRecordContent;

    @Column(name = "FARMING_RECORD_UPLOAD_DATE")
    private String farmingRecordUploadDate;

    @Column(name = "PUBLIC_STATUS")
    private String publicStatus;

    @Column(name = "FARMING_RECORD_STATUS")
    private String farmingRecordStatus;

    @Column(name = "FARMING_RECORD_COUNT")
    private int farmingRecordCount;

    @Column(name = "FARMER_NO")
    private int farmerNo;

}
