package com.greedy.dduckleaf.projectapplication.service;

import com.greedy.dduckleaf.projectapplication.dto.ProjectBasicInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectRewardCategoryDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectShippingInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.entity.*;
import com.greedy.dduckleaf.projectapplication.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class: ProjectApplicationService
 * Comment : 프로젝트 오픈 싱청
 * History
 * 2022/04/25 (박휘림) 처음 작성 / registProjectApplication 메소드 작성 시작
 * 2022/04/27 (박휘림) 기본정보 등록 관련 메소드 registInfo, basicInfo, shippingInfo, refundPolicy, farmerInfo, farmerFinancialInfo /
 *                                         findProjectNoByFarmerId, findRewardRegistInfoByProjectNo 메소드 작성
 * 2022/04/28 (박휘림) modifyBasicReq, modifyRewardAgreementStatus, findProjectBasicInfoByProjectNo, modifyBasicInfo, findAllRewardCategory 메소드 작성
 * 2022/04/29 (박휘림) modifyStory 메소드 작성
 * </pre>
 * @version 1.0.3
 * @author 박휘림
 */
@Service
public class ProjectApplicationService {

    private final ModelMapper modelMapper;
    private final RewardRegistInfoRepository rewardRegistInfoRepository;
    private final ProjectForApplicationRepository projectRepository;
    private final ProjectApplicationInfoRepository projectApplicationInfoRepository;
    private final ProjectShippingInfoRepository projectShippingInfoRepository;
    private final ProjectBasicInfoRepository projectBasicInfoRepository;
    private final FarmerInfoForProjectApplicationRepository farmerInfoRepository;
    private final RefundPolicyForProjectApplicationRepository refundPolicyRepository;
    private final FarmerFinancialInfoRepository farmerFinancialInfoRepository;
    private final ProjectRewardCategoryForProjectApplicationRepository projectRewardCategoryRepository;

    @Autowired
    public ProjectApplicationService(ModelMapper modelMapper, RewardRegistInfoRepository rewardRegistInfoRepository, ProjectForApplicationRepository projectRepository, ProjectApplicationInfoRepository projectApplicationInfoRepository, ProjectShippingInfoRepository projectShippingInfoRepository, ProjectBasicInfoRepository projectBasicInfoRepository, FarmerInfoForProjectApplicationRepository farmerInfoRepository, RefundPolicyForProjectApplicationRepository refundPolicyRepository, FarmerFinancialInfoRepository farmerFinancialInfoRepository, ProjectRewardCategoryForProjectApplicationRepository projectRewardCategoryRepository) {
        this.modelMapper = modelMapper;
        this.rewardRegistInfoRepository = rewardRegistInfoRepository;
        this.projectRepository = projectRepository;
        this.projectApplicationInfoRepository = projectApplicationInfoRepository;
        this.projectShippingInfoRepository = projectShippingInfoRepository;
        this.projectBasicInfoRepository = projectBasicInfoRepository;
        this.farmerInfoRepository = farmerInfoRepository;
        this.refundPolicyRepository = refundPolicyRepository;
        this.farmerFinancialInfoRepository = farmerFinancialInfoRepository;
        this.projectRewardCategoryRepository = projectRewardCategoryRepository;
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

        projectRepository.save(openProject);

        Project foundProject = projectRepository.findById(openProject.getProjectNo()).get();

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

        refundPolicyRepository.save(refundPolicy);

        farmerInfoRepository.save(farmerInfo(farmerNo));
        farmerFinancialInfoRepository.save(farmerFinancialInfo(farmerNo));

    }

    private RewardRegistInfo registInfo(int farmerNo) {

        RewardRegistInfo reward = new RewardRegistInfo();
        reward.setRewardAgreementDate("0000-00-00");
        System.out.println("reward = " + reward);

        return reward;
    }

    private ProjectBasicInfo basicInfo(int farmerNo) {

        ProjectBasicInfo projectBasicInfo = new ProjectBasicInfo();
        ProjectRewardCategory category = new ProjectRewardCategory();
        projectBasicInfo.setProjectRewardCategory(category);
        System.out.println("projectBasicInfo = " + projectBasicInfo);

        return projectBasicInfo;
    }

    private ProjectShippingInfo shippingInfo(int farmerNo) {

        ProjectShippingInfo shippingInfo = new ProjectShippingInfo();
        System.out.println("shippingInfo = " + shippingInfo);

        return shippingInfo;
    }

    private RefundPolicy refundPolicy(int farmerNo) {

        RefundPolicy refundPolicy = new RefundPolicy();
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

        Project project = projectRepository.findByFarmerNoAndAndProgressStatus(farmerNo, 1);

        return project != null? project.getProjectNo() : 0;
    }

    /**
     * findRewardRegistInfoByProjectNo: 기본 요건 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박휘림
     */
    public RewardRegistInfoDTO findRewardRegistInfoByProjectNo(int projectNo) {

        RewardRegistInfo basicReq = rewardRegistInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(basicReq, RewardRegistInfoDTO.class);
    }

    /**
     * modifyBasicReq: 기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyBasicReq(RewardRegistInfoDTO basicreq) {

        RewardRegistInfo updateBasicReq = rewardRegistInfoRepository.findByProjectNo(basicreq.getProjectNo());
        updateBasicReq.setRewardPreparingStatus(basicreq.getRewardPreparingStatus());
        updateBasicReq.setRewardDeliveryPlan(basicreq.getRewardDeliveryPlan());
    }

    /**
     * modifyRewardAgreementStatus: 사용자가 리워드 관련 서류 제출에 동의 시 동의 여부와 날짜를 업데이트합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyRewardAgreementStatus(RewardRegistInfoDTO basicreq) {

        RewardRegistInfo updateBasicReq = rewardRegistInfoRepository.findByProjectNo(basicreq.getProjectNo());
        updateBasicReq.setRewardAgreementStatus("Y");
//        updateBasicReq.setRewardAgreementDate("0000-00-00");
    }

    /**
     * findProjectBasicInfoByProjectNo: 기본 정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박휘림
     */
    public ProjectBasicInfoDTO findProjectBasicInfoByProjectNo(int projectNo) {

        ProjectBasicInfo basicInfo = projectBasicInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(basicInfo, ProjectBasicInfoDTO.class);
    }

    /**
     * modifyBasicInfo: 기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicInfo: 사용자가 입력한 기본 정보 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyBasicInfo(ProjectBasicInfoDTO basicInfo) {
        System.out.println("basicInfo 서비스!!! = " + basicInfo);
        ProjectBasicInfo updateBasicInfo = projectBasicInfoRepository.findByProjectNo(basicInfo.getProjectNo());
        System.out.println("updateBasicInfo = " + updateBasicInfo);
        updateBasicInfo.setProjectName(basicInfo.getProjectName());
        updateBasicInfo.setProjectTargetFund(basicInfo.getProjectTargetFund());
        updateBasicInfo.setProjectEndDate(basicInfo.getProjectEndDate());

        ProjectRewardCategory category = projectRewardCategoryRepository.findById(basicInfo.getProjectRewardCategory().getProjectCategoryNo()).get();
        System.out.println("category = " + category);
        updateBasicInfo.setProjectRewardCategory(category);
    }

    /**
     * findAllRewardCategory: 리워드 카테고리를 조회합니다.
     * @return 카테고리 목록
     * @author 박휘림
     */
    public List<ProjectRewardCategoryDTO> findAllRewardCategory() {

        List<ProjectRewardCategory> categoryList = projectRewardCategoryRepository.findAll();

        return categoryList.stream().map(projectRewardCategory -> modelMapper.map(projectRewardCategory, ProjectRewardCategoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * modifyStory: 스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param story: 사용자가 입력한 스토리 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyStory(ProjectBasicInfoDTO story) {
        System.out.println("story = " + story);
        ProjectBasicInfo updateStory = projectBasicInfoRepository.findByProjectNo(story.getProjectNo());
        updateStory.setProjectInfo(story.getProjectInfo());
        System.out.println("updateStory = " + updateStory);
    }

    /**
     * modifyPromotionAgreementStatus: 사용자가 프로젝트 홍보 심의에 동의 시 동의 여부와 날짜를 업데이트합니다.
     * @param story: 사용자가 입력한 스토리 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyPromotionAgreementStatus(ProjectBasicInfoDTO story) {

        ProjectBasicInfo updateStory = projectBasicInfoRepository.findByProjectNo(story.getProjectNo());
        updateStory.setProjectPromotionAgreementStatus("Y");
//        updateBasicReq.setRewardAgreementDate("0000-00-00");
    }

    /**
     * findRewardByProjectNo: 리워드 정보를 조회합니다.
     * @param projectNo :프로젝트 번호
     * @return 리워드 정보
     * @author 박휘림
     */
    public RewardRegistInfoDTO findRewardByProjectNo(int projectNo) {

        RewardRegistInfo reward = rewardRegistInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(reward, RewardRegistInfoDTO.class);
    }

    public ProjectShippingInfoDTO findShippingInfoByProjectNo(int projectNo) {

        ProjectShippingInfo shippingInfo = projectShippingInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(shippingInfo, ProjectShippingInfoDTO.class);
    }

    public void modifyReward(RewardRegistInfoDTO reward, ProjectShippingInfoDTO shippingInfo) {

        RewardRegistInfo updateReward = rewardRegistInfoRepository.findByProjectNo(reward.getProjectNo());
        updateReward.setRewardPrice(reward.getRewardPrice());
        updateReward.setRewardName(reward.getRewardName());
        updateReward.setRewardInfo(reward.getRewardInfo());

        ProjectShippingInfo updateShippingInfo = projectShippingInfoRepository.findByProjectNo(shippingInfo.getProjectNo());
        updateShippingInfo.setShippingFee(shippingInfo.getShippingFee());
        updateShippingInfo.setExtraShippingFee(shippingInfo.getExtraShippingFee());
        updateShippingInfo.setShippingDueDate(shippingInfo.getShippingDueDate());
    }


}
