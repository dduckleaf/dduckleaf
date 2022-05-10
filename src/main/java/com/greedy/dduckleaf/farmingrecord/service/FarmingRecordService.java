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

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : FarmingRecordService
 * Comment : 농사일지
 * History
 * 2022-05-07 (차화응) 처음 작성 / 농사일지 목록조회 메소드 작성
 * 2022-05-08 (차화응) 농사일지 상세조회 메소드 작성
 * 2022-05-09 (차화응) 농사일지 작성하기 메소드 작성 / 농사일지 수정하기 메소드 작성
 * 2022-05-10 (차화응) 농사일지 삭제하기 메소드 작성
 * </pre>
 *
 * @version 1.0.5
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

    /**
     * registNewFarmingRecord : 농사일지를 등록합니다.
     * @param newFarmingRecord : 등록할 농사일지 정보를 담은 객체
     *
     * @author 차화응
     */
    @Transactional
    public void registNewFarmingRecord(FarmingRecordDTO newFarmingRecord) {

        newFarmingRecord.setFarmingRecordUploadDate(getDateAndTime());

        farmingRecordRepository.save(modelMapper.map(newFarmingRecord, FarmingRecord.class));
    }

    /**
     * modifyFarmingRecord : 농사일지를 수정합니다.
     * @param updateFarmingRecord : 수정할 농사일지 정보를 담은 객체
     *
     * @author 차화응
     */
    @Transactional
    public void modifyFarmingRecord(FarmingRecordDTO updateFarmingRecord) {

        FarmingRecord foundFarmingRecord = farmingRecordRepository.findById(updateFarmingRecord.getFarmingRecordNo()).get();
        foundFarmingRecord.setFarmingRecordTitle(updateFarmingRecord.getFarmingRecordTitle());
        foundFarmingRecord.setFarmingRecordContent(updateFarmingRecord.getFarmingRecordContent());
    }

    /**
     * removeFarmingRecord : 농사일지를 삭제합니다.
     * @param farmingRecordNo : 삭제할 농사일지 번호
     *
     * @author 차화응
     */
    @Transactional
    public void removeFarmingRecord(int farmingRecordNo) {

        farmingRecordRepository.deleteById(farmingRecordNo);
    }
}
