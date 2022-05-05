package com.greedy.dduckleaf.projectapplication.projectapplication.service;

import com.greedy.dduckleaf.projectapplication.dto.*;
import com.greedy.dduckleaf.projectapplication.entity.*;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.*;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
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
 * 2022/04/29 (박휘림) modifyStory, modifyPromotionAgreementStatus, findRewardByProjectNo, findShippingInfoByProjectNo, modifyReward 메소드 작성
 * 2022/04/30 (박휘림) findPolicyByProjectNo, modifyPolicy, modifyPolicyAgreementStatus, findFarmerInfoByMemberNo, findHomePageByFarmerNo 메소드 작성
 * 2022/05/01 (박휘림) findFarmerFinancialInfoByMemberNo, findAllBank, modifyRepresentative, modifySettlementPolicyCheckStatus, sendPhoneVerification,
 *                      modifyBasicInfoAttachment, modifyFarmerInfoAttachment 메소드 작성
 * 2022/05/02 (박휘림) registProjectApplicationInfo 메소드 작성
 * </pre>
 * @version 1.0.6
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
    private final BankForProjectApplicationRepository bankRepository;
    private final MemberForApplicationRepository memberRepository;
    private final ProjectAttachmentForProjectApplicationRepository projectAttachmentRepository;

    @Autowired
    public ProjectApplicationService(ModelMapper modelMapper, RewardRegistInfoRepository rewardRegistInfoRepository, ProjectForApplicationRepository projectRepository, ProjectApplicationInfoRepository projectApplicationInfoRepository, ProjectShippingInfoRepository projectShippingInfoRepository, ProjectBasicInfoRepository projectBasicInfoRepository, FarmerInfoForProjectApplicationRepository farmerInfoRepository, RefundPolicyForProjectApplicationRepository refundPolicyRepository, FarmerFinancialInfoRepository farmerFinancialInfoRepository, ProjectRewardCategoryForProjectApplicationRepository projectRewardCategoryRepository, BankForProjectApplicationRepository bankRepository, MemberForApplicationRepository memberRepository, ProjectAttachmentForProjectApplicationRepository projectAttachmentRepository) {
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
        this.bankRepository = bankRepository;
        this.memberRepository = memberRepository;
        this.projectAttachmentRepository = projectAttachmentRepository;
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

//        Bank bank =

    }

    private RewardRegistInfo registInfo(int farmerNo) {

        RewardRegistInfo reward = new RewardRegistInfo();
        reward.setRewardAgreementDate(java.sql.Date.valueOf(LocalDate.now()).toString());
        System.out.println("reward = " + reward);

        return reward;
    }

    private ProjectBasicInfo basicInfo(int farmerNo) {

        ProjectRewardCategory category = projectRewardCategoryRepository.findById(1).get();
        ProjectBasicInfo projectBasicInfo = new ProjectBasicInfo();
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

        Bank bank = bankRepository.findById(1).get();

        FarmerFinancialInfo farmerFinancialInfo = new FarmerFinancialInfo();
        farmerFinancialInfo.setFarmerNo(farmerNo);
        farmerFinancialInfo.setBank(bank);
        System.out.println("farmerFinancialInfo = " + farmerFinancialInfo);

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
        updateBasicReq.setRewardAgreementDate(java.sql.Date.valueOf(LocalDate.now()).toString());
    }

    /**
     * findProjectBasicInfoByProjectNo: 기본 정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     * @author 박휘림
     */
    public ProjectBasicInfoDTO findProjectBasicInfoByProjectNo(int projectNo) {

        ProjectBasicInfo basicInfo = projectBasicInfoRepository.findByProjectNo(projectNo);
        System.out.println("basicInfo = " + basicInfo);
        return modelMapper.map(basicInfo, ProjectBasicInfoDTO.class);
    }

    /**
     * modifyBasicInfo: 기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicInfo : 사용자가 입력한 기본 정보 데이터를 담은 객체
     * @param project
     * @author 박휘림
     */
    @Transactional
    public void modifyBasicInfo(ProjectBasicInfoDTO basicInfo, ProjectDTO project) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = basicInfo.getProjectEndDate();
        java.util.Date open = null;
        String openDate = null;
        try {
            open = format.parse(strDate);

            Calendar cal = Calendar.getInstance();
            cal.setTime(open);
            cal.add(Calendar.MONTH, -1);

            openDate = format.format(cal.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("project = " + project);
        ProjectBasicInfo updateBasicInfo = projectBasicInfoRepository.findByProjectNo(basicInfo.getProjectNo());
        updateBasicInfo.setProjectName(basicInfo.getProjectName());
        updateBasicInfo.setProjectTargetFund(basicInfo.getProjectTargetFund());
        updateBasicInfo.setProjectEndDate(basicInfo.getProjectEndDate());
        updateBasicInfo.setProjectOpenDate(openDate);
        updateBasicInfo.setProjectMaxTarget(project.getMaxTargetAmount());

        ProjectRewardCategory category = projectRewardCategoryRepository.findById(basicInfo.getProjectRewardCategory().getProjectCategoryNo()).get();
        updateBasicInfo.setProjectRewardCategory(category);

        Project updateProject = projectRepository.findById(project.getProjectNo()).get();
        updateProject.setProjectName(basicInfo.getProjectName());
        updateProject.setEndDate(basicInfo.getProjectEndDate());
        updateProject.setOpenDate(openDate);
        updateProject.setFundTargetAmount(basicInfo.getProjectTargetFund());
        updateProject.setMaxTargetAmount(project.getMaxTargetAmount());
        System.out.println("updateProject = " + updateProject);
    }

    /**
     * modifyBasicInfoAttachment: 기본 정보 페이지에서 사용자가 업로드한 이미지를 업로드합니다.
     * @param attachment: 사용자가 업로드한 파일 정보 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyBasicInfoAttachment(ProjectAttachmentDTO attachment) {

        System.out.println("attachment 서비스 = " + attachment);

        ProjectAttachment projectAttachment = projectAttachmentRepository.findBasicInfoAttachmentByProjectNo(attachment.getProjectNo());
        System.out.println("projectAttachment 서비스! = " + projectAttachment);
        if(projectAttachment == null) {
            attachment.setProjectAttachmentCategory("대표이미지");
//            attachment.setProjectBasicInfoNo(projectAttachment.getProjectBasicInfoNo());
//            attachment.setFinancialInfoNo(projectAttachment.getFinancialInfoNo());
            projectAttachmentRepository.save(modelMapper.map(attachment, ProjectAttachment.class));
            System.out.println("projectAttachment 저장 성공 = " + projectAttachment);
        } else {
//            projectAttachment.setProjectBasicInfoNo(attachment.getProjectBasicInfoNo());
            projectAttachment.setProjectAttachmentOriginalName(attachment.getProjectAttachmentOriginalName());
            projectAttachment.setProjectAttachmentSaveName(attachment.getProjectAttachmentSaveName());
            projectAttachment.setProjectAttachmentSavePath(attachment.getProjectAttachmentSavePath());
            System.out.println("projectAttachment 수정 성공 = " + projectAttachment);
        }
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

        ProjectBasicInfo updateStory = projectBasicInfoRepository.findByProjectNo(story.getProjectNo());
        updateStory.setProjectInfo(story.getProjectInfo());
    }

    /**
     * modifyStoryAttachment: 스토리 페이지에서 사용자가 업로드한 이미지를 업로드합니다.
     * @param attachment: 사용자가 업로드한 파일 정보 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyStoryAttachment(ProjectAttachmentDTO attachment) {

//        ProjectAttachment introAttachment = projectAttachmentRepository.findIntroAttachmentByProjectNo(attachment.getProjectNo());
        ProjectAttachment storyAttachment = projectAttachmentRepository.findStoryAttachmentByProjectNo(attachment.getProjectNo());
        System.out.println("storyAttachment 서비스 = " + storyAttachment);

        if(storyAttachment == null) {
            attachment.setProjectAttachmentCategory("스토리사진");
            projectAttachmentRepository.save(modelMapper.map(attachment, ProjectAttachment.class));
            System.out.println("storyAttachment 저장 성공 = " + storyAttachment);
        } else {
//            storyAttachment.setProjectBasicInfoNo(attachment.getProjectBasicInfoNo());
            storyAttachment.setProjectAttachmentOriginalName(attachment.getProjectAttachmentOriginalName());
            storyAttachment.setProjectAttachmentSaveName(attachment.getProjectAttachmentSaveName());
            storyAttachment.setProjectAttachmentSavePath(attachment.getProjectAttachmentSavePath());
            System.out.println("storyAttachment 수정 성공 = " + storyAttachment);
        }

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
        updateStory.setPromotionAgreementDate(java.sql.Date.valueOf(LocalDate.now()).toString());
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

    /**
     * findShippingInfoByProjectNo: 배송 정보를 조회합니다.
     * @param projectNo :프로젝트 번호
     * @return 배송 정보
     * @author 박휘림
     */
    public ProjectShippingInfoDTO findShippingInfoByProjectNo(int projectNo) {

        ProjectShippingInfo shippingInfo = projectShippingInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(shippingInfo, ProjectShippingInfoDTO.class);
    }

    /**
     * modifyReward: 리워드 설계 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param reward: 사용자가 입력한 리워드 정보를 담은 객체
     * @param shippingInfo: 사용자가 입력한 배송 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
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

    /**
     * findPolicyByProjectNo: 정책 정보를 조회합니다.
     * @param projectNo :프로젝트 번호
     * @return 정책 정보
     * @author 박휘림
     */
    public RefundPolicyDTO findPolicyByProjectNo(int projectNo) {

        RefundPolicy policy = refundPolicyRepository.findByProjectNo(projectNo);

        return modelMapper.map(policy, RefundPolicyDTO.class);
    }

    /**
     * modifyStory: 정책 작성 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param policy: 사용자가 입력한 정책정보 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyPolicy(RefundPolicyDTO policy) {

        RefundPolicy updatePolicy = refundPolicyRepository.findByProjectNo(policy.getProjectNo());
        updatePolicy.setRefundPolicyContent(policy.getRefundPolicyContent());
    }

    /**
     * modifyPolicyAgreementStatus: 사용자가 펀딩금 반화 정책 정보에 동의 시 동의 여부와 날짜를 업데이트합니다.
     * @param policy: 사용자가 입력한 정책 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyPolicyAgreementStatus(RefundPolicyDTO policy) {

        RefundPolicy updatePolicy = refundPolicyRepository.findByProjectNo(policy.getProjectNo());
        updatePolicy.setRefundPolicyAgreementStatus("Y");
        updatePolicy.setRefundPolicyAgreementDate(java.sql.Date.valueOf(LocalDate.now()).toString());
    }

    /**
     * findFarmerInfoByMemberNo: 파머 정보를 조회합니다.
     * @param memberNo :회원 번호
     * @return 파머 정보
     * @author 박휘림
     */
    public FarmerInfoDTO findFarmerInfoByMemberNo(int memberNo) {

        FarmerInfo farmerInfo = farmerInfoRepository.findByMemberNo(memberNo);

        return modelMapper.map(farmerInfo, FarmerInfoDTO.class);
    }

    /**
     * modifyFarmerInfo: 파머정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param farmerInfo: 사용자가 입력한 파머 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyFarmerInfo(FarmerInfoDTO farmerInfo) {

        FarmerInfo updateFarmerInfo = farmerInfoRepository.findByMemberNo(farmerInfo.getMemberNo());
        updateFarmerInfo.setFarmerName(farmerInfo.getFarmerName());
        updateFarmerInfo.setFarmerEmail(farmerInfo.getFarmerEmail());
        updateFarmerInfo.setFarmerPhone(farmerInfo.getFarmerPhone());
        updateFarmerInfo.setKakaotTalkChannel(farmerInfo.getKakaotTalkChannel());
        updateFarmerInfo.setHomepageURL(farmerInfo.getHomepageURL());
    }

    /**
     * modifyFarmerInfoAttachment: 스토리 페이지에서 사용자가 업로드한 이미지를 업로드합니다.
     * @param attachment: 사용자가 업로드한 파일 정보 데이터를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyFarmerInfoAttachment(ProjectAttachmentDTO attachment) {

        ProjectAttachment projectAttachment = projectAttachmentRepository.findFarmerInfoAttachment(attachment.getProjectNo());

        System.out.println("projectAttachment 파머사진 업데이트 서비스! = " + projectAttachment);
        if(projectAttachment == null) {
            attachment.setProjectAttachmentCategory("파머사진");
            System.out.println("attachment = " + attachment);
            projectAttachmentRepository.save(modelMapper.map(attachment, ProjectAttachment.class));
            System.out.println("projectAttachment 저장 성공 = " + projectAttachment);
        } else {
            projectAttachment.setProjectAttachmentOriginalName(attachment.getProjectAttachmentOriginalName());
            projectAttachment.setProjectAttachmentSaveName(attachment.getProjectAttachmentSaveName());
            projectAttachment.setProjectAttachmentSavePath(attachment.getProjectAttachmentSavePath());
            System.out.println("projectAttachment 수정 성공 = " + projectAttachment);
        }

    }

    /**
     * findFarmerFinancialInfoByMemberNo: 대표자 정보를 조회합니다.
     * @param memberNo :회원 번호
     * @return 대표자 정보
     * @author 박휘림
     */
    public FarmerFinancialInfoDTO findFarmerFinancialInfoByMemberNo(int memberNo) {

        FarmerFinancialInfo financialInfo = farmerFinancialInfoRepository.findByMemberNo(memberNo);
        System.out.println("financialInfo = " + financialInfo);
        return modelMapper.map(financialInfo, FarmerFinancialInfoDTO.class);
    }

    /**
     * findAllBank: 은행 리스트를 조회합니다.
     * @return 은행 리스트
     * @author 박휘림
     */
    public List<BankDTO> findAllBank() {

        List<Bank> bankList = bankRepository.findAll();

        return bankList.stream().map(bank -> modelMapper.map(bank, BankDTO.class)).collect(Collectors.toList());
    }

    /**
     * modifyReward: 대표자 및 정산정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param farmerInfo: 사용자가 입력한 파머 정보를 담은 객체
     * @param financialInfo: 사용자가 입력한 대표자 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyRepresentative(FarmerInfoDTO farmerInfo, FarmerFinancialInfoDTO financialInfo) {

        FarmerInfo updateFarmerInfo = farmerInfoRepository.findByMemberNo(farmerInfo.getMemberNo());
        updateFarmerInfo.setBusinessOwnType(farmerInfo.getBusinessOwnType());
        updateFarmerInfo.setBusinessOwnNo(farmerInfo.getBusinessOwnNo());
        updateFarmerInfo.setBusinessName(farmerInfo.getBusinessName());
        updateFarmerInfo.setBusinessName(farmerInfo.getBusinessName());
        updateFarmerInfo.setRepresentativeName(farmerInfo.getRepresentativeName());
        updateFarmerInfo.setRepresentativeEmail(farmerInfo.getRepresentativeEmail());
        updateFarmerInfo.setRepresentativeSSN(farmerInfo.getRepresentativeSSN());

        Bank bank = bankRepository.findById(financialInfo.getBank().getBankNo()).get();
        System.out.println("bank = " + bank);
        FarmerFinancialInfo updateFinancialInfo = farmerFinancialInfoRepository.findByMemberNo(financialInfo.getFarmerNo());
        updateFinancialInfo.setTaxReceiveEmail(financialInfo.getTaxReceiveEmail());
        updateFinancialInfo.setFarmerAccount(financialInfo.getFarmerAccount());
        updateFinancialInfo.setFarmerName(financialInfo.getFarmerName());
        updateFinancialInfo.setBank(bank);
        System.out.println("updateFinancialInfo = " + updateFinancialInfo);
    }

    /**
     * modifySettlementPolicyCheckStatus: 사용자가 정산 정책을 확인 시 확인 여부와 날짜를 업데이트합니다.
     * @param financialInfo: 사용자가 입력한 대표자 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifySettlementPolicyCheckStatus(FarmerFinancialInfoDTO financialInfo) {

        FarmerFinancialInfo updateFinancialInfo = farmerFinancialInfoRepository.findByMemberNo(financialInfo.getFarmerNo());
        updateFinancialInfo.setSettlementPolicyCheckStatus("Y");
        updateFinancialInfo.setSettlementPolicyCheckDate(java.sql.Date.valueOf(LocalDate.now()).toString());
    }

    /**
     * sendPhoneVerification: 입력받은 휴대폰 번호로 인증번호를 전송합니다.
     * @param phone: 인증 번호를 받을 휴대폰 번호
     * @return 결과에 따라 다른 메시지를 return합니다.
     * @author 박휘림
     */
    public String sendPhoneVerification(String phone) {

        Member member = memberRepository.findMemberByPhone(phone);
        System.out.println("member = " + member);
        if(phone.length() == 0){
            return "휴대폰 번호를 입력해주세요.";
        }

        if(phone.length() > 0 && !(phone.length() == 11)) {
            return "휴대폰 번호가 유효하지 않습니다.";
        }

        if(member != null) {
            return "이미 사용중인 휴대전화 번호입니다.";
        }

        String code = (int) (Math.random() * 899999) + 100000 + "";
        String api_key = "NCSMW5CKIIGCIUO1";
        String api_secret = "GTY9AORLARLD0KNOSO1AND3KFOREO9N9";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", phone);
        params.put("from", "01066933114");
        params.put("type", "SMS");
        params.put("text", code);
        params.put("app_version", "test app 1.2");

        JSONObject obj = new JSONObject();

        try {
            obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch(CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        if("".equals(obj)) {
            return  "인증번호 전송 실패";
        }

        return code;
    }

    /**
     * registProjectApplicationInfo: 프로젝트 심사 신청 시 신청내역으로 인서트하는 메소드
     * @param projectNo: 프로젝트 번호
     * @param memberNo: 회원 번호
     * @author 박휘림
     */
    @Transactional
    public void registProjectApplicationInfo(int projectNo, int memberNo) {

        ProjectBasicInfo basicInfo = projectBasicInfoRepository.findByProjectNo(projectNo);
        ProjectShippingInfo shippingInfo = projectShippingInfoRepository.findByProjectNo(projectNo);
        RewardRegistInfo rewardRegistInfo = rewardRegistInfoRepository.findByProjectNo(projectNo);
        RefundPolicy refundPolicy = refundPolicyRepository.findByProjectNo(projectNo);
        Project project = projectRepository.findByProjectNo(projectNo);
        project.setExamineStatus("승인요청");
        System.out.println("신청하는 project 정보 = " + project);
        FarmerInfo farmer = farmerInfoRepository.findByFarmerNo(memberNo);
        System.out.println("신청하는 farmer 정보 = " + farmer);
        ProjectApplicationInfo projectApplicationInfo = new ProjectApplicationInfo();
        projectApplicationInfo.setProject(project);
        projectApplicationInfo.setProjectBasicInfo(basicInfo);
        projectApplicationInfo.setProjectShippingInfo(shippingInfo);
        projectApplicationInfo.setRewardRegistInfo(rewardRegistInfo);
        projectApplicationInfo.setRefundPolicy(refundPolicy);
        projectApplicationInfo.setFarmer(farmer);

        System.out.println("projectApplicationInfo 신청정보보기 = " + projectApplicationInfo);
        projectApplicationInfoRepository.save(projectApplicationInfo);

    }

    public ProjectDTO findProjectByProjectNo(int projectNo) {

        Project project = projectRepository.findById(projectNo).get();

        return modelMapper.map(project, ProjectDTO.class);
    }

}
