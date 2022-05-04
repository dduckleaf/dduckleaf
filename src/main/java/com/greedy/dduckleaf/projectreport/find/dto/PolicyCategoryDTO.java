package com.greedy.dduckleaf.projectreport.find.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.greedy.dduckleaf.projectreport.find.entity.Policy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PolicyCategoryDTO {

    private int policyCategoryNo;                       //구분번호
    private String policyCategoryName;                  //구분명

    @Override
    public String toString() {
        return "PolicyCategory{" +
                "policyCategoryNo=" + policyCategoryNo +
                ", policyCategoryName='" + policyCategoryName + '\'' +
                '}';
    }
}
