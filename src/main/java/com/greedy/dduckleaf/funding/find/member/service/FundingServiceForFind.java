package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.PaymentHistoryDTO;
import com.greedy.dduckleaf.funding.dto.ProjectBasicInfoDTO;
import com.greedy.dduckleaf.funding.dto.ShippingAddressDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.entity.PaymentHistory;
import com.greedy.dduckleaf.funding.entity.ShippingAddress;
import com.greedy.dduckleaf.funding.find.member.dto.FundingFindDetailInfoForMemberDTO;
import com.greedy.dduckleaf.funding.find.member.repository.FundingForMemberFindRepository;
import com.greedy.dduckleaf.funding.find.member.repository.PaymentHistoryForFundingFindMemberRepository;
import com.greedy.dduckleaf.funding.find.member.repository.ShippingAddressForFundingFindRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : FundingServiceForFind
 * Comment : 회원의 펀딩정보 조회 프로세스에서 서비스 클래스
 *
 * History
 * 2022-04-25 (홍성원)
 * </pre>
 *
 * @author (홍성원)
 * @version 1.0.0
 */
@Service
public class FundingServiceForFind {

    private final int PAGE_SIZE = 5;

    /* 서비스에 필요한 JPARepository와 엔티티를 DTO를 변환해 줄 ModelMapper를 DI받습니다. */
    private final FundingForMemberFindRepository fundingRepo;
    private final PaymentHistoryForFundingFindMemberRepository paymentRepo;
    private final ShippingAddressForFundingFindRepository addressRepo;
    private final ModelMapper mapper;

    @Autowired
    public FundingServiceForFind(FundingForMemberFindRepository fundingRepo, PaymentHistoryForFundingFindMemberRepository paymentRepo, ShippingAddressForFundingFindRepository addressRepo, ModelMapper mapper) {
        this.fundingRepo = fundingRepo;
        this.paymentRepo = paymentRepo;
        this.addressRepo = addressRepo;
        this.mapper = mapper;
    }

    /**
     * findFundingByMemberNo : 회원번호로 펀딩신청 목록을 조회하니다.
     * @param memberNo : 회원번호를 전달받습니다.
     * @return fundingList : 회원번호로 조회한 펀딩 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<FundingDTO> findFundingByMemberNo(int memberNo, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("fundingInfoNo").descending());

        return parsingFundingList(fundingRepo.findByMemberNo(5, pageable));
    }

    private Page<FundingDTO> parsingFundingList(Page<Funding> fundingList) {

        Page<FundingDTO> fundingDTOList = fundingList.map(funding -> {
            FundingDTO fundingDTO = mapper.map(funding, FundingDTO.class);

            List<ProjectBasicInfoDTO> infoList = fundingDTO.getProject().getBasicInfo();
            infoList.forEach(info ->{
                    fundingDTO.setRewardCategoryName(info.getCategory().getProjectCategoryName());
            });

            return fundingDTO;
        });

        return fundingDTOList;
    }



    /**
     * findFundingInfo : 펀딩 상세정보를 조회합니다.
     * @param fundingNo : 펀딩 번호를 전달합니다.
     * @return funding : 펀딩 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public FundingFindDetailInfoForMemberDTO findFundingInfo(int fundingNo) {

        FundingFindDetailInfoForMemberDTO fundingInfo = new FundingFindDetailInfoForMemberDTO();
        
        fundingInfo.setFunding(mapper.map(fundingRepo.findById(fundingNo).get(), FundingDTO.class));
        fundingInfo.getFunding().setRewardCategoryName(fundingInfo.getFunding().getProject().getBasicInfo().get(0).getCategory().getProjectCategoryName());
        fundingInfo.setShippingAddress(mapper.map(addressRepo.findByFunding_fundingInfoNo(fundingNo), ShippingAddressDTO.class));
        fundingInfo.setPaymentHistory(mapper.map(paymentRepo.findByFunding_fundingInfoNo(fundingNo), PaymentHistoryDTO.class));

        return fundingInfo;
    }
}