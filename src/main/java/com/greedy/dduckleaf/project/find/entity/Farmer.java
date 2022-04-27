package com.greedy.dduckleaf.project.find.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : Farmer
 * Comment :
 *
 * History
 * 2022-04-27 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "FarmerForProjectList")
@Table(name = "TBL_FARMER_INFO")
public class Farmer {

    @Column(name = "FARMER_NO")
    private int farmerNo;

    @Column(name = "FARMER_NAME")
    private String farmerName;

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Override
    public String toString() {
        return "Farmer{" +
                "farmerNo=" + farmerNo +
                ", memberNo=" + memberNo +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
