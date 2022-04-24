package com.greedy.dduckleaf.projectreport.find.repository;

import com.greedy.dduckleaf.projectreport.find.entity.ProjectReportReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectReportReplyRepository extends JpaRepository<ProjectReportReply, Integer> {

    /**
    * 프로젝트 신고번호로 해당 프로젝트신고의 답변 데이터를 요청하는 메소드입니다.
    *  @param projectReportNo 프로젝트 신고번호
    * @param deleteYn 삭제 여부
     * @return ProjectReportReply 해당 프로젝트신고에 대한 답변 데이터를 저장하는 엔티티
    */
    ProjectReportReply findAllByProjectReport_ProjectReportNoAndDeleteYn(int projectReportNo, String deleteYn);
}
