package com.greedy.dduckleaf.mockfund.service;

import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundInfoDTO;
import com.greedy.dduckleaf.mockfund.dto.MockFundRewardDTO;
import com.greedy.dduckleaf.mockfund.dto.RewardCategoryDTO;
import com.greedy.dduckleaf.mockfund.entity.MockFund;
import com.greedy.dduckleaf.mockfund.entity.MockFundInfo;
import com.greedy.dduckleaf.mockfund.entity.MockFundReward;
import com.greedy.dduckleaf.mockfund.entity.RewardCategory;
import com.greedy.dduckleaf.mockfund.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public void modifyBasicInfo(MockFundInfoDTO mockFundInfo) {

        MockFundInfo foundInfo = mockFundInfoRepository.findById(mockFundInfo.getMockFundInfoNo()).get();
        foundInfo.setMockFundName(mockFundInfo.getMockFundName());
        foundInfo.setTargetTicketAmount(mockFundInfo.getTargetTicketAmount());
        foundInfo.setEndDate(mockFundInfo.getEndDate());

        RewardCategory category = rewardCategoryRepository.findById(mockFundInfo.getRewardCategory().getProjectCategoryNo()).get();
        foundInfo.setRewardCategory(category);
    }

}
