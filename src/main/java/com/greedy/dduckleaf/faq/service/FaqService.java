package com.greedy.dduckleaf.faq.service;

import com.greedy.dduckleaf.faq.dto.FaqDTO;
import com.greedy.dduckleaf.faq.dto.MemberDTO;
import com.greedy.dduckleaf.faq.entity.Faq;
import com.greedy.dduckleaf.faq.repository.FaqRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * Class: FaqServiceTest
 * Comment : 업무명
 * History
 * 2022/04/27 (이용선) 처음 작성 / FAQ 목록 조회 메소드 작성 시작
 * 2022/04/28 (이용선) FAQ 상세조회 메소드 작성
 * </pre>
 * @version 1.0.1
 *
 * @author 이용선
 */

@Service
public class FaqService {

    private final FaqRepository faqRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FaqService(FaqRepository faqRepository, ModelMapper modelMapper) {

        this.faqRepository = faqRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findFaqList : FAQ 목록을 조회합니다.
     * @param pageable : 페이징 정보를 받는 객체입니다.
     * @return faqDTO : faq 목록 정보를 반환합니다.
     *
     * @author 이용선
     */
    public Page<FaqDTO> findFaqList(Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("faqNo").descending());

        Page<FaqDTO> fq = faqRepository.findAll(pageable).map(faq -> {
            FaqDTO faqDTO= modelMapper.map(faq, FaqDTO.class);
//            faqDTO.setMember(modelMapper.map(faq.getMember(), MemberDTO.class));

            return faqDTO;
        });

        fq.forEach(System.out::println);

        return fq;

    }

    /**
     * findFaqDetail : FAQ 상세정보를 조회합니다.
     * @param faqNo : FAQ 번호를 전달받습니다.
     * @return FaqDTO : 자주묻는 질문들의 정보를 반환합니다.
     *
     * @author 이용선
     */

    public FaqDTO findFaqDetail(int faqNo) {

        Faq faq = faqRepository.findById(faqNo).get();

        return modelMapper.map(faq, FaqDTO.class);
    }

    @Transactional
    public void faqnewRegist(FaqDTO faqWrite){

        faqRepository.save(modelMapper.map(faqWrite, Faq.class));

    }


}
