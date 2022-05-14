package com.greedy.dduckleaf.funding.find.member.service;

import com.greedy.dduckleaf.funding.dto.*;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.entity.FundingForAdmin;
import com.greedy.dduckleaf.funding.entity.MemberForAdmin;
import com.greedy.dduckleaf.funding.entity.ShippingAddress;
import com.greedy.dduckleaf.funding.find.member.dto.FundingFindDetailInfoForMemberDTO;
import com.greedy.dduckleaf.funding.find.member.dto.FundingInfoByMemberForAdminDTO;
import com.greedy.dduckleaf.funding.find.member.dto.ProjectManageFundingDTO;
import com.greedy.dduckleaf.funding.find.member.repository.*;
import com.greedy.dduckleaf.funding.regist.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : FundingServiceForFind
 * Comment : 회원의 펀딩정보 조회 프로세스에서 서비스 클래스
 *
 * History
 * 2022-04-25 (홍성원) 처음 작성 findFundingByMemberNo / parsingFundingList / findFundingInfo / parsingAddress 메소드 작성
 * 2022-05-07 (홍성원)  findfundingInfoByMemberForAdmin / findFundingInfoByMemberId / parsingFundingByMemberForAdmin 메소드 추가
 * </pre>
 *
 * @author (홍성원)
 * @version 1.0.0
 */
@Service
public class FundingServiceForFind {

    private final int PAGE_SIZE = 5;

    private final FundingForMemberFindRepository fundingRepo;
    private final PaymentHistoryForFundingFindMemberRepository paymentRepo;
    private final ShippingAddressForFundingFindRepository addressRepo;
    private final MemberForFundingFindRepository memberRepo;
    private final BankRepository bankRepo;
    private final ProjectRepositoryForManageEndProjectDetail projectRepo;
    private final ModelMapper mapper;
    private final RefundingForFundingRefundingRepository refundRepo;

    @Autowired
    public FundingServiceForFind(FundingForMemberFindRepository fundingRepo, PaymentHistoryForFundingFindMemberRepository paymentRepo, ShippingAddressForFundingFindRepository addressRepo, MemberForFundingFindRepository memberRepo, BankRepository bankRepo, ProjectRepositoryForManageEndProjectDetail projectRepo, ModelMapper mapper, RefundingForFundingRefundingRepository refundRepo) {
        this.fundingRepo = fundingRepo;
        this.paymentRepo = paymentRepo;
        this.addressRepo = addressRepo;
        this.memberRepo = memberRepo;
        this.bankRepo = bankRepo;
        this.projectRepo = projectRepo;
        this.mapper = mapper;
        this.refundRepo = refundRepo;
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

        return parsingFundingList(fundingRepo.findByMemberNo(memberNo, pageable));
    }

    /**
     * parsingFundingList : 펀딩 엔티티 목록을 DTO로 변환합니다.
     * @param fundingList : 펀딩 엔티티 목록을 전달받습니다.
     * @return fundingDTOList :  펀딩 DTO 목록을 반환합니다.
     */
    private Page<FundingDTO> parsingFundingList(Page<Funding> fundingList) {

        Page<FundingDTO> fundingDTOList = fundingList.map(funding -> {
            FundingDTO fundingDTO = mapper.map(funding, FundingDTO.class);

            /* 엔티티의 연관관계로 조회해 온 카테고리를 DTO 필드에 저장합니다. */
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
     * @return fundingInfo : 펀딩 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public FundingFindDetailInfoForMemberDTO findFundingInfo(int fundingNo) {

        FundingFindDetailInfoForMemberDTO fundingInfo = new FundingFindDetailInfoForMemberDTO();
        
        /* 펀딩정보를 조회합니다. */
        fundingInfo.setFunding(mapper.map(fundingRepo.findById(fundingNo).get(), FundingDTO.class));
        fundingInfo.getFunding().setRewardCategoryName(fundingInfo.getFunding().getProject().getBasicInfo().get(0).getCategory().getProjectCategoryName());

        /* 배송지 정보를 조회합니다. */
        ShippingAddress address = addressRepo.findByFunding_fundingInfoNo(fundingNo);
        fundingInfo.setShippingAddress(parsingAddress(address));

        /* 은행 목록을 조회합니다. */
        List<BankDTO> bankList = bankRepo.findAll().stream().map(bank -> mapper.map(bank, BankDTO.class)).collect(Collectors.toList());
        fundingInfo.setBankList(bankList);

        return fundingInfo;
    }
    
    /**
     * parsingAddress : 엔티티에 담긴 배송지 정보를 DTO형태로 변환합니다.
     * @param address : 엔티티 타입의 배송지 정보를 전달받습니다
     * @return addressDTO : DTO 타입의 배송지 정보를 반환합니다.
     *
     * @author 홍성원
     */
    private ShippingAddressDTO parsingAddress(ShippingAddress address) {

        ShippingAddressDTO addressDTO = mapper.map(address, ShippingAddressDTO.class);

        /* 주소를 화면에 출력하기 위해 우편번호와 주소, 상세주소로 분리합니다. */
        String addressInfo[] = {"","",""};
        if(address.getShippingAddress() != null) {
            addressInfo = address.getShippingAddress().split("\\$");
        }
        addressDTO.setZipCode(addressInfo[0]);
        addressDTO.setAddress1(addressInfo[1]);
        addressDTO.setAddress2(addressInfo[2]);

        return addressDTO;
    }

    /**
     * findfundingInfoByMemberForAdmin : 회원별 펀딩 정보를 조회합니다.
     * @param pageable : 페이징 정보가 담긴 객체를 전달받습니다. 
     * @return fundingsByMember : 페이징 정보에 해당하는 회원별 펀딩 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public Page<FundingInfoByMemberForAdminDTO> findfundingInfoByMemberForAdmin(Pageable pageable) {


        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("memberNo").descending());

        /* 페이징 정보로 회원정보를 조회합니다. */
        Page<MemberForAdmin> members = memberRepo.findAll(pageable);

        /* 조회해온 정보를 컨트롤러에 보내기 전 값을 가공합니다. */
        Page<FundingInfoByMemberForAdminDTO> fundingsByMember = members.map(memberInfo -> {
            
            FundingInfoByMemberForAdminDTO fundingInfo = new FundingInfoByMemberForAdminDTO();

            /* 한 회원의 펀딩 참여 개수를 DTO 필드에 저장합니다. */
            List<FundingForAdmin> fundings = memberInfo.getFundings();
            fundingInfo.setFundingCount(fundings != null? fundings.size() : 0);
            fundingInfo.setMemberName(memberInfo.getMemberName());

            /* 한 회원의 환불 개수를 DTO 필드에 저장합니다. */
            int refundingCount = 0;
            if(fundings != null) {
                for(int i = 0; i < fundings.size(); i++) {

                    refundingCount += (fundings.get(i).getRefundings() != null? fundings.get(i).getRefundings().size(): 0);
                }
            }
            fundingInfo.setRefundingCount(refundingCount);

            /* 펀딩 내역이 존재할 시 최근 펀딩일시를 저장한다. */
            String date = "";
            if(fundings != null && fundings.size() > 0) {
                date = fundings.get(fundings.size() - 1).getFundingDate();
            }
            fundingInfo.setRecentFundingdate(date);

            fundingInfo.setMemberNo(memberInfo.getMemberNo());

            return fundingInfo;
        });

        return fundingsByMember;
    }

    /**
     * findFundingInfoByMemberId : 전달받은 회원의 펀딩 내역 목록을 조회합니다.
     * @param memberNo : 회원 번호를 전달받습니다.
     * @return Page<FundingServiceForFind> : 펀딩 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<FundingByMemberForAdminDTO> findFundingInfoByMemberId(int memberNo, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, 10,
                Sort.by("fundingInfoNo").descending());

        Page<Funding> fundings = fundingRepo.findByMemberNo(memberNo, pageable);

        return parsingFundingByMemberForAdmin(fundings);
    }

    /**
     * parsingFundingByMemberForAdmin : 한 회원의 엔티티 자료형의 펀딩목록을 DTO형태로 변환 후 반환합니다.
     * @param  fundings : 엔티티 자료형의 펀딩정보 목록을 전달받습니다.
     * @return fundingDTOs : DTO 자료형의 펀딩 정보 목록을 반환합니다.
     *
     * @author 홍성원
     */
    private Page<FundingByMemberForAdminDTO> parsingFundingByMemberForAdmin(Page<Funding> fundings) {

        /* 연관관계로 조회한 정보 중 페이지에 출력할 데이터를 DTO에 저장합니다. */
        Page<FundingByMemberForAdminDTO> fundingDTOs = fundings.map(funding -> {

            FundingByMemberForAdminDTO fundingDTO = new FundingByMemberForAdminDTO();

            fundingDTO.setFundingNo(funding.getFundingInfoNo());
            fundingDTO.setFundingAmount(funding.getFundingAmount());
            fundingDTO.setDate(funding.getFundingDate());
            fundingDTO.setDonate(funding.getDonateAmount());
            fundingDTO.setProjectName(funding.getProject().getProjectName());

            int shippingFee = funding.getProjectShippingFee().getShippingFee();

            if("Y".equals(funding.getExtraShippingFeeStatus())) {
                shippingFee = funding.getProjectShippingFee().getExtraShippingFee();
            }

            fundingDTO.setShippingFee(shippingFee);
            fundingDTO.setReward(funding.getProject().getRewardInfo().getRewardName());
            fundingDTO.setRewardCount(funding.getProject().getRewardInfo().getRewardUnit() + " X " + funding.getRewardAmount() + "EA");


            return fundingDTO;
        });

        return fundingDTOs;
    }

    public ProjectManageFundingDTO findFundingInfoByProjectNo(int projectNo, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("fundingInfoNo").descending());

        Page<Funding> fundings = fundingRepo.findByProject_projectNo(projectNo, pageable);
        Page<FundingDTO> fundingDTOs = fundings.map(funding -> mapper.map(funding, FundingDTO.class));
        ProjectDTO project = mapper.map(projectRepo.findById(projectNo).get(), ProjectDTO.class);

        return new ProjectManageFundingDTO(fundingDTOs, project);
    }

    public RefundingFindDetailInfoDTO findRefudingInfo(int projectNo, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1, PAGE_SIZE,
                Sort.by("refundingInfoNo").descending());


        RefundingFindDetailInfoDTO info = new RefundingFindDetailInfoDTO();

        info.setProject(mapper.map(projectRepo.findById(projectNo).get(), ProjectDTO.class));
        info.setRefundings(refundRepo.findByProject_projectNo(projectNo, pageable));

        return info;
    }
}