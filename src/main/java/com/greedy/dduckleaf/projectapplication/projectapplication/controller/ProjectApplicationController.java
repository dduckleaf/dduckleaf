package com.greedy.dduckleaf.projectapplication.projectapplication.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.projectapplication.dto.*;
import com.greedy.dduckleaf.projectapplication.projectapplication.service.ProjectApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <pre>
 * Class: ProjectApplicationController
 * Comment : 프로젝트 오픈 신청
 * History
 * 2022/04/25 (박휘림) 처음 작성 / registProjectApplication 메소드 작성 시작
 * 2022/04/27 (박휘림) projectApplicationMainPage, findProjectNoByFarmerNo, findBasicReqByProjectNo 메소드 작성
 * 2022/04/28 (박휘림) modifyBasicReq, modifyRewardAgreementStatus, findBasicInfoByProjectNo, modifyBasicInfo 메소드 작성
 * 2022/04/29 (박휘림) findStoryByProjectNo, modifyStory, modifyPromotionAgreementStatus, findRewardByProjectNo, modifyReward 메소드 작성
 * 2022/04/30 (박휘림) findPolicyByProjectNo, modifyPolicy, modifyPolicyAgreementStatus, findFarmerInfoByMemberNo, modifyFarmerInfo 메소드 작성
 * 2022/05/01 (박휘림) sendPhoneVerification 메소드 작성
 * 2022/05/02 (박휘림) registProjectApplicationInfo 메소드 작성
 * 2022/05/05 (박휘림) modifyRepresentative 메소드 작성
 * 2022/05/09 (박휘림) moveToWaitingProject 메소드 작성
 * 2022/05/10 (박휘림) cancelProjectApplicaion 메소드 작성
 * </pre>
 * @version 1.0.9
 * @author 박휘림
 */
@Controller
@RequestMapping("/project/application")
public class ProjectApplicationController {

    @Value("${file.path}")
    private String uploadPath;

    private final ProjectApplicationService projectApplicationService;

    @Autowired
    public ProjectApplicationController(ProjectApplicationService projectApplicationService) {

        this.projectApplicationService = projectApplicationService;
    }

    /**
     * registProjectApplication: 프로젝트 신청 버튼 클릭 시 기본데이터를 인서트합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "project/regist/main" 프로젝트 신청 메인페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/regist")
    public ModelAndView registProjectApplication(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        projectApplicationService.registProjectApplication(farmerNo);

        mv.setViewName("project/regist/main");

        return mv;
    }

    /**
     * projectApplicationMainPage: 프로젝트 신청 페이지로 이동합니다.
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "project/regist/main" 프로젝트 신청 메인페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/goMain")
    public ModelAndView projectApplicationMainPage(ModelAndView mv) {

        mv.setViewName("project/regist/main");

        return mv;
    }

    /**
     * findProjectNoByFarmerNo: 회원번호로 프로젝트 번호를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return projectNo 프로젝트 번호
     * @author 박휘림
     */
    public int findProjectNoByFarmerNo(@AuthenticationPrincipal CustomUser user) {

        int farmerNo = user.getMemberNo();

        int projectNo = projectApplicationService.findProjectNoByFarmerId(farmerNo);

        return projectNo;
    }

    /**
     * findBasicReqByProjectNo: 기본 요건 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            basicReq 기본 요건 기본 데이터
     *            "project/regist/basicreq" 기본 요건을 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicreq")
    public ModelAndView findBasicReqByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RewardRegistInfoDTO basicReq = projectApplicationService.findRewardRegistInfoByProjectNo(projectNo);

        mv.addObject("basicReq", basicReq);
        mv.setViewName("project/regist/basicreq");

        return mv;
    }

    /**
     * modifyBasicReq: 기본 요건 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/basicreq")
    public ModelAndView modifyBasicReq(ModelAndView mv, RewardRegistInfoDTO basicreq, @RequestParam(value = "file", required = false) MultipartFile file,
                                       @AuthenticationPrincipal CustomUser user) {

        if(file != null) {

            int projectNo = findProjectNoByFarmerNo(user);

            ProjectAttachmentDTO attachment = new ProjectAttachmentDTO();

            ProjectDTO project = new ProjectDTO();
            project.setProjectNo(projectNo);

            attachment.setProject(project);

            String rootLocation = uploadPath;

            String fileUploadPath = rootLocation + "/upload/original";

            File uploadDirectory = new File(fileUploadPath);

            if(!file.isEmpty()) {

                if(!uploadDirectory.exists()) {

                    System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                }

                try {

                    if(file.getSize() > 0) {

                        String orgName = file.getOriginalFilename();
                        String ext = orgName.substring(orgName.lastIndexOf("."));
                        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                        file.transferTo(new File(uploadDirectory + "/" + savedName));

                        attachment.setProjectAttachmentOriginalName(orgName);
                        attachment.setProjectAttachmentSaveName(savedName);
                        attachment.setProjectAttachmentSavePath(fileUploadPath);
                        attachment.setFarmerNo(user.getMemberNo());

                    }

                    attachment.setFarmerNo(user.getMemberNo());

                    projectApplicationService.modifyBasicReqAttachment(attachment);

                    projectApplicationService.modifyBasicReq(basicreq);

                    mv.setViewName("redirect:/project/application/goMain");


                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();

                    File deleteFile = new File(uploadDirectory + "/" + attachment.getProjectAttachmentSaveName());
                    boolean isDeleted1 = deleteFile.delete();

                    if(isDeleted1) {

                        e.printStackTrace();
                    } else {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            projectApplicationService.modifyBasicReq(basicreq);

            mv.setViewName("redirect:/project/application/goMain");
        }

        return mv;
    }

    /**
     * modifyRewardAgreementStatus: 사용자가 리워드 관련 서류 제출에 동의 시 동의 여부와 날짜를 업데이트합니다.
     * @param basicreq: 사용자가 입력한 기본 요건 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/basicreq" 기본 요건 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/rewardagreement")
    public ModelAndView modifyRewardAgreementStatus(ModelAndView mv, RewardRegistInfoDTO basicreq) {

        projectApplicationService.modifyRewardAgreementStatus(basicreq);

        mv.setViewName("redirect:/project/application/basicreq");

        return mv;
    }

    /**
     * findBasicInfoByProjectNo: 기본 정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            basicInfo 기본 정보 기본 데이터
     *            "project/regist/basicinfo" 기본 정보를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicinfo")
    public ModelAndView findBasicInfoByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        ProjectBasicInfoDTO basicInfo = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);
        ProjectDTO project = projectApplicationService.findProjectByProjectNo(projectNo);

        List<ProjectRewardCategoryDTO> categoryList = projectApplicationService.findAllRewardCategory();

        mv.addObject("project", project);
        mv.addObject("categoryList", categoryList);
        mv.addObject("basicInfo", basicInfo);
        mv.setViewName("project/regist/basicinfo");

        return mv;
    }

    /**
     * modifyBasicInfo: 기본 정보 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param file: 사용자가 업로드한 파일 객체
     * @param basicInfo: 사용자가 입력한 기본 정보 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/basicinfo")
    public ModelAndView modifyBasicInfo(@RequestParam(value = "file", required = false) MultipartFile file, ModelAndView mv,
                                        ProjectBasicInfoDTO basicInfo, ProjectDTO project, @AuthenticationPrincipal CustomUser user) {

        if(file != null) {

            int projectNo = findProjectNoByFarmerNo(user);

            ProjectAttachmentDTO attachment = new ProjectAttachmentDTO();

            project.setProjectNo(projectNo);

            attachment.setProject(project);

            String rootLocation = uploadPath;

            String fileUploadPath = rootLocation + "/upload/original";

            File uploadDirectory = new File(fileUploadPath);

            if(!file.isEmpty()) {

                if(!uploadDirectory.exists()) {

                    System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                }

                try {

                    if(file.getSize() > 0) {

                        String orgName = file.getOriginalFilename();
                        String ext = orgName.substring(orgName.lastIndexOf("."));
                        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                        file.transferTo(new File(uploadDirectory + "/" + savedName));

                        attachment.setProjectAttachmentOriginalName(orgName);
                        attachment.setProjectAttachmentSaveName(savedName);
                        attachment.setProjectAttachmentSavePath(fileUploadPath);
                        attachment.setFarmerNo(user.getMemberNo());

                    }

                    attachment.setFarmerNo(user.getMemberNo());

                    projectApplicationService.modifyBasicInfoAttachment(attachment);

                    projectApplicationService.modifyBasicInfo(basicInfo, project);

                    mv.setViewName("redirect:/project/application/goMain");

                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();

                    File deleteFile = new File(uploadDirectory + "/" + attachment.getProjectAttachmentSaveName());
                    boolean isDeleted1 = deleteFile.delete();

                    if(isDeleted1) {

                        e.printStackTrace();
                    } else {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            projectApplicationService.modifyBasicInfo(basicInfo, project);

            mv.setViewName("redirect:/project/application/goMain");
        }

        return mv;
    }

    /**
     * findStoryByProjectNo: 스토리 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            story 스토리 기본 데이터
     *            "project/regist/story" 스토리를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/story")
    public ModelAndView findStoryByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        ProjectBasicInfoDTO story = projectApplicationService.findProjectBasicInfoByProjectNo(projectNo);

        mv.addObject("story", story);
        mv.setViewName("project/regist/story");

        return mv;
    }

    /**
     * modifyStory: 스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param story: 사용자가 입력한 스토리 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/story")
    public ModelAndView modifyStory(@RequestParam(value = "file", required = false) MultipartFile file, ModelAndView mv,
                                    ProjectBasicInfoDTO story, @AuthenticationPrincipal CustomUser user) {

        if(file != null) {

            int projectNo = findProjectNoByFarmerNo(user);

            ProjectAttachmentDTO attachment = new ProjectAttachmentDTO();

            ProjectDTO project = new ProjectDTO();
            project.setProjectNo(projectNo);

            attachment.setProject(project);

            String rootLocation = uploadPath;

            String fileUploadPath = rootLocation + "/upload/original";

            File uploadDirectory = new File(fileUploadPath);

            if(!file.isEmpty()) {

                if(!uploadDirectory.exists()) {

                    System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                }

                try {

                    if(file.getSize() > 0) {

                        String orgName = file.getOriginalFilename();
                        String ext = orgName.substring(orgName.lastIndexOf("."));
                        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                        file.transferTo(new File(uploadDirectory + "/" + savedName));

                        attachment.setProjectAttachmentOriginalName(orgName);
                        attachment.setProjectAttachmentSaveName(savedName);
                        attachment.setProjectAttachmentSavePath(fileUploadPath);
                        attachment.setFarmerNo(user.getMemberNo());

                    }

                    attachment.setFarmerNo(user.getMemberNo());

                    projectApplicationService.modifyStoryAttachment(attachment);

                    projectApplicationService.modifyStory(story);

                    mv.setViewName("redirect:/project/application/goMain");


                }catch (IllegalStateException | IOException e) {
                    e.printStackTrace();

                    File deleteFile = new File(uploadDirectory + "/" + attachment.getProjectAttachmentSaveName());
                    boolean isDeleted1 = deleteFile.delete();

                    if(isDeleted1) {

                        e.printStackTrace();
                    } else {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            projectApplicationService.modifyStory(story);

            mv.setViewName("redirect:/project/application/goMain");
        }

        return mv;

    }

    /**
     * modifyPromotionAgreementStatus: 스토리 페이지에서 사용자가 홍보 심의 동의 시 동의 상태를 변경합니다.
     * @param story: 사용자가 입력한 스토리 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/story" 프로젝트 신청 스토리 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/promotionagreement")
    public ModelAndView modifyPromotionAgreementStatus(ModelAndView mv, ProjectBasicInfoDTO story) {

        projectApplicationService.modifyPromotionAgreementStatus(story);

        mv.setViewName("redirect:/project/application/story");

        return mv;
    }

    /**
     * findRewardByProjectNo: 리워드 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            reward 리워드 정보 기본 데이터
     *            shippingInfo 배송 정보 기본 데이터
     *            "project/regist/reward" 리워드를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/reward")
    public ModelAndView findRewardByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RewardRegistInfoDTO reward = projectApplicationService.findRewardByProjectNo(projectNo);
        ProjectShippingInfoDTO shippingInfo = projectApplicationService.findShippingInfoByProjectNo(projectNo);

        mv.addObject("reward", reward);
        mv.addObject("shippingInfo", shippingInfo);
        mv.setViewName("project/regist/reward");

        return mv;
    }

    /**
     * modifyReward: 스토리 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param reward: 사용자가 입력한 리워드 데이터를 담은 객체
     * @param shippingInfo: 사용자가 입력한 배송 관련 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/reward")
    public ModelAndView modifyReward(ModelAndView mv, RewardRegistInfoDTO reward, ProjectShippingInfoDTO shippingInfo) {

        projectApplicationService.modifyReward(reward, shippingInfo);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * findPolicyByProjectNo: 반환정책 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            policy 정책 기본 데이터
     *            "project/regist/policy" 반환정책을 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/policy")
    public ModelAndView findPolicyByProjectNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int projectNo = findProjectNoByFarmerNo(user);

        RefundPolicyDTO policy = projectApplicationService.findPolicyByProjectNo(projectNo);

        mv.addObject("policy", policy);
        mv.setViewName("project/regist/policy");

        return mv;
    }

    /**
     * modifyPolicy: 반환정책 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param policy: 사용자가 입력한 반환정책 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/policy")
    public ModelAndView modifyPolicy(ModelAndView mv, RefundPolicyDTO policy) {

        projectApplicationService.modifyPolicy(policy);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * modifyPolicyAgreementStatus: 반환정책 페이지에서 사용자가 펀딩금 반환 정책 정보 동의 시 동의 상태를 변경합니다.
     * @param policy: 사용자가 입력한 반환정책 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/policy" 프로젝트 신청 반환정책 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/policyagreement")
    public ModelAndView modifyPolicyAgreementStatus(ModelAndView mv, RefundPolicyDTO policy) {

        projectApplicationService.modifyPolicyAgreementStatus(policy);

        mv.setViewName("redirect:/project/application/policy");

        return mv;
    }

    /**
     * findFarmerInfoByMemberNo: 파머정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            farmerInfo 파머 정보 기본 데이터
     *            homePage 파머 홈페이지 기본 데이터
     *            "project/regist/farmerinfo" 파머정보를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/farmer")
    public ModelAndView findFarmerInfoByMemberNo(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        FarmerInfoDTO farmerInfo = projectApplicationService.findFarmerInfoByMemberNo(memberNo);

        mv.addObject("farmerInfo", farmerInfo);
        mv.setViewName("project/regist/farmerinfo");

        return mv;
    }

    /**
     * modifyFarmerInfo: 파머정보 작성 페이지에서 사용자가 입력한 값으로 기본데이터를 수정합니다.
     * @param farmerInfo: 사용자가 입력한 파머정보 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/goMain" 프로젝트 신청 메인페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/farmer")
    public ModelAndView modifyFarmerInfo(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
                                         ModelAndView mv, FarmerInfoDTO farmerInfo, @AuthenticationPrincipal CustomUser user) {

        if(file != null) {

            int projectNo = findProjectNoByFarmerNo(user);

            ProjectAttachmentDTO attachment = new ProjectAttachmentDTO();

            ProjectDTO project = new ProjectDTO();
            project.setProjectNo(projectNo);

            attachment.setProject(project);

            String rootLocation = uploadPath;

            String fileUploadPath = rootLocation + "/upload/original";

            File uploadDirectory = new File(fileUploadPath);

            if(!file.isEmpty()) {

                if(!uploadDirectory.exists()) {

                    System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                }

                try {

                    if(file.getSize() > 0) {

                        String orgName = file.getOriginalFilename();
                        String ext = orgName.substring(orgName.lastIndexOf("."));
                        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                        file.transferTo(new File(uploadDirectory + "/" + savedName));

                        attachment.setProjectAttachmentOriginalName(orgName);
                        attachment.setProjectAttachmentSaveName(savedName);
                        attachment.setProjectAttachmentSavePath(fileUploadPath);
                        attachment.setFarmerNo(user.getMemberNo());

                    }

                    attachment.setFarmerNo(user.getMemberNo());

                    projectApplicationService.modifyFarmerInfoAttachment(attachment);

                    projectApplicationService.modifyFarmerInfo(farmerInfo);

                    mv.setViewName("redirect:/project/application/goMain");

                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();

                    File deleteFile = new File(uploadDirectory + "/" + attachment.getProjectAttachmentSaveName());
                    boolean isDeleted1 = deleteFile.delete();

                    if(isDeleted1) {

                        e.printStackTrace();
                    } else {
                        e.printStackTrace();
                    }
                }
            }

        } else {

            projectApplicationService.modifyFarmerInfo(farmerInfo);

            mv.setViewName("redirect:/project/application/goMain");
        }

        return mv;
    }

    /**
     * findRepresentative: 대표자 및 정산정보 작성 페이지로 이동 시 기본 데이터를 조회합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            farmer 파머 정보 기본 데이터
     *            financialInfo 대표자 정보 기본 데이터
     *            "project/regist/representative" 대표자정보를 작성하는 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/representative")
    public ModelAndView findRepresentative(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        FarmerInfoDTO farmer = projectApplicationService.findFarmerInfoByMemberNo(memberNo);
        FarmerFinancialInfoDTO financialInfo = projectApplicationService.findFarmerFinancialInfoByMemberNo(memberNo);
        List<BankDTO> bankList = projectApplicationService.findAllBank();

        mv.addObject("bankList", bankList);
        mv.addObject("farmer", farmer);
        mv.addObject("financialInfo", financialInfo);
        mv.setViewName("project/regist/representative");

        return mv;
    }

    /**
     * modifySettlementPolicyCheckStatus: 대표자 정보 페이지에서 사용자가 정산정책 정보 확인 시 확인 상태를 변경합니다.
     * @param financialInfo: 사용자가 입력한 정산정책 데이터를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/application/policy" 프로젝트 신청 대표자 및 정산 정보 작성 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/settlementcheck")
    public ModelAndView modifySettlementPolicyCheckStatus(ModelAndView mv, FarmerFinancialInfoDTO financialInfo) {

        projectApplicationService.modifySettlementPolicyCheckStatus(financialInfo);

        mv.setViewName("redirect:/project/application/representative");

        return mv;
    }

    /**
     * sendPhoneVerification: 회원 가입을 위해 휴대폰 번호로 인증번호를 전송합니다.
     * @param phone: 휴대폰 인증 번호를 전송할 휴대폰 번호
     * @return gson.toJson(phoneResult)
     * @author 박휘림
     */
    @GetMapping(value = "/sendPhoneVerification", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String sendPhoneVerification(String phone){

        String phoneResult = projectApplicationService.sendPhoneVerification(phone);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(phoneResult);
    }

    /**
     * registProjectApplicationInfo: 프로젝트 심사를 신청합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "/main/mainPage" 메인 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/examination")
    public ModelAndView registProjectApplicationInfo(ModelAndView mv, @AuthenticationPrincipal CustomUser user, RedirectAttributes rttr) {

        int projectNo = findProjectNoByFarmerNo(user);
        int memberNo = user.getMemberNo();

        projectApplicationService.registProjectApplicationInfo(projectNo, memberNo);

        mv.setViewName("/main/mainPage");

        return mv;
    }

    /**
     * modifyRepresentative: 대표자 및 정산 정보 페이지에서 사용자가 입력한 값으로 기본 데이터를 수정합니다.
     * @param user: 로그인한 사용자의 정보를 받는 객체
     * @param farmer: 파머 정보를 담은 객체
     * @param financialInfo: 파머 금융 정보를 담은 객체
     * @param farmerfinancial1: 이미지 파일 정보
     * @param farmerfinancial2: 이미지 파일 정보
     * @param farmerfinancial3: 이미지 파일 정보
     * @param farmerfinancial4: 이미지 파일 정보
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "/project/application/goMain" 프로젝트 신청 메인 페이지 경로
     * @author 박휘림
     */
    @PostMapping("/modify/representative")
    public ModelAndView modifyRepresentative(ModelAndView mv, FarmerInfoDTO farmer, FarmerFinancialInfoDTO financialInfo, @AuthenticationPrincipal CustomUser user,
                                              @RequestParam("farmerfinancial1") MultipartFile farmerfinancial1,
                                              @RequestParam("farmerfinancial2") MultipartFile farmerfinancial2,
                                              @RequestParam("farmerfinancial3") MultipartFile farmerfinancial3,
                                              @RequestParam("farmerfinancial4") MultipartFile farmerfinancial4 ) {

        String rootLocation = uploadPath;

        String fileUploadPath = rootLocation + "/upload/original";

        File uploadDirectory = new File(fileUploadPath);

        if(!uploadDirectory.exists()) {

            System.out.println("폴더 생성 : " + uploadDirectory.mkdirs());
        }

        /* 업르도 파일 하나하나에 대한 정보를 담을 리스트 */
        List<Map<String, String>> fileInfoList = new ArrayList<>();

        List<MultipartFile> fileList = new ArrayList<>();
        fileList.add(farmerfinancial1);
        fileList.add(farmerfinancial2);
        fileList.add(farmerfinancial3);
        fileList.add(farmerfinancial4);

        try {

            for(MultipartFile file : fileList) {

                if (file.getSize() > 0) {

                    String orgName = file.getOriginalFilename();
                    String ext = orgName.substring(orgName.lastIndexOf("."));
                    String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                    file.transferTo(new File(uploadDirectory + "/" + savedName));

                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("orgName", orgName);
                    fileMap.put("savedName", savedName);
                    fileMap.put("savePath", fileUploadPath);

                    fileInfoList.add(fileMap);

                }
            }

            List<ProjectAttachmentDTO> attachmentList = new ArrayList<>();

                for(int i = 0; i < fileInfoList.size(); i++) {

                    int projectNo = findProjectNoByFarmerNo(user);

                    Map<String, String> files = fileInfoList.get(i);

                    ProjectAttachmentDTO attachment = new ProjectAttachmentDTO();
                    attachment.setProjectAttachmentOriginalName(files.get("orgName"));
                    attachment.setProjectAttachmentSaveName(files.get("savedName"));
                    attachment.setProjectAttachmentSavePath(files.get("savePath"));

                    ProjectDTO project = new ProjectDTO();
                    project.setProjectNo(projectNo);

                    attachment.setProject(project);
                    attachment.setFarmerNo(user.getMemberNo());
                    attachment.setProjectAttachmentCategory("금융정보");

                    attachmentList.add(attachment);

                }
            projectApplicationService.modifyFarmerFinancialInfoAttachment(attachmentList);

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        projectApplicationService.modifyRepresentative(farmer, financialInfo);

        mv.setViewName("redirect:/project/application/goMain");

        return mv;
    }

    /**
     * moveToWaitingProject: 파머페이지에서 심사 대기중인 신청 프로젝트 페이지로 이동합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "/project/cancel/detail" 심사 대기중인 프로젝트 경로
     * @author 박휘림
     */
    @GetMapping("/waiting/{projectNo}")
    public ModelAndView moveToWaitingProject(ModelAndView mv, @PathVariable int projectNo) {

        ProjectDTO project = projectApplicationService.findProjectByProjectNo(projectNo);

        mv.addObject("project", project);
        mv.setViewName("/project/cancel/detail");

        return mv;
    }

    /**
     * cancelProjectApplicaion: 파머페이지에서 심사 대기중인 신청 프로젝트를 취소하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/common/farmerpage" 파머탭 경로
     * @author 박휘림
     */
    @GetMapping("/cancel/{projectNo}")
    public ModelAndView cancelProjectApplicaion(@PathVariable int projectNo, ModelAndView mv) {

        projectApplicationService.cancelProjectApplication(projectNo);

        mv.setViewName("redirect:/common/farmerpage");

        return mv;
    }



}