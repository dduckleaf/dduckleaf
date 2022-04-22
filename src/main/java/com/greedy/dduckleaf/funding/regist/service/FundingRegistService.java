package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.regist.dto.BankDTO;
import com.greedy.dduckleaf.funding.regist.dto.BankListAndMemberDTO;
import com.greedy.dduckleaf.funding.regist.dto.MemberDTO;
import com.greedy.dduckleaf.funding.regist.dto.ProjectDTO;
import com.greedy.dduckleaf.funding.regist.entity.Bank;
import com.greedy.dduckleaf.funding.regist.entity.Member;
import com.greedy.dduckleaf.funding.regist.repository.BankRepository;
import com.greedy.dduckleaf.funding.regist.repository.MemberForFundingRegistRepository;
import com.greedy.dduckleaf.funding.regist.repository.ProjectFundingRegist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundingRegistService {

    private final ProjectFundingRegist projectFundingRegist;
    private final ModelMapper modelMapper;
    private final BankRepository bankRepository;
    private final MemberForFundingRegistRepository memberRepo;

    @Autowired
    public FundingRegistService(ProjectFundingRegist repository, ModelMapper modelMapper, BankRepository bankRepository, MemberForFundingRegistRepository memberRepo) {
        this.projectFundingRegist = repository;
        this.modelMapper = modelMapper;
        this.bankRepository = bankRepository;
        this.memberRepo = memberRepo;
    }

    public ProjectDTO findProjectFundingInfo(int projectNo) {

        projectFundingRegist.findById(projectNo);


        return modelMapper.map((Object) projectFundingRegist.findById(projectNo).get(), (Type) ProjectDTO.class);
    }

    public BankListAndMemberDTO findBankAndUserInfo(String memberId) {

        BankListAndMemberDTO bankListAndMember = new BankListAndMemberDTO();

        Member member = memberRepo.findByMemberId(memberId);
        List<Bank> bankList = bankRepository.findAll();

        bankListAndMember.setMember(modelMapper.map(member, MemberDTO.class));
        bankListAndMember.setBankList(bankList.stream().map(bank->modelMapper.map(bank,BankDTO.class)).collect(Collectors.toList()));
        return  bankListAndMember;
    }

}
