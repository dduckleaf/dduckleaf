package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.Project;
import com.greedy.dduckleaf.projectreport.find.entity.ProjectReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <pre>
 * Class : ProjectReportMainRepository
 * Comment : ProjectReport 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-18 (장민주) 처음 작성
 * 2022-04-22 (장민주) findAll 메소드 작성
 * 2022-04-23 (장민주) findAllProjectReport 메소드 작성
 * 2022-04-24 (장민주) findByProjectReportNo 메소드 작성
 * 2022-04-27 (장민주) findByProjectNo 메소드 작성
 * 2022-04-28 (장민주) findByProjectReportStatus 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.5
 */
public interface ProjectReportMainRepository extends JpaRepository<ProjectReport, Integer> {

    /**
     * findAll: 모든 프로젝트신고내역 목록조회용 메소드입니다.
     *
     * @param pageable 한 페이지에 출력될 데이터를 조회하기 위한 페이징정보
     * @return 한 페이지에 담길 프로젝트신고목록 리스트
     */
    Page<ProjectReport> findAll(Pageable pageable);

    /**
     * findByProjectReportStatus: 답변 대기 중인 프로젝트신고내역 목록조회용 메소드입니다.
     * @param projectReportStatus 신고 처리 상태
     * @param pageable 한 페이지에 출력될 데이터를 조회하기 위한 페이징정보
     * @return 한 페이지에 담길 프로젝트신고목록 리스트
     * @author 장민주
     */
    Page<ProjectReport> findByProjectReportStatus(String projectReportStatus, Pageable pageable);

    /**
     * findByProjectNo: 프로젝트 신고번호로 프로젝트 신고 상세내용 데이터를 조회하기 위한 메소드입니다.
     *
     * @param projectReportNo 프로젝트 신고번호
     * @return 해당하는 프로젝트 신고 상세내용
     */
    ProjectReport findByProjectReportNo(int projectReportNo);

    /**
     * findByProjectNo: 프로젝트 번호로 해당 프로젝트의 신고 목록 조회하기 위한 메소드입니다.
     * @param projectNo 프로젝트 번호
     * @param pageable  한 페이지에 출력될 데이터를 조회하기 위한 페이징정보
     * @return 한 페이지에 보여질 프로젝트신고목록
     * @author 장민주
     */
    Page<ProjectReport> findByProject_ProjectNo(@PathVariable int projectNo, Pageable pageable);
}