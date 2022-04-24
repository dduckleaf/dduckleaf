package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.find.member.repository.FundingForMemberFindRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : FundingServiceForFind
 * Comment : 회원의 펀딩정보 조회 프로세스에서 service layer를 담당하는 클래스입니다.
 *
 * History
 * 2022-04-25 h99ww
 * </pre>
 *
 * @author h99ww
 * @version 1.0.0
 */
@Service
public class FundingServiceForFind {

    private final FundingForMemberFindRepository fundingRepo;
    private final ModelMapper mapper;

    @Autowired
    public FundingServiceForFind(FundingForMemberFindRepository fundingRepo, ModelMapper mapper) {
        this.fundingRepo = fundingRepo;
        this.mapper = mapper;
    }

    /**
     * findFundingByMemberNo : 회원번호로 펀딩신청 목록을 조회하니다.
     * @param memberNo : 회원번호를 전달받습니다.
     * @return fundingList : 회원번호로 조회한 펀딩 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public List<FundingDTO> findFundingByMemberNo(int memberNo) {

        List<Funding> fundingList = fundingRepo.findByMemberNo(5);
        fundingList.forEach(System.out::println);

        return fundingList.stream().map(funding -> mapper.map(funding, FundingDTO.class)).collect(Collectors.toList());
    }
}