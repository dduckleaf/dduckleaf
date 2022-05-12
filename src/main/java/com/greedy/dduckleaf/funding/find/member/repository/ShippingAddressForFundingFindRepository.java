package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ShippingAddressForFundingFindRepository
 * Comment : 배송지를 담당하는 엔티티의 쿼리를 수행하는 레파지토리.
 *
 * History
 * 2022-05-02 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ShippingAddressForFundingFindRepository extends JpaRepository<ShippingAddress, Integer> {

    ShippingAddress findByFunding_fundingInfoNo(int fundingNo);
}
