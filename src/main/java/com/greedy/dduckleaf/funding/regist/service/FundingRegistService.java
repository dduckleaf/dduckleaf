package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.regist.dto.BankDTO;
import com.greedy.dduckleaf.funding.regist.dto.ProjectDTO;
import com.greedy.dduckleaf.funding.regist.repository.BankRepository;
import com.greedy.dduckleaf.funding.regist.repository.ProjectFundingRegist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class FundingRegistService {

    private final ProjectFundingRegist projectFundingRegist;
    private final ModelMapper modelMapper;

    @Autowired
    public FundingRegistService(ProjectFundingRegist repository, ModelMapper modelMapper) {
        this.projectFundingRegist = repository;
        this.modelMapper = modelMapper;
    }

    public ProjectDTO findProjectFundingInfo(int projectNo) {

        projectFundingRegist.findById(projectNo);


        return modelMapper.map((Object) projectFundingRegist.findById(projectNo).get(), (Type) ProjectDTO.class);
    }

    public List<BankDTO> findBankList() {

//        List<Bank> bankList = bankRepository.;
        return null;
    }



}
