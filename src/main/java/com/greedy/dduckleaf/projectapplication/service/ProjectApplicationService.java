package com.greedy.dduckleaf.projectapplication.service;

import com.greedy.dduckleaf.projectapplication.dto.ProjectDTO;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.entity.Project;
import com.greedy.dduckleaf.projectapplication.entity.RewardRegistInfo;
import com.greedy.dduckleaf.projectapplication.repository.ProjectForApplicationRepository;
import com.greedy.dduckleaf.projectapplication.repository.RewardRegistInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class ProjectApplicationService {

    private final ModelMapper modelMapper;
    private final RewardRegistInfoRepository rewardRegistInfoRepository;
    private final ProjectForApplicationRepository projectForApplicationRepository;

    @Autowired
    public ProjectApplicationService(ModelMapper modelMapper, RewardRegistInfoRepository rewardRegistInfoRepository, ProjectForApplicationRepository projectForApplicationRepository) {
        this.modelMapper = modelMapper;
        this.rewardRegistInfoRepository = rewardRegistInfoRepository;
        this.projectForApplicationRepository = projectForApplicationRepository;
    }


    public RewardRegistInfoDTO findRewardRegistInfoByProjectNo(int projectNo) {

        RewardRegistInfo basicReq = rewardRegistInfoRepository.findById(projectNo).get();

        return modelMapper.map(basicReq, RewardRegistInfoDTO.class);
    }

    @Transactional
    public void openProject(int projectNo) {

        RewardRegistInfoDTO reward = new RewardRegistInfoDTO();
//        reward.setRewardPreparingStatus("리워드 준비상태를 작성해주세요");
        reward.setRewardPreparingStatus("준비상태");
        reward.setRewardDeliveryPlan("리워드 전달계획을 작성해주세요");
        reward.setRewardPrice(0);
        reward.setRewardName("리워드 명");
        reward.setRewardInfo("리워드 소개를 간단히 적어주세요");
        reward.setRewardUnit("리워드 단위");
        reward.setProjectNo(projectNo);

        ProjectDTO openProject = new ProjectDTO();
        openProject.setProjectName("프로젝트 명");
        openProject.setOpenDate(Date.valueOf(LocalDate.now()));
        openProject.setEndDate(Date.valueOf(LocalDate.now().plusMonths(1)));
        openProject.setFarmerNo(68);
        openProject.setProgressStatus(1);
        openProject.setProjectStatus("Y");
        openProject.setProjectNo(10);

        rewardRegistInfoRepository.save(modelMapper.map(reward, RewardRegistInfo.class));
        projectForApplicationRepository.save(modelMapper.map(openProject, Project.class));
    }

    public int findProjectNoByFarmerId(int farmerNo) {

        com.greedy.dduckleaf.projectnotice.entity.Project project = projectForApplicationRepository.findByFarmerNoAndAndProgressStatus(farmerNo, 3);

        return project != null? project.getProjectNo() : 0;
    }

    @Transactional
    public void modifyBasicReq(RewardRegistInfoDTO basicreq) {

        RewardRegistInfo updateBasicReq = rewardRegistInfoRepository.findById(basicreq.getProjectNo()).get();
        updateBasicReq.setRewardPreparingStatus(basicreq.getRewardPreparingStatus());
        updateBasicReq.setRewardDeliveryPlan(basicreq.getRewardDeliveryPlan());
    }
}
