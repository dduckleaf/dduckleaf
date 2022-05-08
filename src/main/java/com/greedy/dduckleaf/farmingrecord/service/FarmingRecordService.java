package com.greedy.dduckleaf.farmingrecord.service;

import com.greedy.dduckleaf.farmingrecord.Repository.FarmingRecordRepository;
import com.greedy.dduckleaf.farmingrecord.dto.FarmingRecordDTO;
import com.greedy.dduckleaf.farmingrecord.entity.FarmingRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class : FarmingRecordService
 * Comment : 농사일지
 * History
 * 2022-05-07 (차화응) / 처음 작성
 * </pre>
 *
 * @version 1.0.0
 * @author 차화응
 */
@Service
public class FarmingRecordService {

    private final FarmingRecordRepository farmingRecordRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FarmingRecordService(FarmingRecordRepository farmingRecordRepository, ModelMapper modelMapper) {
        this.farmingRecordRepository = farmingRecordRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findFarmingRecordList : 농사일지 목록을 조회합니다.
     * @param pageable : 페이징 정보를 담는 객체
     *
     * @author 차화응
     */
    public Page<FarmingRecordDTO> findFarmingRecordList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("farmingRecordNo").descending());

        return farmingRecordRepository.findAll(pageable).map(farmingRecord -> modelMapper.map(farmingRecord, FarmingRecordDTO.class));
    }

    /**
     * updateFarmingRecordCount : 농사일지 조회수를 갱신합니다.
     * @param farmingRecordNo : 조회할 농사일지 번호
     *
     * @author 차화응
     */
    @Transactional
    public int updateFarmingRecordCount(int farmingRecordNo) {

        return farmingRecordRepository.updateFarmingRecordCount(farmingRecordNo);
    }

    /**
     * findFarmingRecordDetail : 농사일지 상세정보를 조회합니다.
     * @param farmingRecordNo : 조회할 농사일지 번호
     *
     * @author 차화응
     */
    public FarmingRecordDTO findFarmingRecordDetail(int farmingRecordNo) {

        FarmingRecord farmingRecord = farmingRecordRepository.findById(farmingRecordNo).get();

        return modelMapper.map(farmingRecord, FarmingRecordDTO.class);
    }

}
