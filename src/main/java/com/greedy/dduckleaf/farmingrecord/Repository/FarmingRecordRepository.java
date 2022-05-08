package com.greedy.dduckleaf.farmingrecord.Repository;

import com.greedy.dduckleaf.farmingrecord.entity.FarmingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <pre>
 * Interface : FarmingRecordRepository
 * Comment : 농사일지
 * History
 * 2022-05-07 (차화응)
 * </pre>
 *
 * @version 1.0.0
 * @author 차화응
 */
public interface FarmingRecordRepository extends JpaRepository<FarmingRecord, Integer> {

    /* 조회수 갱신 */
    @Modifying
    @Query("update FarmingRecord farmingRecord set farmingRecord.farmingRecordCount = farmingRecord.farmingRecordCount + 1 where farmingRecord.farmingRecordNo = :farmingRecordNo")
    int updateFarmingRecordCount(int farmingRecordNo);

}
