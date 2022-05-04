package com.greedy.dduckleaf.projectapplication.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.RewardRegistInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Interface : RewardRegistInfoRepository
 * Comment : 프로젝트 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성
 * 2022/04/27 (박휘림) findByProjectNo 메소드 작성
 * </pre>
 * @version 1.0.2
 * @author 박휘림
 */
public interface RewardRegistInfoRepository extends JpaRepository<RewardRegistInfo, Integer> {

    RewardRegistInfo findByProjectNo(int projectNo);
}
