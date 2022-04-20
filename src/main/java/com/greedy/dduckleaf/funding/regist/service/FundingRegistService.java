package com.greedy.dduckleaf.funding.regist.service;

import com.greedy.dduckleaf.funding.regist.dto.ProjectForFundingRegistDTO;
import com.greedy.dduckleaf.funding.regist.repository.ProjectForFundingRegistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundingRegistService {

    private final ProjectForFundingRegistRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public FundingRegistService(ProjectForFundingRegistRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ProjectForFundingRegistDTO findProjectFundingInfo(int projectNo) {

        return modelMapper.map(repository.findById(projectNo).get(), ProjectForFundingRegistDTO.class);
    }



}
