package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectReportReplyRepository
 * Comment : 프로젝트신고 업무에 사용되는 데이터조회, 데이터삽입 메소드를 작성하였습니다.
 *
 * History
 * 2022-04-24 (장민주) 프로젝트 신고번호로 해당 신고의 답변 조회용 메소드 작성
 * 2022-04-25 (장민주) 프로젝트 신고 답변 등록 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.1
 */
public interface ProjectReportReplyRepository extends JpaRepository<ProjectReportReply, Integer> {

    /**
     * findAllByProjectReport_ProjectReportNoAndDeleteYn: 프로젝트 신고번호로 해당 프로젝트신고의 답변 데이터를 요청하는 메소드입니다.
     * @param projectReportNo: 프로젝트 신고번호
     * @param deleteYn: 삭제 여부
     * @return ProjectReportReply: 해당 프로젝트신고에 대한 답변 데이터를 저장하는 엔티티
     * @author 장민주
     */
    ProjectReportReply findAllByProjectReport_ProjectReportNoAndDeleteYn(int projectReportNo, String deleteYn);
}
