package com.greedy.dduckleaf.platformqa.service;

import com.greedy.dduckleaf.platformqa.dto.PlatformQaCategoryDTO;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaDTO;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaReplyDTO;
import com.greedy.dduckleaf.platformqa.entity.PlatformQa;
import com.greedy.dduckleaf.platformqa.entity.PlatformQaCategory;
import com.greedy.dduckleaf.platformqa.entity.PlatformQaReply;
import com.greedy.dduckleaf.platformqa.repository.PlatformQaCategoryRepository;
import com.greedy.dduckleaf.platformqa.repository.PlatformQaReplyRepository;
import com.greedy.dduckleaf.platformqa.repository.PlatformQaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : PlatformQaService
 * Comment : 1:1문의
 * History
 * 2022-05-01 (차화응) 처음 작성 / 1:1문의 목록조회 메소드 작성
 * 2022-05-01 (차화응) 1:1문의 카테고리 전체 조회 메소드 작성
 * 2022-05-03 (차화응) 1:1문의 답변 전체 조회 메소드 작성
 * 2022-05-03 (차화응) 1:1문의 작성하기 메소드 작성
 * 2022-05-04 (차화응) 1:1문의 삭제하기 메소드 작성
 * 2022-05-05 (차화응) 1:1문의 답변 작성하기 메소드 작성
 * 2022-05-08 (차화응) 1:1문의 답변 수정하기 메소드 작성 / 1:1문의 답변 삭제하기 메소드 작성
 * </pre>
 * @version 1.0.7
 * @author 차화응
 */
@Service
public class PlatformQaService {

    private final PlatformQaRepository platformQaRepository;
    private final PlatformQaCategoryRepository platformQaCategoryRepository;
    private final PlatformQaReplyRepository platformQaReplyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlatformQaService(PlatformQaRepository platformQaRepository, PlatformQaCategoryRepository platformQaCategoryRepository, PlatformQaReplyRepository platformQaReplyRepository, ModelMapper modelMapper) {
        this.platformQaRepository = platformQaRepository;
        this.platformQaCategoryRepository = platformQaCategoryRepository;
        this.platformQaReplyRepository = platformQaReplyRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findPlatformQaList : 1:1문의 목록을 조회합니다.
     * @param pageable : 페이징 정보를 담는 객체
     *
     * @author 차화응
     */
    public Page<PlatformQaDTO> findPlatformQaList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("platformQaNo").descending());

        return platformQaRepository.findAll(pageable).map(platformQa -> modelMapper.map(platformQa, PlatformQaDTO.class));
    }

    /**
     * findAllPlatformQaCategory : 1:1문의 카테고리 전체를 조회합니다.
     *
     * @author 차화응
     */
    public List<PlatformQaCategoryDTO> findAllPlatformQaCategory() {

        List<PlatformQaCategory> platformQaCategoryList = platformQaCategoryRepository.findAllPlatformQaCategory();

        return platformQaCategoryList.stream().map(platformQaCategory -> modelMapper.map(platformQaCategory, PlatformQaCategoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAllPlatformQaReply : 1:1문의 답변 전체를 조회합니다.
     *
     * @author 차화응
     */
    public List<PlatformQaReplyDTO> findAllPlatformQaReply() {

        List<PlatformQaReply> platformQaReplyList = platformQaReplyRepository.findAllPlatformQaReply();

        return platformQaReplyList.stream().map(platformQaReply -> modelMapper.map(platformQaReply, PlatformQaReplyDTO.class)).collect(Collectors.toList());
    }

    /**
     * registNewPlatformQa : 1:1문의를 등록합니다.
     * @param newPlatformQa : 등록할 1:1문의 정보를 담는 객체
     *
     * @author 차화응
     */
    @Transactional
    public void registNewPlatformQa(PlatformQaDTO newPlatformQa) {

        String registDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.sql.Date(System.currentTimeMillis()));
        newPlatformQa.setPlatformQaRegistDate(registDate);

        PlatformQa platformQa = modelMapper.map(newPlatformQa, PlatformQa.class);

        PlatformQaCategory platformQaCategory = platformQaCategoryRepository.findById(newPlatformQa.getQnaCategory().getPlatformQaCategoryNo()).get();

        platformQa.setQnaCategory(platformQaCategory);
        platformQa.setPlatformQaCategory(platformQaCategory.getPlatformQaCategoryNo());

        platformQaRepository.save(platformQa);
    }

    /**
     * removePlatformQa : 1:1문의를 삭제합니다.
     * @param platformQaNo : 삭제할 1:1문의 번호
     *
     * @author 차화응
     */
    @Transactional
    public void removePlatformQa(int platformQaNo) {

        platformQaRepository.deleteById(platformQaNo);
    }

    /**
     * registNewPlatformQaReply : 1:1문의 답변을 등록합니다.
     * @param newPlatformQaReply : 등록할 1:1문의 답변 정보를 담는 객체
     *
     * @author 차화응
     */
    @Transactional
    public void registNewPlatformQaReply(PlatformQaReplyDTO newPlatformQaReply) {

        String registDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.sql.Date(System.currentTimeMillis()));
        newPlatformQaReply.setPlatformQaReplyRegistDate(registDate);

        platformQaReplyRepository.save(modelMapper.map(newPlatformQaReply, PlatformQaReply.class));
    }

    /**
     * modifyPlatformQaReply : 1:1문의 답변을 수정합니다.
     * @param updatePlatformQaReply : 수정할 1:1문의 답변 정보를 담는 객체
     *
     * @author 차화응
     */
    @Transactional
    public void modifyPlatformQaReply(PlatformQaReplyDTO updatePlatformQaReply) {

        PlatformQaReply foundPlatformQaReply = platformQaReplyRepository.findById(updatePlatformQaReply.getPlatformQaReplyNo()).get();
        foundPlatformQaReply.setPlatformQaReplyContent(updatePlatformQaReply.getPlatformQaReplyContent());
    }

    /**
     * removePlatformQaReply : 1:1문의 답변을 삭제합니다.
     * @param platformQaReplyNo : 삭제할 1:1문의 답변 번호
     *
     * @author 차화응
     */
    @Transactional
    public void removePlatformQaReply(int platformQaReplyNo) {

        platformQaReplyRepository.deleteById(platformQaReplyNo);
    }

}
