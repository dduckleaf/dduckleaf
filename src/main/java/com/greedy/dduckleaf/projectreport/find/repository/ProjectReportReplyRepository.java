package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ProjectReportReplyRepository
 * Comment : ProjectReportReply 엔티티를 이용하여 구현한 엔티티 저장소 입니다.
 *
 * History
 * 2022-04-24 (장민주) 프로젝트 신고번호로 해당 신고의 답변 조회용 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public interface ProjectReportReplyRepository extends JpaRepository<ProjectReportReply, Integer> {

    /**
     * findAllByProjectReport_ProjectReportNoAndDeleteYn: 프로젝트 신고번호로 해당 프로젝트신고의 답변 데이터를 요청하는 메소드입니다.
     * @param projectReportNo 프로젝트 신고번호
     * @param deleteYn 삭제 여부
     * @return 해당 프로젝트신고에 대한 답변 데이터를 저장하는 엔티티
     * @author 장민주
     */
    ProjectReportReply findAllByProjectReport_ProjectReportNoAndDeleteYn(int projectReportNo, String deleteYn);
}
