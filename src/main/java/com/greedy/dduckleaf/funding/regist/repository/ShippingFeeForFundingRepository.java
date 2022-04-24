package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.ProjectShippingFee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingFeeForFundingRepository extends JpaRepository<ProjectShippingFee, Integer> {
    ProjectShippingFee findProjectShippingFeeForFundingRegistByProjectNo(int projectNo);

}
