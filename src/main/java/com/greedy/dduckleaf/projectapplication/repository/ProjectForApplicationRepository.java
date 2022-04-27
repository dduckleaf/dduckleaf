package com.greedy.dduckleaf.projectapplication.repository;

import com.greedy.dduckleaf.projectapplication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectForApplicationRepository extends JpaRepository<Project, Integer> {

//    Project findByFarmerNoAndAndProgressStatus(int farmerNo, int i);
//    Project findByFarmerNoAndAndProgressStatusOrderByProjectNoDesc(int farmerNo, int i);

    @Query(value = "SELECT * FROM TBL_PROJECT P WHERE P.FARMER_NO = :farmerNo AND P.PROGRESS_STATUS = :i ORDER BY P.PROJECT_NO DESC LIMIT 1", nativeQuery = true)
    Project findByFarmerNoAndAndProgressStatus(int farmerNo, int i);


}
