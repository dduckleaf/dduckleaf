package com.greedy.dduckleaf.funding.find.member.repository;

import com.greedy.dduckleaf.funding.entity.Funding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : FundingForMemberFindRepository
 * Comment :
 *
 * History
 * 2022-04-25 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
public interface FundingForMemberFindRepository extends JpaRepository<Funding, Integer> {

    List<Funding> findByMemberNo(int memberNo);}
