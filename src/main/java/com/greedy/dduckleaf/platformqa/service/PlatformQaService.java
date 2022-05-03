package com.greedy.dduckleaf.platformqa.service;

import com.greedy.dduckleaf.platformqa.dto.PlatformQaCategoryDTO;
import com.greedy.dduckleaf.platformqa.dto.PlatformQaDTO;
import com.greedy.dduckleaf.platformqa.entity.PlatformQaCategory;
import com.greedy.dduckleaf.platformqa.repository.PlatformQaCategoryRepository;
import com.greedy.dduckleaf.platformqa.repository.PlatformQaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : PlatformQaService
 * Comment : 1:1 문의
 * History
 * 2022-05-01 (차화응) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
 */
@Service
public class PlatformQaService {

    private final PlatformQaRepository platformQaRepository;
    private final PlatformQaCategoryRepository platformQaCategoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlatformQaService(PlatformQaRepository platformQaRepository, PlatformQaCategoryRepository platformQaCategoryRepository, ModelMapper modelMapper) {
        this.platformQaRepository = platformQaRepository;
        this.platformQaCategoryRepository = platformQaCategoryRepository;
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

}
