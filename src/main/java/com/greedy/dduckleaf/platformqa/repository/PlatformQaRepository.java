package com.greedy.dduckleaf.platformqa.repository;

import com.greedy.dduckleaf.platformqa.entity.PlatformQa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PlatformRepository
 * Comment : 1:1 문의
 * History
 * 2022-05-01 (차화응) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
public interface PlatformQaRepository extends JpaRepository<PlatformQa, Integer> {
}
