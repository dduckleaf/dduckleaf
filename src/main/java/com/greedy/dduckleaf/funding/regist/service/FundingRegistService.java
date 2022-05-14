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
 *  (홍성원) 처음 작성
 * </pre>
 * @version 1.0.1
 * @author 홍성원
 */
@Service
public class FundingRegistService {

    private final ModelMapper modelMapper;
    private final ProjectFundingRegistRepository projectRepository;
    private final BankRepository bankRepository;
    private final MemberForFundingRegistRepository memberRepo;
    private final ShippingFeeForFundingRepository shippingRepo;
    private final FundingRepository fundingRepo;
    private final PaymentHistoryForFundingRepository payHistoryRepo;
    private final ShippingAddressForFundingRepository shippingAddressRepo;
    private final RewardShippingForFundingRegistRepository rewardShippingRepo;
    private final RewardShippingHistoryForRegistFundingRepository rewardShippingHistoryRepo;
    @Autowired
    public FundingRegistService(ProjectFundingRegistRepository repository, ModelMapper modelMapper, BankRepository bankRepository, MemberForFundingRegistRepository memberRepo, ShippingFeeForFundingRepository shippingRepo, FundingRepository fundingRepo, PaymentHistoryForFundingRepository payHistoryRepo, ShippingAddressForFundingRepository shippingAddressRepo, RewardShippingForFundingRegistRepository rewardShippingRepo, RewardShippingHistoryForRegistFundingRepository rewardShippingHistoryRepo) {
        this.projectRepository = repository;
        this.modelMapper = modelMapper;
        this.bankRepository = bankRepository;
        this.memberRepo = memberRepo;
        this.shippingRepo = shippingRepo;
        this.fundingRepo = fundingRepo;
        this.payHistoryRepo = payHistoryRepo;
        this.shippingAddressRepo = shippingAddressRepo;
        this.rewardShippingRepo = rewardShippingRepo;
        this.rewardShippingHistoryRepo = rewardShippingHistoryRepo;
    }



    /**
     * findProjectFundingInfo :
     * @param projectNo : 프로젝트 번호를 전달받습니다.
     * @return projectDTO : 펀딩하려는 프로젝트의 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public ProjectDTO findProjectFundingInfo(int projectNo) {

        Project project = projectRepository.findById(projectNo).get();

        return modelMapper.map((Object) projectRepository.findById(projectNo).get(), ProjectDTO.class);
    }



    /**
     * findBankAndUserInfo : 펀딩신청 시 은행 목록과 회원 개인정보를 조회합니다.
     * @param memberId : 회원번호를 전달받습니다.
     * @param projectNo : 프로젝트 번호를 전달받습니다.
     * @return member : 회원정보를 반환합니다.
     * @return bankList : 은행 목록을 반환합니다.
     * @return project : 프로젝트 리워드 및 배송비 정보를 반환합니다.
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

    /**
     * registFunding : 펀딩을 등록합니다.
     * @param registDTO : 펀딩 등록 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void registFunding(FundingRegistDTO registDTO) {

        /* 입력받은 정보를 엔티티에 저장합니다. */
        Funding funding = parsingFundingEntity(registDTO);
        funding.setProject(projectRepository.findById(registDTO.getProjectNo()).get());

        /* 펀딩 정보에 지불 배송비를 저장합니다. */
        ProjectShippingFee shippingFee = shippingRepo.findProjectShippingFeeForFundingRegistByProjectNo(registDTO.getProjectNo());
        funding.setProjectShippingFee(shippingFee);

        /* 펀딩 내역을 저장합니다. */
        fundingRepo.save(funding);
        funding = fundingRepo.findLastest();

        /* 배송지를 삽입합니다 */
        ShippingAddress shippingAddress = parsingShippingAddress(registDTO);
        shippingAddress.setFunding(funding);

        /* 결제내역을 삽입합니다 */
        PaymentHistory history = parsingPaymentHistory(registDTO);
        history.setFunding(funding);

        /* 발송정보를 삽입합니다 */
        RewardShipping rewardShipping = parsingRewardShipping(registDTO);
        rewardShipping.setFunding(funding);

        rewardShippingRepo.save(rewardShipping);
        rewardShipping = rewardShippingRepo.findLatest();

        /* 발송 내역을 삽입합니다 */
        RewardShippingHistory shippingHistory = new RewardShippingHistory();
        shippingHistory.setRecordDate(getDateAndTime());
        shippingHistory.setRewardShippingNo(rewardShipping.getRewardShippingNo());
        shippingHistory.setShippingStatus(1);

        /* 프로젝트 달성률에 반영합니다 */
        Project project = projectRepository.findById(registDTO.getProjectNo()).get();
        double target = project.getFundTargetAmount();
        int amount = 0;
        List<Funding> fundingList = project.getFundingList();
        for(int i = 0; i < fundingList.size(); i++) {

            amount += fundingList.get(i).getFundingAmount();
        }
        amount += funding.getFundingAmount();

        double rate = amount / target * 100;

        project.setAchievementRate(Math.round(rate));
        projectRepository.save(project);

        /* 엔티티에 삽입한 행을 DB에 저장합니다 */
        payHistoryRepo.save(history);
        shippingAddressRepo.save(shippingAddress);
        rewardShippingHistoryRepo.save(shippingHistory);
    }

    /**
     * parsingRewardShipping : 엔티티 자료형의 리워드 배송정보를 엔티티로 변환합니다.
     * @param registDTO : DTO의 배송정보를 전달받습니다.
     * @return rewardShipping : 엔티티로 변환한 배송정보를 반환합니다.
     *
     * @author 홍성원
     */
    private RewardShipping parsingRewardShipping(FundingRegistDTO registDTO) {

        RewardShipping rewardShipping = new RewardShipping();
        Project project = projectRepository.findById(registDTO.getProjectNo()).get();
        rewardShipping.setShippingDueDate(project.getProjectShippingInfo().getShippingDueDate());
        rewardShipping.setMemberNo(registDTO.getMemberNo());
        rewardShipping.setProjectNo(registDTO.getProjectNo());

        return rewardShipping;
    }

    /**
     * parsingPaymentHistory : 엔티티 자료형의 결제내역을 엔티티로 변환합니다.
     * @param registDTO : DTO의 결제내역을 전달받습니다.
     * @return paymentHistory : 엔티티로 변환한 결제내역을 반환합니다.
     *
     * @author 홍성원
     */
    private PaymentHistory parsingPaymentHistory(FundingRegistDTO registDTO) {

        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setPaymentResultDate(getDateAndTime());
        paymentHistory.setMemberNo(registDTO.getMemberNo());
        paymentHistory.setPaymentResultStauts("결제완료");

        return paymentHistory;
    }

    /**
     * parsingShippingAddress : 엔티티 자료형의 배송지 정보를 엔티티로 변환합니다.
     * @param registDTO : DTO의 배송지 정보를 전달받습니다.
     * @return address : 엔티티로 변환한 배송지 정보를 반환합니다.
     *
     * @author 홍성원
     */
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

    /**
     * parsingFundingEntity : 엔티티 자료형의 펀딩 정보를 엔티티로 변환합니다.
     * @param registDTO : DTO의 펀딩 정보를 전달받습니다.
     * @return address : 엔티티로 변환한 펀딩 정보를 반환합니다.
     *
     * @author 홍성원
     */
    private Funding parsingFundingEntity(FundingRegistDTO registDTO) {

        Funding funding = new Funding();
        String extraShippingFeeStatus = "Y";
        funding.setFundingDate(getDateAndTime());
        funding.setFundingAmount(registDTO.getTotalFunding());
        funding.setRewardAmount(registDTO.getRewardAmount());
        funding.setFundingStatus("Y");
        funding.setDonateAmount(registDTO.getDonate());
        funding.setMemberNo(registDTO.getMemberNo());
        funding.setRefundName(registDTO.getRefundName());
        if(registDTO.getShippingFee() > 0) {
            extraShippingFeeStatus = "N";
        }
        funding.setExtraShippingFeeStatus(extraShippingFeeStatus);
        funding.setRefundBankCode(bankRepository.findById(registDTO.getRefundAccountInfo().getBankCode()).get());
        funding.setRefundAccount(registDTO.getRefundAccountInfo().getAccountNo());

        return funding;
    }

    /**
     * findProjetEndDate : 프로젝트의 종료일을 조회합니다..
     * @param projectNo : 프로젝트번호를 전달받습니다.
     * @return endDate : 프로젝ㅌ의 종료일을 반환합니다.
     *
     * @author 홍성원
     */
    public String findProjetEndDate(int projectNo) {

        String endDate = projectRepository.findById(projectNo).get().getEndDate();

        return endDate;
    }

    /**
     * modifyShippingAddress : 배송지 정보를 변경합니다.
     * @param address : 변경할 배송지 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void modifyShippingAddress(ShippingAddressDTO address) {

        ShippingAddress shippingAddress = shippingAddressRepo.findByFunding_fundingInfoNo(address.getFundingInfoNo());

        shippingAddress.setMemberName(address.getShippingMemberName());
        shippingAddress.setShippingRequire(address.getShippingRequire());
        shippingAddress.setMemberPhone(address.getShippingMemberPhone());

        String memberAddress = address.getZipCode() + "$" + address.getAddress1() + "$" + address.getAddress2();
        shippingAddress.setShippingAddress(memberAddress);

        shippingAddressRepo.save(shippingAddress);
    }

    /**
     * modifyRefundAccount : 환불계좌를 변경합니다.
     * @param accountInfo : 변경할 계좌 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void modifyRefundAccount(FundingDTO accountInfo) {

        Funding funding = fundingRepo.findById(accountInfo.getFundingInfoNo()).get();

        funding.setRefundAccount(accountInfo.getRefundAccount());
        funding.setRefundName(accountInfo.getRefundName());
        funding.setRefundBankCode(bankRepository.findById(accountInfo.getRefundAccountInfo().getBankCode()).get());

        fundingRepo.save(funding);
    }
}