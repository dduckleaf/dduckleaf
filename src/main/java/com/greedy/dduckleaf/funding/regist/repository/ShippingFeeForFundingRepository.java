package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.ProjectShippingFee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ShippingFeeForFundingRepository
 * Comment : 펀딩 조회
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ShippingFeeForFundingRepository extends JpaRepository<ProjectShippingFee, Integer> {
    ProjectShippingFee findProjectShippingFeeForFundingRegistByProjectNo(int projectNo);

}
