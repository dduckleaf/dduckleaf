package com.greedy.dduckleaf.shippingmanagement.service;

import com.greedy.dduckleaf.shippingmanagement.dto.*;
import com.greedy.dduckleaf.shippingmanagement.entity.*;
import com.greedy.dduckleaf.shippingmanagement.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ShippingService
 * Comment : 발송관리 업무에 사용되는 메소드를 작성하였습니다.
 * History
 * 2022/05/06 (조남기) 마이페이지 파머 탭 파머 프로젝트 조회 관련 메소드 구현 완료, 발송 리워드 정보 조회 구현 시작
 * 2022/05/07 (조남기) 발송 리워드 정보 조회 구현 완료, 발송 리워드 정보 상세 조회 구현 시작
 * 2022/05/08 (조남기) 발송 리워드 정보 상세 조회 구현 완료, 발송 상태변경 구현 시작
 * </pre>
 * @version 1.0.2
 * @author 조남기
 */
@Service
public class ShippingService {

    private final ProjectForShippingRepository shippingRepository;
    private final RewardShippingForShippingRepository rewardRepository;
    private final FundingInfoForShippingRepository fundingRepository;
    private final RewardShippingStatusForShippingRepository shippingStatusRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShippingService(ProjectForShippingRepository shippingRepository,
                           RewardShippingForShippingRepository rewardRepository,
                           FundingInfoForShippingRepository fundingRepository,
                           RewardShippingStatusForShippingRepository shippingStatusRepository,
                           ModelMapper modelMapper) {
        this.shippingRepository = shippingRepository;
        this.rewardRepository = rewardRepository;
        this.fundingRepository = fundingRepository;
        this.shippingStatusRepository = shippingStatusRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProjectListByMemberNo : 로그인한 회원의 프로젝트 목록을 조회합니다.
     *
     * @param memberNo : 로그인 회원 정보를 담는 객체
     * @author 조남기
     */
    public List<ProjectDTO> findProjectListByMemberNo(int memberNo) {

        List<Project> projectList = shippingRepository.findProjectNoByFarmerMemberNo(memberNo);

        return projectList.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
    }

    /**
     * findNotProjectListByProjectNo : 프로젝트 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public ProjectDTO findNotProjectListByProjectNo(int projectNo) {

        Project project = shippingRepository.findProjectNoByProjectNo(projectNo);

        return modelMapper.map(project, ProjectDTO.class);
    }

    /**
     * findCompleteProjectListByProjectNo : 프로젝트 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public ProjectDTO findCompleteProjectListByProjectNo(int projectNo) {

        Project project = shippingRepository.findProjectNoByProjectNo(projectNo);

        return modelMapper.map(project, ProjectDTO.class);
    }

    /**
     * findDelayProjectListByProjectNo : 프로젝트 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public ProjectDTO findDelayProjectListByProjectNo(int projectNo) {

        Project project = shippingRepository.findProjectNoByProjectNo(projectNo);

        return modelMapper.map(project, ProjectDTO.class);
    }

    /**
     * findProjectListByProjectNo : 프로젝트 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public ProjectDTO findProjectListByProjectNo(int projectNo) {

        Project project = shippingRepository.findProjectNoByProjectNo(projectNo);

        return modelMapper.map(project, ProjectDTO.class);
    }

    /**
     * findRewardNotShippingListByProjectNo : 미발송 리워드 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<RewardShippingStatusDTO> findRewardNotShippingListByProjectNo(int projectNo) {

        List<RewardShippingStatus> shippingList = shippingStatusRepository.findNotRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, 1);

        return shippingList.stream().map(rewardShippingStatus -> modelMapper.map(rewardShippingStatus, RewardShippingStatusDTO.class)).collect(Collectors.toList());
    }

    /**
     * findRewardCompleteShippingListByProjectNo : 발송완료 리워드 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<RewardShippingStatusDTO> findRewardCompleteShippingListByProjectNo(int projectNo) {

        List<RewardShippingStatus> shippingList = shippingStatusRepository.findCompleteRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, 2);

        return shippingList.stream().map(rewardShippingStatus -> modelMapper.map(rewardShippingStatus, RewardShippingStatusDTO.class)).collect(Collectors.toList());
    }

    /**
     * findRewardDelayShippingListByProjectNo : 발송지연 리워드 정보를 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<RewardShippingStatusDTO> findRewardDelayShippingListByProjectNo(int projectNo) {

        List<RewardShippingStatus> shippingList = shippingStatusRepository.findDelayRewardListByProjectProjectNoAndAndShippingStatusNo(projectNo, 3);

        return shippingList.stream().map(rewardShippingStatus -> modelMapper.map(rewardShippingStatus, RewardShippingStatusDTO.class)).collect(Collectors.toList());
    }

    /**
     * findFundingInfoByProjectNo : 프로젝트에 대한 펀딩 내역을 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<FundingInfoDTO> findFundingInfoByProjectNo(int projectNo) {

        List<FundingInfo> fundingInfoList = fundingRepository.findFundingInfoByProjectProjectNo(projectNo);
        List<FundingInfoDTO> fundingDTOs = new ArrayList<>();
        fundingInfoList.forEach(funding -> {

            FundingInfoDTO fundingDTO = new FundingInfoDTO();
            fundingDTO = modelMapper.map(funding, FundingInfoDTO.class);
            fundingDTO.setRewardShippingList(modelMapper.map(funding.getRewardShippingList().get(0), RewardShippingDTO.class));

            fundingDTOs.add(fundingDTO);
        });

        return fundingDTOs;
    }

    /**
     * findCompleteFundingInfoByProjectNo : 프로젝트에 대한 펀딩 내역을 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<FundingInfoDTO> findCompleteFundingInfoByProjectNo(int projectNo) {

        List<FundingInfo> fundingInfoList = fundingRepository.findCompleteFundingInfoByProjectProjectNo(projectNo);
        List<FundingInfoDTO> fundingDTOs = new ArrayList<>();
        fundingInfoList.forEach(funding -> {

            FundingInfoDTO fundingDTO = new FundingInfoDTO();
            fundingDTO = modelMapper.map(funding, FundingInfoDTO.class);
            fundingDTO.setRewardShippingList(modelMapper.map(funding.getRewardShippingList().get(0), RewardShippingDTO.class));

            fundingDTOs.add(fundingDTO);
        });

        return fundingDTOs;
    }

    /**
     * findDelayFundingInfoByProjectNo : 프로젝트에 대한 펀딩 내역을 조회합니다.
     *
     * @param projectNo : 프로젝트 정보를 담는 객체
     * @author 조남기
     */
    public List<FundingInfoDTO> findDelayFundingInfoByProjectNo(int projectNo) {

        List<FundingInfo> fundingInfoList = fundingRepository.findDelayFundingInfoByProjectProjectNo(projectNo);
        List<FundingInfoDTO> fundingDTOs = new ArrayList<>();
        fundingInfoList.forEach(funding -> {

            FundingInfoDTO fundingDTO = new FundingInfoDTO();
            fundingDTO = modelMapper.map(funding, FundingInfoDTO.class);
            fundingDTO.setRewardShippingList(modelMapper.map(funding.getRewardShippingList().get(0), RewardShippingDTO.class));

            fundingDTOs.add(fundingDTO);
        });

        return fundingDTOs;
    }
}
