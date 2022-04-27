package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.projectreport.find.dto.*;
import com.greedy.dduckleaf.projectreport.find.entity.*;
import com.greedy.dduckleaf.projectreport.find.repository.MemberForProjectReportRepository;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportReplyRepository;
import com.greedy.dduckleaf.projectreport.find.repository.ProjectReportMainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ProjectReportService
 * Comment : 프로젝트신고 업무에 사용되는 트랜젝션 메소드를 작성하였습니다.
 *
 * History
 * 2022-04-19 findProjectReportListByMemberNo 서비스메소드 작성
 * 2022-04-23 findProjectReportList 서비스메소드 작성
 * 2022-04-24 findProjectReportAndReply 서비스메소드 작성
 * 2022-04-24 findReplyByProjectReportNo 내부연산 메소드 작성
 * 2022-04-24 findProjectReportDetail 내부연산 메소드 작성
 * 2022-04-25 registProjectReportReply 서비스메소드 작성
 * 2022-04-25 registReply 서비스메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.3
 */
@Service
public class ProjectReportService {

    private final MemberForProjectReportRepository memberRepository;
    private final ProjectReportMainRepository reportRepository;
    private final ProjectReportReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectReportService(MemberForProjectReportRepository memberRepository, ProjectReportMainRepository reportRepository, ProjectReportReplyRepository replyRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
        this.replyRepository = replyRepository;
        this.modelMapper = modelMapper;
    }

    /**
    * 회원번호로 로그인한 서포터의 신고내역 목록조회용 메소드입니다.
    *  @param memberNo 로그인한 회원의 회원번호
    * @return List<ProjectReportDTO>
     *        로그인한 회원이 등록한 모든 신고내역
    */
    public List<ProjectReportDTO> findProjectReportListByMemberNo(int memberNo) {

        Member member = memberRepository.findMemberByMemberNo(memberNo);

        List<ProjectReport> projectReportList = member.getProjectReportList();

        /* 프로젝트 리스트 추출 */
        List<Project> projectList = new ArrayList<>();
        for(ProjectReport report : projectReportList) {
            projectList.add(report.getProject());
        }
        System.out.println("projectList = " + projectList);

        /* 카테고리 리스트 추출 */
        List<ReportCategory> reportCategoryList = new ArrayList<>();
        for(ProjectReport report : projectReportList) {
            reportCategoryList.add(report.getReportCategory());
        }
        System.out.println("reportCategoryList = " + reportCategoryList);

        /* 영속성을 해제하기 위해 projectList와 reportCategoryList, projetReportList를 각각 DTO타입으로 parsing한다. */
        List<ProjectDTO> projectDTOList = projectList.stream().map(project ->
                modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());

        List<ReportCategoryDTO> reportCategoryDTOList = reportCategoryList.stream().map(reportCategory ->
                modelMapper.map(reportCategory, ReportCategoryDTO.class)).collect(Collectors.toList());

        List<ProjectReportDTO> projectReportDTOList = projectReportList.stream().map(projectReport ->
                modelMapper.map(projectReport, ProjectReportDTO.class)).collect(Collectors.toList());

        System.out.println("projectReportDTOList = " + projectReportDTOList);
        System.out.println("projectDTOList = " + projectDTOList);
        System.out.println("reportCategoryDTOList = " + reportCategoryDTOList);

        for(int i = 0; i < projectDTOList.size(); i++) {
            /* projectDTO 리스트를 한행씩 꺼내 projectReportDTO에 각각 set한다. */
            projectReportDTOList.get(i).setProject(projectDTOList.get(i));
            /* reportCategoryDTO 리스트를 한행씩 꺼내 projectReportDTO에 각각 set한다. */
            projectReportDTOList.get(i).setReportCategory(reportCategoryDTOList.get(i));
        }
        projectReportDTOList.forEach(System.out::println);

        return projectReportDTOList;
    }

    /**
    * 해당 페이지의 프로젝트신고내역 목록 조회를 요청하는 메소드입니다.
    * @param pageable: 페이징에 필요한 정보를 담는 객체
    * @return Page<ProjectReportDTO>
     *        페이징 처리가 된 조회 결과를 DTO로 변환한 프로젝트신고목록
    */
    public Page<ProjectReportDTO> findProjectReportList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectReportNo").descending());

        return reportRepository.findAll(pageable).map(projectReport -> modelMapper.map(projectReport, ProjectReportDTO.class));
    }

    /**
    * 내부연산 메소드: 프로젝트 신고번호로 해당 신고의 답변 조회 요청 메소드입니다.
    * @param projectReportNo 프로젝트 신고번호
    * @param deleteYn 삭제 여부
    * @return ProjectReportReplyDTO
    *         영속성 해제를 위해 DTO 타입으로 변환해준 신고 답변 내역
    */
    private ProjectReportReplyDTO findReplyByProjectReportNo(int projectReportNo, String deleteYn) {

        return modelMapper.map(
                replyRepository.findAllByProjectReport_ProjectReportNoAndDeleteYn(projectReportNo, deleteYn)
              , ProjectReportReplyDTO.class
        );
    }

    /**
     * 내부연산 메소드: 프로젝트 신고번호로 해당 프로젝트신고 상세내용 조회용 메소드입니다.
     * @param projectReportNo 프로젝트 신고번호
     * @return ProjectReportDTO
     *         영속성 해제를 위해 DTO 타입으로 변환해준 신고 상세내용
     */
    private ProjectReportDTO findProjectReportDetail(int projectReportNo) {

        return modelMapper.map(reportRepository.findByProjectReportNo(projectReportNo), ProjectReportDTO.class);
    }

    /**
    * 프로젝트 신고번호로 프로젝트신고내역 상세 조회 요청용 메소드입니다.
    * @param projectReportNo 프로젝트 신고번호
    * @return ReportDetailInfo
    *         신고내역 상세정보와 해당 신고내역의 답변 정보를 저장한 DTO
    */
    public ReportDetailInfo findProjectReportAndReply(int projectReportNo) {

        ReportDetailInfo reportDetailInfo = new ReportDetailInfo();

        /* 프로젝트 신고번호로 해당 프로젝트신고 상세내용 조회 */
        ProjectReportDTO projectReport = findProjectReportDetail(projectReportNo);
        reportDetailInfo.setProjectReport(projectReport);

        /* 프로젝트 신고번호로 해당 신고의 답변 조회 */
        ProjectReportReplyDTO reply = findReplyByProjectReportNo(projectReportNo, "N");
        if(reply != null) {
            reportDetailInfo.setProjectReportReply(reply);
        }

        return reportDetailInfo;
    }

    /**
    * 프로젝트신고 답변 등록용 메소드입니다.
    *  @param projectReportReply 등록해줄 신고답변 내용
    * @exception 예외 답변 등록 실패
    */
    @Transactional
    public void registReply(ProjectReportReplyDTO reply) {

        replyRepository.save(modelMapper.map(reply, ProjectReportReply.class));
    }
}
