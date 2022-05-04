package com.greedy.dduckleaf.projectreport.find.dto;
import com.greedy.dduckleaf.projectreport.find.entity.Policy;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PolicyContentDTO {

    private int policyContentNo;                                    //약관 및 규정 정책 본문 번호
    private Policy policy;                                          //약관 및 규정 정책 번호
    private String policyContentTitle;                                //정책 제목
    private String policyContentDetailContent;                      //정책 내용

    @Override
    public String toString() {
        return "PolicyContent{" +
                "policyContentNo=" + policyContentNo +
                ", policy=" + policy +
                ", policyContentTitle=" + policyContentTitle +
                ", policyContentDetailContent='" + policyContentDetailContent + '\'' +
                '}';
    }
}
