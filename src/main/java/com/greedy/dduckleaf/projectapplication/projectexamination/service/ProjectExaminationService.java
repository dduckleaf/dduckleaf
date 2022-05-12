package com.greedy.dduckleaf.projectapplication.projectexamination.service;

import com.greedy.dduckleaf.projectapplication.dto.FarmerFinancialInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectAttachmentDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectExamineHistoryDTO;
import com.greedy.dduckleaf.projectapplication.entity.*;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class: ProjectExaminationService
 * Comment : 프로젝트 심사
 * History
 * 2022/05/02 (박휘림) findProjectApplicationList  메소드 작성
 * 2022/05/03 (박휘림) findProjectApplicationDetail, modifyProjectProgressStatus  메소드 작성
 * 2022/05/04 (박휘림) findBasicInfoAttachmentByProjectNo, findStoryAttachmentByProjectNo, findFarmerInfoAttachment, findFarmerFinancialInfo  메소드 작성
 * 2022/05/10 (박휘림) approveProject, rejectProject, findProjectExamineHisory 메소드 작성
 * </pre>
 * @version 1.0.3
 * @author 박휘림
 */
@Service
public class ProjectExaminationService {

    private final ModelMapper modelMapper;
    private final ProjectApplicationInfoRepository projectApplicationInfoRepository;
    private final ProjectAttachmentForProjectApplicationRepository attachmentRepository;
    private final FarmerFinancialInfoRepository farmerFinancialInfoRepository;
    private final ProjectForApplicationRepository projectRepository;
    private final ProjectExamineHistoryForProjectExaminationRepository projectExamineHistoryRepository;

    @Autowired
    public ProjectExaminationService(ModelMapper modelMapper, ProjectApplicationInfoRepository projectApplicationInfoRepository, ProjectAttachmentForProjectApplicationRepository attachmentRepository, FarmerFinancialInfoRepository farmerFinancialInfoRepository, ProjectForApplicationRepository projectRepository, ProjectExamineHistoryForProjectExaminationRepository projectExamineHistoryRepository) {
        this.modelMapper = modelMapper;
        this.projectApplicationInfoRepository = projectApplicationInfoRepository;
        this.attachmentRepository = attachmentRepository;
        this.farmerFinancialInfoRepository = farmerFinancialInfoRepository;
        this.projectRepository = projectRepository;
        this.projectExamineHistoryRepository = projectExamineHistoryRepository;
    }

    /**
     * findProjectApplicationList: 프로젝트 신청 내역을 조회합니다.
     * @param pageable: 페이징 정보를 담은 객체
     * @return 프로젝트 신청 내역 전체 목록
     * @author 박휘림
     */
    public Page<ProjectApplicationInfoDTO> findProjectApplicationList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectApplicationNo").descending());

        return projectApplicationInfoRepository.findAllByProjectApplicationCategoryOrProjectApplicationCategory(pageable, "심사중", "심사대기중").map(projectApplicationInfo -> modelMapper.map(projectApplicationInfo, ProjectApplicationInfoDTO.class));
    }

    /**
     * findProjectApplicationDetail: 프로젝트 신청 내역을 상세조회합니다.
     * @param projectApplicationNo: 프로젝트 오픈 신청 번호
     * @return 프로젝트 신청 내역 상세 정보
     * @author 박휘림
     */
    public ProjectApplicationInfoDTO findProjectApplicationDetail(int projectApplicationNo) {

        ProjectApplicationInfo projectApplicationInfo = projectApplicationInfoRepository.findById(projectApplicationNo).get();

        return modelMapper.map(projectApplicationInfo, ProjectApplicationInfoDTO.class);
    }

    /**
     * modifyProjectProgressStatus: 프로젝트 상태를 심사중으로 변경합니다.
     * @param projectApplicationNo: 프로젝트 오픈 신청 번호
     * @author 박휘림
     */
    @Transactional
    public ProjectApplicationInfoDTO modifyProjectProgressStatus(int projectApplicationNo) {

        ProjectApplicationInfo projectApplication = projectApplicationInfoRepository.findById(projectApplicationNo).get();
        projectApplication.setProjectApplicationCategory("심사중");

        Project project = projectRepository.findByProjectNo(projectApplication.getProject().getProjectNo());
        project.setProgressStatus(1);
        project.setExamineStatus("2");

        return modelMapper.map(projectApplication, ProjectApplicationInfoDTO.class);
    }

    /**
     * findIntroAttachmentByProjectNo: 프로젝트 신청 시 업로드한 기본요건 첨부파일 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 신청 첨부파일 정보
     * @author 박휘림
     */
    public ProjectAttachmentDTO findIntroAttachmentByProjectNo(int projectNo) {

        ProjectAttachment attachment = attachmentRepository.findIntroAttachmentByProjectNo(projectNo);

        return modelMapper.map(attachment, ProjectAttachmentDTO.class);
    }

    /**
     * findBasicInfoAttachmentByProjectNo: 프로젝트 신청 시 업로드한 기본정보 첨부파일 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 신청 첨부파일 정보
     * @author 박휘림
     */
    public ProjectAttachmentDTO findBasicInfoAttachmentByProjectNo(int projectNo) {

        ProjectAttachment attachment = attachmentRepository.findBasicInfoAttachmentByProjectNo(projectNo);

        return modelMapper.map(attachment, ProjectAttachmentDTO.class);
    }

    /**
     * findStoryAttachmentByProjectNo: 프로젝트 신청 시 업로드한 스토리 첨부파일 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 신청 첨부파일 정보
     * @author 박휘림
     */
    public ProjectAttachmentDTO findStoryAttachmentByProjectNo(int projectNo) {

        ProjectAttachment attachment = attachmentRepository.findStoryAttachmentByProjectNo(projectNo);

        return modelMapper.map(attachment, ProjectAttachmentDTO.class);
    }

    /**
     * findFarmerInfoAttachment: 프로젝트 신청 시 업로드한 파머 첨부파일 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 신청 첨부파일 정보
     * @author 박휘림
     */
    public ProjectAttachmentDTO findFarmerInfoAttachment(int projectNo) {

        ProjectAttachment attachment = attachmentRepository.findFarmerInfoAttachment(projectNo);

        return modelMapper.map(attachment, ProjectAttachmentDTO.class);
    }

    /**
     * findFarmerFinancialInfo: 프로젝트 신청 시 등록한 파머 금융 정보를 조회합니다.
     * @param memberNo: 회원 번호
     * @return 파머 금융 정보
     * @author 박휘림
     */
    public FarmerFinancialInfoDTO findFarmerFinancialInfo(int memberNo) {

        FarmerFinancialInfo farmer = farmerFinancialInfoRepository.findByMemberNo(memberNo);

        return  modelMapper.map(farmer, FarmerFinancialInfoDTO.class);
    }

    /**
     * findFarmerInfoAttachment: 프로젝트 신청 시 업로드한 금융정보 첨부파일 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 신청 첨부파일 리스트
     * @author 박휘림
     */
    public List<ProjectAttachmentDTO> findFarmerFinancialInfoAttachment(int projectNo) {

        return attachmentRepository.findFarmerFinancialInfoAttachment(projectNo).stream()
                .map(projectAttachment -> modelMapper.map(projectAttachment, ProjectAttachmentDTO.class)).collect(Collectors.toList());
    }

    /**
     * approveProject: 프로젝트를 승인합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @param adminNo: 관리자 번호
     * @author 박휘림
     */
    @Transactional
    public void approveProject(int projectApplicationNo, int adminNo) {


        ProjectApplicationInfo projectApplicationInfo = projectApplicationInfoRepository.findByProjectApplicationNo(projectApplicationNo);
        projectApplicationInfo.setProjectApplicationCategory("승인");

        Project project = projectRepository.findByProjectNo(projectApplicationInfo.getProject().getProjectNo());
        project.setProgressStatus(2);
        project.setExamineStatus("3");
        project.setProjectExamineStatus("승인");

        ProjectExamineHistory projectExamineHistory = new ProjectExamineHistory();
        projectExamineHistory.setExamineHistoryCategory(4);
        projectExamineHistory.setProjectExamineRegistDate(java.sql.Date.valueOf(LocalDate.now()).toString());
        projectExamineHistory.setExamineProjectStatus(3);
        projectExamineHistory.setFarmerNo(project.getFarmer().getMemberNo());
        projectExamineHistory.setProjectNo(project.getProjectNo());
        projectExamineHistory.setAdminNo(adminNo);

        projectExamineHistoryRepository.save(projectExamineHistory);
    }

    /**
     * rejectProject: 프로젝트를 반려합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @param adminNo: 관리자 번호
     * @param history: 프로젝트 심사내역
     * @author 박휘림
     */
    @Transactional
    public void rejectProject(int projectApplicationNo, int adminNo, ProjectExamineHistoryDTO history) {

        ProjectApplicationInfo projectApplicationInfo = projectApplicationInfoRepository.findByProjectApplicationNo(projectApplicationNo);
        projectApplicationInfo.setProjectApplicationCategory("반려");

        Project project = projectRepository.findByProjectNo(projectApplicationInfo.getProject().getProjectNo());
        project.setProgressStatus(6);  //반려
        project.setExamineStatus("3"); //심사완료
        project.setProjectExamineStatus("반려");
        project.setProjectStatus("N");

        ProjectExamineHistory projectExamineHistory = new ProjectExamineHistory();
        projectExamineHistory.setExamineHistoryCategory(5);
        projectExamineHistory.setProjectExamineDetailContent(history.getProjectExamineDetailContent());
        projectExamineHistory.setProjectExamineRegistDate(java.sql.Date.valueOf(LocalDate.now()).toString());
        projectExamineHistory.setExamineProjectStatus(3);
        projectExamineHistory.setFarmerNo(project.getFarmer().getMemberNo());
        projectExamineHistory.setProjectNo(project.getProjectNo());
        projectExamineHistory.setAdminNo(adminNo);

        projectExamineHistoryRepository.save(projectExamineHistory);
    }

    /**
     * findProjectExamineHisory: 프로젝트를 반려합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 심사내역
     * @author 박휘림
     */
    public ProjectExamineHistoryDTO findProjectExamineHisory(int projectNo) {

        ProjectExamineHistory examineHistory = projectExamineHistoryRepository.findAllByProjectNo(projectNo);

        return modelMapper.map(examineHistory, ProjectExamineHistoryDTO.class);
    }
}
