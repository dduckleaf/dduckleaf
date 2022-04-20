package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.regist.dto.ProjectDTO;
import com.greedy.dduckleaf.funding.regist.dto.ProjectForFundingRegistDTO;
import com.greedy.dduckleaf.funding.regist.repository.ProjectFundingRegist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class FundingRegistService {

    private final ProjectFundingRegist repository;
    private final ModelMapper modelMapper;

    @Autowired
    public FundingRegistService(ProjectFundingRegist repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ProjectForFundingRegistDTO findProjectFundingInfo(int projectNo) {

        repository.findById(projectNo);


        return modelMapper.map((Object) repository.findById(projectNo).get(), (Type) ProjectDTO.class);
    }



}
