package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.regist.entity.ProjectShippingFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShippingFeeForFundingRepository extends JpaRepository<ProjectShippingFee, Integer> {
    ProjectShippingFee findProjectShippingFeeForFundingRegistByProjectNo(int projectNo);

}
