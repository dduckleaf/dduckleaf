package com.greedy.dduckleaf.project.service;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.project.dto.*;
import com.greedy.dduckleaf.project.entity.FollowingProject;
import com.greedy.dduckleaf.project.entity.ProjectAttachment;
import com.greedy.dduckleaf.project.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ProjectService
 * Comment : 프로젝트
 * History
 * 2022-04-27 (차화응) 처음 작성 / 개별 프로젝트 상세조회 메소드 작성
 * 2022-04-29 (박휘림) 상세조회 메소드 수정 (펀딩 내역 조회, 일자 조회)
 * 2022-05-08 (박상범) 개별 프로젝트 상세조회 메소드 수정
 * </pre>
 * @version 1.0.3
 * @author 차화응
 * @author 박휘림
 * @author 박상범
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final FundingInfoForProjectDetailRepository fundingInfoRepository;
    private final FollowingProjectForProjectRepository followingProjectForProjectRepository;
    private final ProjectApplicationInfoForProjectDetailRepository projectApplicationInfoRepository;
    private final ProjectNoticeForProjectDetailRepository projectNoticeRepository;
    private final ProjectAttachmentForProjectDetailRepository projectAttachmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, FundingInfoForProjectDetailRepository fundingInfoRepository, FollowingProjectForProjectRepository followingProjectForProjectRepository, ProjectApplicationInfoForProjectDetailRepository projectApplicationInfoRepository, ProjectNoticeForProjectDetailRepository projectNoticeRepository, ProjectAttachmentForProjectDetailRepository projectAttachmentRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.fundingInfoRepository = fundingInfoRepository;
        this.followingProjectForProjectRepository = followingProjectForProjectRepository;
        this.projectApplicationInfoRepository = projectApplicationInfoRepository;
        this.projectNoticeRepository = projectNoticeRepository;
        this.projectAttachmentRepository = projectAttachmentRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProjectDetail : 개별 프로젝트 상세정보를 조회합니다.
     * @param projectNo : 조회할 개별 프로젝트 번호
     * @param user : 로그인된 회원의 회원 정보
     * @return new ProjectDetailDTO : 컨트롤러로 전달할 상세조회 정보
     *
     * @author 박상범, 박휘림, 차화응
     */
    public ProjectDetailDTO findProjectDetail(int projectNo, CustomUser user, Pageable pageable) {

        ProjectDTO project = modelMapper.map(projectRepository.findById(projectNo).get(), ProjectDTO.class);

        List<FundingInfoDTO> fundingList = fundingInfoRepository.findAllByProjectNo(projectNo)
                                                                    .stream().map(fundingInfo -> modelMapper.map(fundingInfo, FundingInfoDTO.class)).collect(Collectors.toList());
        String followingStatus = "";

        ProjectApplicationInfoDTO projectApplicationInfo = modelMapper.map(projectApplicationInfoRepository.findByProject_ProjectNo(projectNo), ProjectApplicationInfoDTO.class);

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());

        List<ProjectNoticeDTO> projectNoticeList = projectNoticeRepository.findAllByProjectNoticeStatusAndProjectNo("Y", projectNo, pageable)
                                    .stream().map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).collect(Collectors.toList());

        List<ProjectAttachmentDTO> attachmentList = projectAttachmentRepository.findAllByProject_ProjectNo(projectNo)
                                    .stream().map(projectAttachment -> modelMapper.map(projectAttachment, ProjectAttachmentDTO.class)).collect(Collectors.toList());

        if(user != null) {

            List<FollowingProject> followingProjectList = followingProjectForProjectRepository.findByMemberNoAndProjectNo(user.getMemberNo(), projectNo);

            if(followingProjectList.size() == 0) {
            followingStatus = "N";
            }
            if(followingProjectList.size() != 0) {
            followingStatus = "Y";
            }
        }
        if(user == null) {

            followingStatus = "N";
        }

        return new ProjectDetailDTO(project, fundingList, followingStatus, projectApplicationInfo, projectNoticeList, attachmentList);
    }
}
