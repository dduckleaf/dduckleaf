package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.dto.*;
import com.greedy.dduckleaf.funding.entity.*;
import com.greedy.dduckleaf.funding.regist.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : FundingRegistService
 * Comment : 펀딩등록 프로세스의 로직을 담당하는 서비스
 *
 * History
 *  (홍성원) 처음 작성 /
 * </pre>
 * @version 1.0.0
 * @author 홍성원
 */
@Service
public class FundingRegistService {

    /* 펀딩등록에 필요한 JPARepository와 Entity를 DTO로 변환해 줄 ModelMapper을 의존성 주입 받습니다. */
    private final ModelMapper modelMapper;
    private final ProjectFundingRegistRepository projectRepository;
    private final BankRepository bankRepository;
    private final MemberForFundingRegistRepository memberRepo;
    private final ShippingFeeForFundingRepository shippingRepo;
    private final FundingRepository fundingRepo;
    private final PaymentHistoryForFundingRepository payHistoryRepo;
    private final ShippingAddressForFundingRepository shippingAddressRepo;

    @Autowired
    public FundingRegistService(ProjectFundingRegistRepository repository, ModelMapper modelMapper, BankRepository bankRepository, MemberForFundingRegistRepository memberRepo, ShippingFeeForFundingRepository shippingRepo, FundingRepository fundingRepo, PaymentHistoryForFundingRepository payHistoryRepo, ShippingAddressForFundingRepository shippingAddressRepo) {
        this.projectRepository = repository;
        this.modelMapper = modelMapper;
        this.bankRepository = bankRepository;
        this.memberRepo = memberRepo;
        this.shippingRepo = shippingRepo;
        this.fundingRepo = fundingRepo;
        this.payHistoryRepo = payHistoryRepo;
        this.shippingAddressRepo = shippingAddressRepo;
    }



    /**
     * findProjectFundingInfo :
     * @param projectNo : 프로젝트 번호를 전달받습니다.
     * @return projectDTO : 펀딩하려는 프로젝트의 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public ProjectDTO findProjectFundingInfo(int projectNo) {

        projectRepository.findById(projectNo);

        return modelMapper.map((Object) projectRepository.findById(projectNo).get(), (Type) ProjectDTO.class);
    }



    /**
     * findBankAndUserInfo
     * @param
     * @return
     *
     * @author 홍성원
     */
    public FundingRegistInfoDTO findBankAndUserInfo(String memberId, int projectNo) {

        FundingRegistInfoDTO fundingRegistInfoDTO = new FundingRegistInfoDTO();

        Member member = memberRepo.findByMemberId(memberId);
        List<Bank> bankList = bankRepository.findAll();
        Project project = projectRepository.findById(projectNo).get();

        fundingRegistInfoDTO.setMember(modelMapper.map(member, MemberDTO.class));
        fundingRegistInfoDTO.setBankList(bankList.stream().map(bank->modelMapper.map(bank,BankDTO.class)).collect(Collectors.toList()));
        fundingRegistInfoDTO.setProject(modelMapper.map(project, ProjectDTO.class));

        return  fundingRegistInfoDTO;
    }

    /* 펀딩신청내역 저장 메소드 */
    @Transactional
    public void registFunding(FundingRegistDTO registDTO) {


        /* 펀딩정보 삽입 */
        Funding funding = parsingFundingEntity(registDTO);
        funding.setProject(projectRepository.findById(registDTO.getProjectNo()).get());
        ProjectShippingFee shippingFee = shippingRepo.findProjectShippingFeeForFundingRegistByProjectNo(registDTO.getProjectNo());
        System.out.println("shippingFee = " + shippingFee);
        funding.setProjectShippingFee(shippingFee);
        System.out.println("/* 펀딩정보 삽입 */");

        /* 배송지 삽입 */
        ShippingAddress shippingAddress = parsingShippingAddress(registDTO);
        shippingAddress.setFunding(funding);
        System.out.println("/* 배송지 삽입 */");

        /* 결제내역 삽입 */
        PaymentHistory history = parsingPaymentHistory(registDTO);
        history.setFunding(funding);
        System.out.println("/* 결제내역 삽입 */");

        /* 엔티티에 삽입한 행을 DB에 저장 */
        fundingRepo.save(funding);
        payHistoryRepo.save(history);
        shippingAddressRepo.save(shippingAddress);
        System.out.println("/* 엔티티에 삽입한 행을 DB에 저장 */");
    }


    private PaymentHistory parsingPaymentHistory(FundingRegistDTO registDTO) {

        PaymentHistory history = new PaymentHistory();
        history.setPaymentResultDate(getDateAndTime());
        history.setMemberNo(registDTO.getMemberNo());
        history.setPaymentResultStauts("결제완료");

        return history;
    }

    private ShippingAddress parsingShippingAddress(FundingRegistDTO registDTO) {

        ShippingAddressDTO addressDTO = registDTO.getShippingAddress();

        ShippingAddress address = new ShippingAddress();
        address.setMemberNo(registDTO.getMemberNo());
        address.setMemberName(addressDTO.getShippingMemberName());
        address.setMemberPhone(addressDTO.getShippingMemberPhone());
        String shippingaddress = addressDTO.getZipCode() + "$" + addressDTO.getAddress1() + "$" + addressDTO.getAddress2();
        address.setShippingAddress(shippingaddress);
        address.setShippingRequire(addressDTO.getShippingRequire());

        return address;
    }

    private Funding parsingFundingEntity(FundingRegistDTO registDTO) {

        Funding funding = new Funding();
        String extraShippingFeeStatus = "Y";
        funding.setFundingDate(getDateAndTime());
        funding.setFundingAmount(registDTO.getTotalFunding());
        funding.setRewardAmount(registDTO.getRewardAmount());
        funding.setFundingStatus("Y");
        funding.setDonateAmount(registDTO.getDonate());
        funding.setMemberNo(registDTO.getMemberNo());
        if(registDTO.getShippingFee() > 0) {
            extraShippingFeeStatus = "N";
        }
        funding.setExtraShippingFeeStatus(extraShippingFeeStatus);
        funding.setRefundBankCode(bankRepository.findById(registDTO.getRefundAccountInfo().getBankCode()).get());
        funding.setRefundAccount(registDTO.getRefundAccountInfo().getAccountNo());

        return funding;
    }



    /**
     * findProjetEndDate : 프로젝트의 종료일을 반환합니다.
     * @param projectNo : 프로젝트번호를 전달받습니다.
     * @return endDate : 프로젝ㅌ의 종료일을 반환합니다.
     *
     * @author 홍성원
     */
    public String findProjetEndDate(int projectNo) {

        String endDate = projectRepository.findById(projectNo).get().getEndDate();

        return endDate;
    }
}