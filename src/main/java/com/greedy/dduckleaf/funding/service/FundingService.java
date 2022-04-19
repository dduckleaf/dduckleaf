package com.greedy.dduckleaf.funding.service;

import com.greedy.dduckleaf.funding.dto.FundingDTO;
import com.greedy.dduckleaf.funding.entity.Funding;
import com.greedy.dduckleaf.funding.repository.FundingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FundingService {
    private final FundingRepository fundingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FundingService(FundingRepository fundingRepository, ModelMapper modelMapper) {
        this.fundingRepository = fundingRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registFunding(FundingDTO newFunding) {

        fundingRepository.save(modelMapper.map(newFunding, Funding.class));
    }



}
