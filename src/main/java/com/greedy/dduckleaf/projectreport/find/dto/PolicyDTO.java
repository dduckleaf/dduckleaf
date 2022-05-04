package com.greedy.dduckleaf.projectreport.find.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.greedy.dduckleaf.projectreport.find.entity.PolicyCategory;
import com.greedy.dduckleaf.projectreport.find.entity.PolicyContent;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PolicyDTO {

    private int policyNo;                                   //약관 및 규정 정책 번호
    private String policyRegistDate;                        //약관 및 규정 정책 등록일자
    private PolicyCategory policyCategory;                  //구분
    private String policyExpirationDate;                    //약관 및 규정 정책 만료일자
    private String policyName;                              //정책명

    @Override
    public String toString() {
        return "Policy{" +
                "policyNo=" + policyNo +
                ", policyRegistDate='" + policyRegistDate + '\'' +
                ", policyCategory=" + policyCategory +
                ", policyExpirationDate='" + policyExpirationDate + '\'' +
                '}';
    }
}
