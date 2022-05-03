package com.greedy.dduckleaf.mockfund.find.service;

import com.greedy.dduckleaf.mockfund.dto.MockFundDTO;
import com.greedy.dduckleaf.mockfund.entity.Farmer;
import com.greedy.dduckleaf.mockfund.entity.MockFund;
import com.greedy.dduckleaf.mockfund.find.repository.MockFundForFundingRepository;
import com.greedy.dduckleaf.mockfund.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : MockFundingService
 * Comment : 모의펀딩 신청
 * History
 * 2022/04/28 (조남기) 모의펀딩 목록 조회 구현 시작, 페이징 및 모의펀딩내역 관련 데이터 제외 구현 완료
 * 2022/04/29 (조남기) 모의펀딩 상세 조회 구현 완료
 * </pre>
 * @version 1.0.1
 * @author 조남기
 */
@Service
public class MockFundingService {

    private final MockFundForFundingRepository mockFundForFundingRepository;
    private final FarmerRepository farmerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MockFundingService(MockFundForFundingRepository mockFundForFundingRepository,
                              FarmerRepository farmerRepository,
                              ModelMapper modelMapper) {
        this.mockFundForFundingRepository = mockFundForFundingRepository;
        this.farmerRepository = farmerRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findByProgressStatus : 모의펀딩 목록을 조회합니다.
     *
     * @author 조남기
     */
    public List<MockFundDTO> findByProgressStatus() {

        List<MockFund> mockFundList = mockFundForFundingRepository.findByMockFundProgressStatus("진행전");

        return mockFundList.stream().map(mockFund -> modelMapper.map(mockFund, MockFundDTO.class)).collect(Collectors.toList());
    }

    /**
     * findMockFundingInfo : 모의펀딩 상세 정보를 조회합니다.
     * @param mockFundNo : 조회할 모의펀딩 번호를 담은 객체
     *
     * @author 조남기
     */
    public MockFundDTO findMockFundingInfo(int mockFundNo) {

        MockFund fund = mockFundForFundingRepository.findById(mockFundNo).get();

        return modelMapper.map(fund, MockFundDTO.class);
    }

}
