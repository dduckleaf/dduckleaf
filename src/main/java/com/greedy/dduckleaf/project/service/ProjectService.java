package com.greedy.dduckleaf.project.service;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.project.dto.FundingInfoDTO;
import com.greedy.dduckleaf.project.dto.ProjectDTO;
import com.greedy.dduckleaf.project.dto.ProjectDetailDTO;
import com.greedy.dduckleaf.project.entity.FollowingProject;
import com.greedy.dduckleaf.project.repository.FollowingProjectForProjectRepository;
import com.greedy.dduckleaf.project.repository.FundingInfoForProjectDetailRepository;
import com.greedy.dduckleaf.project.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, FundingInfoForProjectDetailRepository fundingInfoRepository, FollowingProjectForProjectRepository followingProjectForProjectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.fundingInfoRepository = fundingInfoRepository;
        this.followingProjectForProjectRepository = followingProjectForProjectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProjectDetail : 개별 프로젝트 상세정보를 조회합니다.
     * @param projectNo : 조회할 개별 프로젝트 번호
     * @param user : 로그인된 회원의 회원 정보
     * @return new ProjectDetailDTO : 컨트롤러로 전달할 상세조회 정보
     */
    public ProjectDetailDTO findProjectDetail(int projectNo, CustomUser user) {

        ProjectDTO project = modelMapper.map(projectRepository.findById(projectNo).get(), ProjectDTO.class);

        List<FundingInfoDTO> fundingList = fundingInfoRepository.findAllByProjectNo(projectNo)
                                                                    .stream().map(fundingInfo -> modelMapper.map(fundingInfo, FundingInfoDTO.class)).collect(Collectors.toList());
        String followingStatus = "";

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


        return new ProjectDetailDTO(project, fundingList, followingStatus);
    }
}
