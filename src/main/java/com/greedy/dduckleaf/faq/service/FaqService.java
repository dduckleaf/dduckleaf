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
import org.springframework.transaction.annotation.Transactional;


/**
 * <pre>
 * Class: FaqServiceTest
 * Comment : 업무명
 * History
 * 2022/04/27 (이용선) 처음 작성 / FAQ 목록 조회 메소드 작성 시작
 * 2022/04/28 (이용선) FAQ 상세조회 메소드 작성
 * 2022/05/07 (이용선) FAQ 수정 메소드 작성
 * 2022/05/07 (이용선) FAQ 삭제 메소드 작성
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
     * findFaqList : FAQ(자주묻는질문)의 목록을 조회합니다.
     * @param pageable : 페이징 정보를 받는 객체입니다.
     * @return faqDTO : faq 목록 정보를 반환합니다.
     * @author 이용선
     */
    public Page<FaqDTO> findFaqList(Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("faqNo").descending());

        Page<FaqDTO> fq = faqRepository.findAll(pageable).map(faq -> {
            FaqDTO faqDTO= modelMapper.map(faq, FaqDTO.class);

            return faqDTO;
        });

        return fq;

    }

    /**
     * findFaqDetail : FAQ(자주묻는질문)의 상세정보를 조회합니다.
     * @param faqNo : FAQ 번호를 담은 객체입니다.
     * @return FaqDTO : 해당 FAQ번호의 자주묻는 질문 내용정보를 반환합니다.
     *
     * @author 이용선
     */

    public FaqDTO findFaqDetail(int faqNo) {

        Faq faq = faqRepository.findById(faqNo).get();

        return modelMapper.map(faq, FaqDTO.class);
    }
    /**
    * faqnewRegist : FAQ(자주묻는질문)을 등록합니다.
    * @param faqWrite : FAQ에 등록할 정보를 담은 객체입니다.
    * @author 이용선
    */
    @Transactional
    public void faqnewRegist(FaqDTO faqWrite){

        faqRepository.save(modelMapper.map(faqWrite, Faq.class));

    }
    /**
    * modifyFaq : FAQ(자주묻는질문)을 수정합니다.
    * @param updateFaq : FAQ 수정사항 정보를 담은 객체입니다.
    * @author 이용선
    */
    @Transactional
    public void modifyFaq(FaqDTO updateFaq) {

        Faq modifyfaq = faqRepository.findById(updateFaq.getFaqNo()).get();
        modifyfaq.setFaqTitle(updateFaq.getFaqTitle());
        modifyfaq.setFaqSubTitle(updateFaq.getFaqSubTitle());
        modifyfaq.setFaqContent(updateFaq.getFaqContent());


    }

    /**
    * removeFaq : FAQ(자주묻는질문)을 삭제합니다.
    * @param faqNo : FAQ 번호를 담은 객체입니다.
    * @author 이용선
    */
    @Transactional
    public void removeFaq(int faqNo) {

        faqRepository.deleteById(faqNo);

    }

}
