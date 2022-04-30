package com.greedy.dduckleaf.project.service;

import com.greedy.dduckleaf.project.dto.FundingInfoDTO;
import com.greedy.dduckleaf.project.dto.ProjectDTO;
import com.greedy.dduckleaf.project.entity.FundingInfo;
import com.greedy.dduckleaf.project.entity.Project;
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
 * </pre>
 * @version 1.0.2
 * @author 차화응
 * @author 박휘림
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final FundingInfoForProjectDetailRepository fundingInfoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, FundingInfoForProjectDetailRepository fundingInfoRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.fundingInfoRepository = fundingInfoRepository;
        this.modelMapper = modelMapper;
    }

    public ProjectDTO findProjectDetail(int projectNo) {

//        Project project = projectRepository.findByProjectNoAndProgressStatus(projectNo, 2);

        Project project = projectRepository.findById(projectNo).get();

        return modelMapper.map(project, ProjectDTO.class);
    }
    
    public List<FundingInfoDTO> countSupporter(int projectNo) {

        List<FundingInfoDTO> fundingList = fundingInfoRepository.findAllByProjectNo(projectNo).stream().map(fundingInfo -> modelMapper.map(fundingInfo, FundingInfoDTO.class)).collect(Collectors.toList());

        return fundingList;
    }


}
