package com.greedy.dduckleaf.mockfund.service;

import com.greedy.dduckleaf.mockfund.dto.*;
import com.greedy.dduckleaf.mockfund.entity.*;
import com.greedy.dduckleaf.mockfund.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : MockFundService
 * Comment : 모의펀딩 신청
 * History
 * 2022/04/20 (조남기) 모의펀딩 기본 정보 조회 관련 메소드 구현 시작
 * 2022/04/21 (조남기) 모의펀딩 기본 정보, 스토리, 리워드 정보 조회 관련 메소드 구현 완료, 기본 정보 업데이트 관련 메소드 구현 시작
 * 2022/04/22 (조남기) 모의펀딩 기본 정보 컬럼 1개 업데이트 완료
 * 2022/04/23 (조남기) 모의펀딩 기본 정보 이미지 제외 업데이트 완료
 * 2022/04/24 (조남기) 모의펀딩 기본 정보 업데이트 모달 추가 작업
 * 2022/04/25 (조남기) 모의펀딩 스토리 업데이트 완료, 리워드 정보 업데이트 메소드 구현 시작
 * 2022/04/26 (조남기) 모의펀딩 리워드 정보 업데이트 완료
 * 2022/04/27 (조남기) 모의펀딩 리워드 정보 데이터 수정 및 업데이트 재작성 완료
 * </pre>
 * @version 1.0.7
 * @author 조남기
 */
@Service
public class MockFundService {

    private final MockFundInfoRepository mockFundInfoRepository;
    private final MockFundRepository mockFundRepository;
    private final MockFundRewardRepository mockFundRewardRepository;
    private final FarmerRepository farmerRepository;
    private final RewardCategoryRepository rewardCategoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MockFundService(MockFundInfoRepository mockFundInfoRepository,
                           MockFundRepository mockFundRepository,
                           MockFundRewardRepository mockFundRewardRepository,
                           FarmerRepository farmerRepository,
                           RewardCategoryRepository rewardCategoryRepository,
                           ModelMapper modelMapper) {
        this.mockFundInfoRepository = mockFundInfoRepository;
        this.mockFundRepository = mockFundRepository;
        this.mockFundRewardRepository = mockFundRewardRepository;
        this.farmerRepository = farmerRepository;
        this.rewardCategoryRepository = rewardCategoryRepository;
        this.modelMapper = modelMapper;
    }

    public MockFundInfoDTO findMockFundInfoByCode(int infoCode) {

        MockFundInfo info = mockFundInfoRepository.findById(infoCode).get();

        return modelMapper.map(info, MockFundInfoDTO.class);
    }

    public List<RewardCategoryDTO> findRewardCategoryList() {

        List<RewardCategory> categoryList = rewardCategoryRepository.findAll();

        return categoryList.stream().map(rewardCategory -> modelMapper.map(rewardCategory, RewardCategoryDTO.class)).collect(Collectors.toList());
    }

    public MockFundDTO findMockFundByCode(int mockFundCode) {

        MockFund mockFund = mockFundRepository.findById(mockFundCode).get();

        return modelMapper.map(mockFund, MockFundDTO.class);
    }

    public MockFundInfoDTO findStoryInfoByCode(int infoCode) {

        MockFundInfo info = mockFundInfoRepository.findById(infoCode).get();

        return modelMapper.map(info, MockFundInfoDTO.class);
    }

    public MockFundRewardDTO findRewardByCode(int infoCode) {

        MockFundReward info = mockFundRewardRepository.findById(infoCode).get();

        return modelMapper.map(info, MockFundRewardDTO.class);
    }

    @Transactional
    public void modifyBasicInfo(MockFundInfoDTO mockFundInfo, int memberNo) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = mockFundInfo.getEndDate();
        java.util.Date open = null;
        String openDate = null;
        try {
            open = format.parse(strDate);

            Calendar cal = Calendar.getInstance();
            cal.setTime(open);
            cal.add(Calendar.MONTH, -1);

            openDate = format.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Farmer farmer = farmerRepository.findById(memberNo).get();
        MockFund fund = farmer.getMockFundList().get(0);
        fund.setCloseDate(strDate);
        fund.setOpenDate(openDate);
        MockFundInfo foundInfo = fund.getMockFundInfoList().get(0);
        foundInfo.setMockFundName(mockFundInfo.getMockFundName());
        foundInfo.setTargetTicketAmount(mockFundInfo.getTargetTicketAmount());
        foundInfo.setEndDate(mockFundInfo.getEndDate());

        RewardCategory category = rewardCategoryRepository.findById(mockFundInfo.getRewardCategory().getProjectCategoryNo()).get();
        foundInfo.setRewardCategory(category);
    }

    @Transactional
    public int modifyAgreementStatus(int memberNo) {

        Farmer farmer = farmerRepository.findById(memberNo).get();
        MockFund fund = farmer.getMockFundList().get(0);
        MockFundInfo info = fund.getMockFundInfoList().get(0);

        Long mills = System.currentTimeMillis();
        Date date = new Date(mills);
        info.setMockFundAgreementStatus("Y");
        info.setAgreementDate(String.valueOf(date));

        return info.getMockFundInfoNo();
    }

    @Transactional
    public void modifyStory(MockFundInfoDTO mockFundInfo, int memberNo) {

        Farmer farmer = farmerRepository.findById(memberNo).get();
        MockFund fund = farmer.getMockFundList().get(0);
        MockFundInfo foundInfo = fund.getMockFundInfoList().get(0);
        foundInfo.setMockFundDetail(mockFundInfo.getMockFundDetail());
    }

    @Transactional
    public void modifyReward(MockFundRewardDTO mockFundReward, int memberNo) {

        Farmer farmer = farmerRepository.findById(memberNo).get();
        MockFund fund = farmer.getMockFundList().get(0);
        MockFundReward reward = fund.getMockFundRewardList().get(0);
        reward.setRewardName(mockFundReward.getRewardName());
        reward.setRewardDetail(mockFundReward.getRewardDetail());
        reward.setRewardPrice(mockFundReward.getRewardPrice());
    }
}
