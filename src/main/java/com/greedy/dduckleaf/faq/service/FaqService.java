package com.greedy.dduckleaf.faq.service;

import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.entity.Faq;
import com.greedy.dduckleaf.faq.repository.FaqRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FaqRepository faqRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FaqService(FaqRepository faqRepository, ModelMapper modelMapper) {

        this.faqRepository = faqRepository;
        this.modelMapper = modelMapper;
    }


    public Page<FaqDTO> findFaqList(Pageable pageable, int faqNo){

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("faqNo").descending());
        Page<Faq> faqList = faqRepository.findAll()
        return

    }

//    public FaqDTO findfaqlist(int faqNo) {
//
//        Faq faq = repository.findById(faqNo).get();
//
//        return modelMapper.map(faq, FaqDTO.class);
//
//
//    }
}
