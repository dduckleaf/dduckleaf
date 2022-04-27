package com.greedy.dduckleaf.projectapplication.service;

import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.entity.*;
import com.greedy.dduckleaf.projectapplication.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class: ProjectApplicationService
 * Comment : 프로젝트 오픈 싱청
 * History
 * 2022/04/25 (박휘림) 처음 작성 / 프로젝트 오픈 신청 시 관련 테이블에 기본값 인서트 메소드 작성 시작 / 기본 요건 페이지 조회
 * </pre>
 * @version 1.0.1
 * @author 박휘림
 */
@Service
public class ProjectApplicationService {

    private final ModelMapper modelMapper;
    private final RewardRegistInfoRepository rewardRegistInfoRepository;
    private final ProjectForApplicationRepository projectForApplicationRepository;
    private final ProjectApplicationInfoRepository projectApplicationInfoRepository;
    private final ProjectShippingInfoRepository projectShippingInfoRepository;
    private final ProjectBasicInfoRepository projectBasicInfoRepository;
    private final FarmerInfoForProjectApplicationRepository farmerInfoForProjectApplicationRepository;
    private final RefundPolicyForProjectApplicationRepository refundPolicyForProjectApplicationRepository;
    private final FarmerFinancialInfoRepository farmerFinancialInfoRepository;

    @Autowired
    public ProjectApplicationService(ModelMapper modelMapper, RewardRegistInfoRepository rewardRegistInfoRepository, ProjectForApplicationRepository projectForApplicationRepository, ProjectApplicationInfoRepository projectApplicationInfoRepository, ProjectShippingInfoRepository projectShippingInfoRepository, ProjectBasicInfoRepository projectBasicInfoRepository, FarmerInfoForProjectApplicationRepository farmerInfoForProjectApplicationRepository, RefundPolicyForProjectApplicationRepository refundPolicyForProjectApplicationRepository, FarmerFinancialInfoRepository farmerFinancialInfoRepository) {
        this.modelMapper = modelMapper;
        this.rewardRegistInfoRepository = rewardRegistInfoRepository;
        this.projectForApplicationRepository = projectForApplicationRepository;
        this.projectApplicationInfoRepository = projectApplicationInfoRepository;
        this.projectShippingInfoRepository = projectShippingInfoRepository;
        this.projectBasicInfoRepository = projectBasicInfoRepository;
        this.farmerInfoForProjectApplicationRepository = farmerInfoForProjectApplicationRepository;
        this.refundPolicyForProjectApplicationRepository = refundPolicyForProjectApplicationRepository;
        this.farmerFinancialInfoRepository = farmerFinancialInfoRepository;
    }

    /* 프로젝트 신청 시 프로젝트 기본데이터 등록하고 프로젝트 번호 리턴 */
    private int openProject(int farmerNo) {

        Project openProject = new Project();
        openProject.setFarmerNo(farmerNo);
        openProject.setProgressStatus(1);
        System.out.println("openProject = " + openProject);

        projectForApplicationRepository.save(openProject);

        Project foundProject = projectForApplicationRepository.findById(openProject.getProjectNo()).get();

        return foundProject.getProjectNo();
    }

    /**
     * registProjectApplication: 프로젝트 신청 버튼 클릭 시 기본데이터를 인서트합니다.
     * @param farmerNo: 회원번호
     * @author 박휘림
     */
    @Transactional
    public void registProjectApplication(int farmerNo) {

        Project openProject = new Project();
        openProject.setFarmerNo(farmerNo);
        openProject.setProgressStatus(1);

        projectForApplicationRepository.save(openProject);

        Project foundProject = projectForApplicationRepository.findById(openProject.getProjectNo()).get();

        RewardRegistInfo rewardRegistInfo = registInfo(farmerNo);
        rewardRegistInfo.setProjectNo(foundProject.getProjectNo());

        rewardRegistInfoRepository.save(rewardRegistInfo);

        ProjectBasicInfo basicInfo = basicInfo(farmerNo);
        basicInfo.setProjectNo(foundProject.getProjectNo());

        projectBasicInfoRepository.save(basicInfo);

        ProjectShippingInfo shippingInfo = shippingInfo(farmerNo);
        shippingInfo.setProjectNo(foundProject.getProjectNo());

        projectShippingInfoRepository.save(shippingInfo);

        RefundPolicy refundPolicy = refundPolicy(farmerNo);
        refundPolicy.setProjectNo(foundProject.getProjectNo());

        refundPolicyForProjectApplicationRepository.save(refundPolicy);

        farmerInfoForProjectApplicationRepository.save(farmerInfo(farmerNo));
        farmerFinancialInfoRepository.save(farmerFinancialInfo(farmerNo));

    }

    private RewardRegistInfo registInfo(int farmerNo) {

        RewardRegistInfo reward = new RewardRegistInfo();
        System.out.println("reward = " + reward);

        return reward;
    }

    private ProjectBasicInfo basicInfo(int farmerNo) {

        ProjectBasicInfo projectBasicInfo = new ProjectBasicInfo();
//        projectBasicInfo.setProjectNo(openProject(farmerNo));
        projectBasicInfo.setProjectBasicCategoryNo(1);
        System.out.println("projectBasicInfo = " + projectBasicInfo);

        return projectBasicInfo;
    }

    private ProjectShippingInfo shippingInfo(int farmerNo) {

        ProjectShippingInfo shippingInfo = new ProjectShippingInfo();
//        shippingInfo.setProjectNo(openProject(farmerNo));
        System.out.println("shippingInfo = " + shippingInfo);

        return shippingInfo;
    }

    private RefundPolicy refundPolicy(int farmerNo) {

        RefundPolicy refundPolicy = new RefundPolicy();
//        refundPolicy.setProjectNo(openProject(farmerNo));
        System.out.println("refundPolicy = " + refundPolicy);

        return refundPolicy;
    }

    private FarmerInfo farmerInfo(int farmerNo) {

        FarmerInfo farmerInfo = new FarmerInfo();
        farmerInfo.setMemberNo(farmerNo);
        farmerInfo.setBusinessName("상호명");
        farmerInfo.setBusinessOwnNo("사업자 등록번호");
        farmerInfo.setBusinessOwnType("사업자 유형");
        farmerInfo.setCorporateName("법인명");
        farmerInfo.setFarmerName("파머 이름");
        farmerInfo.setFarmerEmail("이메일");
        farmerInfo.setFarmerPhone("전화번호");
        farmerInfo.setRepresentativeName("대표자명");
        farmerInfo.setRepresentativeEmail("대표자이메일");
        farmerInfo.setRepresentativeSSN("주민등록번호");
        System.out.println("farmerInfo = " + farmerInfo);

        return farmerInfo;
    }

    private FarmerFinancialInfo farmerFinancialInfo(int farmerNo) {

        FarmerFinancialInfo farmerFinancialInfo = new FarmerFinancialInfo();
        farmerFinancialInfo.setFarmerNo(farmerNo);
        farmerFinancialInfo.setBankNo(1);

        return farmerFinancialInfo;
    }

    /**
     * findProjectNoByFarmerId: 회원번호로 프로젝트 번호를 조회합니다.
     * @param farmerNo: 회원번호
     * @return projectNo 프로젝트 번호
     * @author 박휘림
     */
    public int findProjectNoByFarmerId(int farmerNo) {

        Project project = projectForApplicationRepository.findByFarmerNoAndAndProgressStatus(farmerNo, 1);

        return project != null? project.getProjectNo() : 0;
    }

    /**
     * findRewardRegistInfoByProjectNo: 기본 요건 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param projectNo: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박휘림
     */
    public RewardRegistInfoDTO findRewardRegistInfoByProjectNo(int projectNo) {

        RewardRegistInfo basicReq = rewardRegistInfoRepository.findById(projectNo).get();

        return modelMapper.map(basicReq, RewardRegistInfoDTO.class);
    }

    /**
     * modifyBasicReq: 기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyBasicReq(RewardRegistInfoDTO basicreq) {

        RewardRegistInfo updateBasicReq = rewardRegistInfoRepository.findById(basicreq.getProjectNo()).get();
        updateBasicReq.setRewardPreparingStatus(basicreq.getRewardPreparingStatus());
        updateBasicReq.setRewardDeliveryPlan(basicreq.getRewardDeliveryPlan());
    }

}
