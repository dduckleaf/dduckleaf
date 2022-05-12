package com.greedy.dduckleaf.funding.regist.repository;

import com.greedy.dduckleaf.funding.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * Class : ProjectFundingRegistRepository
 * Comment : 펀딩 조회
 *
 * History
 * 2022-05-10 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
public interface ProjectFundingRegistRepository extends JpaRepository<Project, Integer> {

}
