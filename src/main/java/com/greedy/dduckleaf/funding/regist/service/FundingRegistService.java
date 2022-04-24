package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.regist.dto.*;
import com.greedy.dduckleaf.funding.regist.entity.*;
import com.greedy.dduckleaf.funding.regist.repository.BankRepository;
import com.greedy.dduckleaf.funding.regist.repository.MemberForFundingRegistRepository;
import com.greedy.dduckleaf.funding.regist.repository.ProjectFundingRegistRepository;
import com.greedy.dduckleaf.funding.regist.repository.ShippingFeeForFundingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundingRegistService {

    private final ProjectFundingRegistRepository projectRepository;
    private final ModelMapper modelMapper;
    private final BankRepository bankRepository;
    private final MemberForFundingRegistRepository memberRepo;
    private final ShippingFeeForFundingRepository shippingRepo;

    @Autowired
    public FundingRegistService(ProjectFundingRegistRepository repository, ModelMapper modelMapper, BankRepository bankRepository, MemberForFundingRegistRepository memberRepo, ShippingFeeForFundingRepository shippingRepo) {
        this.projectRepository = repository;
        this.modelMapper = modelMapper;
        this.bankRepository = bankRepository;
        this.memberRepo = memberRepo;
        this.shippingRepo = shippingRepo;
    }

    public ProjectDTO findProjectFundingInfo(int projectNo) {

        projectRepository.findById(projectNo);


        return modelMapper.map((Object) projectRepository.findById(projectNo).get(), (Type) ProjectDTO.class);
    }

    public BankListAndMemberDTO findBankAndUserInfo(String memberId) {

        BankListAndMemberDTO bankListAndMember = new BankListAndMemberDTO();

        Member member = memberRepo.findByMemberId(memberId);
        List<Bank> bankList = bankRepository.findAll();

        bankListAndMember.setMember(modelMapper.map(member, MemberDTO.class));
        bankListAndMember.setBankList(bankList.stream().map(bank->modelMapper.map(bank,BankDTO.class)).collect(Collectors.toList()));
        return  bankListAndMember;
    }

    @Transactional
    public void registFunding(FundingRegistDTO registDTO) {

        /* 펀딩정보 삽입 */
        Funding funding = parsingFundingEntity(registDTO);
        funding.setProject(projectRepository.findById(registDTO.getProjectNo()).get());
        ProjectShippingFee shippingFee = shippingRepo.findProjectShippingFeeForFundingRegistByProjectNo(registDTO.getProjectNo());
        System.out.println("shippingFee = " + shippingFee);
        funding.setProjectShippingFee(shippingFee);

        /* 배송지 삽입 */
        ShippingAddress shippingAddress = parsingShippingAddress(registDTO);
        shippingAddress.setFunding(funding);


        /* 결제내역 삽입 */
        PaymentHistory history = parsingPaymentHistory(registDTO);
        history.setFunding(funding);

    }

    private PaymentHistory parsingPaymentHistory(FundingRegistDTO registDTO) {

        PaymentHistory history = new PaymentHistory();
        history.setPaymentResultDate(new java.sql.Date(System.currentTimeMillis()));
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
        funding.setFundingDate(new java.sql.Date(System.currentTimeMillis()));
        funding.setFundingAmount(registDTO.getTotalFunding());
        funding.setRewardAmount(registDTO.getRewardAmount());
        funding.setFundingStatus("Y");
        funding.setDonateAmount(registDTO.getDonate());
        funding.setMemberNo(registDTO.getMemberNo());
        if(registDTO.getShippingFee() > 0) {
            extraShippingFeeStatus = "N";
        }
        funding.setExtraShippingFeeStatus(extraShippingFeeStatus);

        return funding;
    }
}

































