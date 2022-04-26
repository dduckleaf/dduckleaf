package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.dto.ProjectRegistInfoDTO;
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

    /* 서비스에 필요한 JPARepository와 엔티티를 DTO를 변환해 줄 ModelMapper를 DI받습니다. */
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

        return parsingFundingList(fundingRepo.findByMemberNo(5));
    }

    private List<FundingDTO> parsingFundingList(List<Funding> fundingList) {

        List<FundingDTO> fundingDTOList = fundingList.stream().map(funding -> {
            FundingDTO fundingDTO = mapper.map(funding, FundingDTO.class);

            List<ProjectRegistInfoDTO> infoList = fundingDTO.getProject().getRegistInfo();
            infoList.forEach(info ->{

                if(info.getProjectRegistInfoCategory().equals("리워드")) {
                    fundingDTO.setRewardCategoryName(info.getCategory().getProjectCategoryName());
                }
            });

            return fundingDTO;
        }).collect(Collectors.toList());

        return fundingDTOList;
    }
}