package com.greedy.dduckleaf.projectreport.find.service;

import com.greedy.dduckleaf.common.exception.ProjectReport.ReportRegistException;
import com.greedy.dduckleaf.projectreport.find.dto.*;
import com.greedy.dduckleaf.projectreport.find.entity.*;
import com.greedy.dduckleaf.projectreport.find.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
 * 2022-04-19 (장민주) findProjectReportListByMemberNo 서비스메소드 작성
 * 2022-04-23 (장민주) findProjectReportList 서비스메소드 작성
 * 2022-04-24 (장민주) findProjectReportAndReply 서비스메소드 작성
 *                    findReplyByProjectReportNo 내부연산 메소드 작성
 *                    findProjectReportDetail 내부연산 메소드 작성
 * 2022-04-25 (장민주) registProjectReportReply 서비스메소드 작성
 *                    registReply 서비스메소드 작성
 * 2022-04-27 (장민주) findProjectReportListOfOneProject 서비스메소드 작성
 * 2022-04-28 (장민주) findProjectReportWaitingList 서비스메소드 작성
 * 2022-05-02 (장민주) findAllReportCategories 서비스메소드 작성
 * 2022-05-03 (장민주) findPolicyContents 서비스메소드 작성
 * 2022-05-04 (장민주) registProjectReport 서비스메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.8
 */
@Service
public class ProjectReportService {

    private final MemberForProjectReportRepository memberRepository;
    private final ProjectReportMainRepository reportRepository;
    private final ProjectReportReplyRepository replyRepository;
    private final ReportCategoryRepository reportCategoryRepository;
    private final PolicyContentForProjectReportRepository policyContentRepository;
    private final PolicyForProjectReportRepository policyRepository;
    private final ModelMapper modelMapper;

    private final EntityManager entityManager;

    @Autowired
    public ProjectReportService(MemberForProjectReportRepository memberRepository,
                                ProjectReportMainRepository reportRepository,
                                ProjectReportReplyRepository replyRepository,
                                ReportCategoryRepository reportCategoryRepository,
                                PolicyContentForProjectReportRepository policyContentRepository,
                                PolicyForProjectReportRepository policyRepository, ModelMapper modelMapper, EntityManager entityManager) {
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
        this.replyRepository = replyRepository;
        this.reportCategoryRepository = reportCategoryRepository;
        this.policyContentRepository = policyContentRepository;
        this.policyRepository = policyRepository;
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
    }

    /**
    * findProjectReportListByMemberNo: 회원번호로 로그인한 서포터의 신고내역 목록조회용 메소드입니다.
    * @param memberNo 로그인한 회원의 회원번호
    * @return 로그인한 회원이 등록한 모든 신고내역
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
    * findProjectReportList: 모든 프로젝트신고내역 목록 조회를 요청하는 메소드입니다.
    * @param pageable 페이징에 필요한 정보를 담는 객체
    * @return 페이징 처리가 된 조회 결과를 DTO로 변환한 프로젝트신고목록
    * @author 장민주
    */
    public Page<ProjectReportDTO> findProjectReportList(Pageable pageable) {
        /* 페이징 정보 */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectReportNo").descending());

        return reportRepository.findAll(pageable).map(projectReport -> modelMapper.map(projectReport, ProjectReportDTO.class));
    }

    /**
     * findProjectReportWaitingList: 신고 처리 상태에 따라 프로젝트 신고내역 목록 조회를 요청하는 메소드입니다.
     * @param pageable 페이징에 필요한 정보를 담는 객체
     * @param projectReportStatus 프로젝트 신고 처리 상태
     * @return 페이징 처리가 된 조회 결과를 DTO로 변환한 프로젝트신고목록
     * @author 장민주
     */
    public Page<ProjectReportDTO> findProjectsByProjectReportStatus(Pageable pageable, String projectReportStatus) {
        /* 페이징 정보 */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectReportNo").descending());

        return reportRepository.findByProjectReportStatus(projectReportStatus, pageable).map(
                projectReport -> modelMapper.map(projectReport, ProjectReportDTO.class
                )
        );
    }

    /**
    * findReplyByProjectReportNo: (내부연산 메소드) 프로젝트 신고번호로 해당 신고의 답변 조회 요청 메소드입니다.
    * @param projectReportNo 프로젝트 신고번호
    * @param deleteYn 삭제 여부
    * @return 영속성 해제를 위해 DTO 타입으로 변환해준 신고 답변 내역
    */
    private ProjectReportReplyDTO findReplyByProjectReportNo(int projectReportNo, String deleteYn) {

        return modelMapper.map(
                replyRepository.findAllByProjectReport_ProjectReportNoAndDeleteYn(projectReportNo, deleteYn)
              , ProjectReportReplyDTO.class
        );
    }

    /**
     * findProjectReportDetail: (내부연산 메소드) 프로젝트 신고번호로 해당 프로젝트신고 상세내용 조회용 메소드입니다.
     * @param projectReportNo 프로젝트 신고번호
     * @return 영속성 해제를 위해 DTO 타입으로 변환해준 신고 상세내용
     */
    private ProjectReportDTO findProjectReportDetail(int projectReportNo) {

        return modelMapper.map(reportRepository.findByProjectReportNo(projectReportNo), ProjectReportDTO.class);
    }

    /**
    * findProjectReportAndReply: 프로젝트 신고번호로 프로젝트신고내역 상세 조회 요청용 메소드입니다.
    * @param projectReportNo 프로젝트 신고번호
    * @return 신고내역 상세정보와 해당 신고내역의 답변 정보를 저장한 DTO
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
    * registReply: 프로젝트신고 답변 등록용 메소드입니다.
    * @param reply 등록해줄 신고답변 내용
    */
    @Transactional
    public void registReply(ProjectReportReplyDTO reply) {

        replyRepository.save(modelMapper.map(reply, ProjectReportReply.class));

        ProjectReport foundReport = reportRepository.findById(reply.getProjectReportNo()).get();

        foundReport.setProjectReportStatus("답변완료");
    }

    /**
     * findProjectReportListOfOneProject: 프로젝트 번호로 해당 프로젝트의 신고목록 조회 요청 메소드입니다.
     * @param projectNo 프로젝트 번호
     * @param pageable 페이징에 필요한 정보를 담는 객체
     * @return 한 프로젝트에 대한 프로젝트 신고목록 리스트
     * @author 장민주
     */
    public Page<ProjectReportDTO> findProjectReportListOfOneProject(int projectNo, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectReportNo").descending());

        return reportRepository.findByProject_ProjectNo(projectNo, pageable).map(projectReport ->
                modelMapper.map(projectReport, ProjectReportDTO.class));
    }

    /**
     * findAllReportCategories: 모든 프로젝트 신고유형 목록 조회를 요청하는 메소드입니다.
     * @return 프로젝트 신고유형 목록
     * @author 장민주
     */
    public List<ReportCategoryDTO> findAllReportCategories() {

        return reportCategoryRepository.findAll().stream().map(reportCategory ->
                modelMapper.map(reportCategory, ReportCategoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * findPolicyContents: 약관 및 규정정책 번호로 약관 상세내용 조회 요청 메소드입니다.
     * @param policyName 약관 및 규정정책명
     * @return 약관 상세내용
     * @author 장민주
     */
    public List<PolicyContentDTO> findPolicyContents(String policyName) {
        /* 조회하려는 약관의 식별번호 조회 */
        int policyNo = findPolicyNo(policyName);

        return policyContentRepository.findAllByPolicy_PolicyNo(policyNo).stream().map(policyContent ->
                modelMapper.map(policyContent, PolicyContentDTO.class)).collect(Collectors.toList());
    }

    /**
     * findPolicyNo: (내부연산 메소드) 약관 및 규정정책 식별번호 조회 요청 메소드입니다.
     * @param policyName 정책명
     * @return 약관 및 규정정책 식별번호
     * @author 장민주
     */
    private int findPolicyNo(String policyName) {

        return policyRepository.findPolicyNo(policyName);
    }

    /**
     * registProjectReport: 프로젝트 신고 등록 요청 메소드입니다.
     * @param projectReport 프로젝트 신고 상세내용
     * @return 등록 성공 여부
     * @author 장민주
     */
    @Transactional
    public void registProjectReport(ProjectReportDTO projectReport) throws ReportRegistException {

        /* 프로젝트번호로 영속성 컨텍스트에서 신고 대상 프로젝트 엔티티객체 찾기 */
        Project project = entityManager.find(Project.class, projectReport.getProject().getProjectNo());

        System.out.println("project = " + project);

        /* 회원번호로 영속성 컨텍스트에서 신고 회원 엔티티객체 찾기 */
        Member member = entityManager.find(Member.class, projectReport.getMember().getMemberNo());

        System.out.println("member = " + member);

        /* 신고유형번호로 영속성 컨텍스트에서 신고 유형 엔티티객체 찾기 */
        ReportCategory category = entityManager.find(ReportCategory.class, projectReport.getReportCategory().getReportCategoryNo());

        System.out.println("category = " + category);

        ProjectReport newReport = modelMapper.map(projectReport, ProjectReport.class);
        newReport.setProject(project);
        newReport.setMember(member);
        newReport.setReportCategory(category);

        reportRepository.save(newReport);
    }
}
