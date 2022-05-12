package com.greedy.dduckleaf.projectapplication.projectexamination.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectapplication.dto.FarmerFinancialInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectAttachmentDTO;
import com.greedy.dduckleaf.projectapplication.dto.ProjectExamineHistoryDTO;
import com.greedy.dduckleaf.projectapplication.projectexamination.service.ProjectExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class: ProjectExaminationController
 * Comment : 프로젝트 심사
 * History
 * 2022/05/02 (박휘림) 처음 작성 /  findProjectApplicationInfoList 메소드 작성
 * 2022/05/03 findProjectApplicationInfoDetail, modifyProjectProgressStatus 메소드 작성
 * 2022/05/04 modifyProjectProgressStatus, findBasicReq, findBasicInfo, findStory, findReward, findPolicy, findFarmer, findRepresentative 메소드 작성
 * 2022/05/10 approveProject, rejectProject 메소드 작성
 * 2022/05/11 findProjectApplicationReason 메소드 작성
 * </pre>
 * @version 1.0.4
 * @author 박휘림
 */
@Controller
@RequestMapping("/project/examination")
public class ProjectExaminationController {

    private final ProjectExaminationService projectExaminationService;

    @Autowired
    public ProjectExaminationController(ProjectExaminationService projectExaminationService) {
        this.projectExaminationService = projectExaminationService;
    }

    /**
     * findProjectApplicationInfoList: 프로젝트 신청 내역을 조회합니다.
     * @param pageable: 페이징 정보를 담은 객체
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            projectApplicationInfoList 프로젝트 신청 내역
     *            paging 페이징 정보
     *            "project/manage/application/list" 프로젝트 신청 내역 목록 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/list")
    public ModelAndView findProjectApplicationInfoList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectApplicationInfoDTO> projectApplicationInfoList = projectExaminationService.findProjectApplicationList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectApplicationInfoList);

        mv.addObject("projectApplicationInfoList", projectApplicationInfoList);
        mv.addObject("paging", paging);
        mv.setViewName("project/manage/application/list");

        return mv;
    }

    /**
     * findProjectApplicationInfoReview: 프로젝트 신청 내역 상세조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 내역 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            infoDetail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/review" 프로젝트 심사페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/review/{projectApplicationNo}")
    public ModelAndView findProjectApplicationInfoReview(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);
        ProjectAttachmentDTO attachment = projectExaminationService.findBasicInfoAttachmentByProjectNo(detail.getProject().getProjectNo());

        ProjectExamineHistoryDTO history = new ProjectExamineHistoryDTO();

        mv.addObject("attachment", attachment);
        mv.addObject("history", history);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/review");

        return mv;
    }

    /**
     * findProjectApplicationInfoDetail: 프로젝트 신청 내역 상세조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 내역 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            infoDetail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/detail" 프로젝트 신청 내역 상세 페이지
     * @author 박휘림
     */
    @GetMapping("/detail/{projectApplicationNo}")
    public ModelAndView findProjectApplicationInfoDetail(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/detail");

        return mv;
    }

    /**
     * modifyProjectProgressStatus: 프로젝트 상태를 심사중으로 변경합니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            infoDetail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/review" 프로젝트 심사페이지 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/modify/{projectNo}")
    public ModelAndView modifyProjectProgressStatus(ModelAndView mv, @PathVariable int projectNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.modifyProjectProgressStatus(projectNo);

        ProjectAttachmentDTO attachment = projectExaminationService.findBasicInfoAttachmentByProjectNo(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachment);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/review");

        return mv;
    }

    /**
     * findBasicReq: 심사 신청된 프로젝트의 기본 요건을 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/basicreq" 프로젝트 기본요건 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicreq/{projectApplicationNo}")
    public ModelAndView findBasicReq(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        ProjectAttachmentDTO attachment = projectExaminationService.findIntroAttachmentByProjectNo(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachment);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/basicreq");

        return mv;
    }

    /**
     * findBasicInfo: 심사 신청된 프로젝트의 기본 정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            attachment 첨부 파일 정보
     *            "project/manage/application/basininfo" 프로젝트 기본정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/basicinfo/{projectApplicationNo}")
    public ModelAndView findBasicInfo(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        ProjectAttachmentDTO attachment = projectExaminationService.findBasicInfoAttachmentByProjectNo(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachment);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/basicinfo");

        return mv;
    }

    /**
     * findStory: 심사 신청된 프로젝트의 스토리 정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            attachment 첨부파일 정보
     *            "project/manage/application/story" 프로젝트 스토리정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/story/{projectApplicationNo}")
    public ModelAndView findStory(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        ProjectAttachmentDTO attachment = projectExaminationService.findStoryAttachmentByProjectNo(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachment);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/story");

        return mv;
    }

    /**
     * findReward: 심사 신청된 프로젝트의 리워드정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/reward" 프로젝트 리워드정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/reward/{projectApplicationNo}")
    public ModelAndView findReward(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/reward");

        return mv;
    }

    /**
     * findPolicy: 심사 신청된 프로젝트의 정책 정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            "project/manage/application/policy" 프로젝트 정책정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/policy/{projectApplicationNo}")
    public ModelAndView findPolicy(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/policy");

        return mv;
    }

    /**
     * findFarmer: 심사 신청된 프로젝트의 파머 정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            attachment 첨부파일 정보
     *            "project/manage/application/farmer" 프로젝트 파머정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/farmer/{projectApplicationNo}")
    public ModelAndView findFarmer(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        ProjectAttachmentDTO attachment = projectExaminationService.findFarmerInfoAttachment(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachment);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/farmerinfo");

        return mv;
    }

    /**
     * findRepresentative: 심사 신청된 프로젝트의 대표자 정보를 조회합니다.
     * @param projectApplicationNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            detail 프로젝트 신청 내역 상세 조회 정보
     *            farmer 파머 금융 정보
     *            "project/manage/application/representative" 프로젝트 대표정보 조회 뷰 경로
     * @author 박휘림
     */
    @GetMapping("/representative/{projectApplicationNo}")
    public ModelAndView findRepresentative(ModelAndView mv, @PathVariable int projectApplicationNo) {

        ProjectApplicationInfoDTO detail = projectExaminationService.findProjectApplicationDetail(projectApplicationNo);

        FarmerFinancialInfoDTO farmer = projectExaminationService.findFarmerFinancialInfo(detail.getFarmer().getMemberNo());

        List<ProjectAttachmentDTO> attachmentList = projectExaminationService.findFarmerFinancialInfoAttachment(detail.getProject().getProjectNo());

        mv.addObject("attachment", attachmentList);
        mv.addObject("farmer", farmer);
        mv.addObject("detail", detail);
        mv.setViewName("project/manage/application/representative");

        return mv;
    }

    /**
     * approveProject: 프로젝트 오픈을 승인합니다.
     * @param projectApplicaionNo: 프로젝트 신청 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/examination/list" 신청 내역 목록으로 이동
     * @author 박휘림
     */
    @GetMapping("/approval/{projectApplicaionNo}")
    public ModelAndView approveProject(ModelAndView mv, @PathVariable int projectApplicaionNo, @AuthenticationPrincipal CustomUser user) {

        int adminNo = user.getMemberNo();

        projectExaminationService.approveProject(projectApplicaionNo, adminNo);

        mv.setViewName("redirect:/project/examination/list");

        return mv;
    }

    /**
     * rejectProject: 프로젝트 오픈을 반려합니다.
     * @param projectApplicaion: 프로젝트 신청 내역 정보를 담은 DTO
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "redirect:/project/examination/list" 신청 내역 목록으로 이동
     * @author 박휘림
     */
    @PostMapping("/reject")
    public ModelAndView rejectProject(ModelAndView mv, ProjectApplicationInfoDTO projectApplicaion, ProjectExamineHistoryDTO history, @AuthenticationPrincipal CustomUser user) {

        int adminNo = user.getMemberNo();

        projectExaminationService.rejectProject(projectApplicaion.getProjectApplicationNo(), adminNo, history);

        mv.setViewName("redirect:/project/examination/list");

        return mv;
    }

    /**
     * rejectApplicationReason: 반려된 프로젝트의 반려사유를 조회하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return mv 뷰로 전달할 데이터와 경로를 담는 객체
     *            "/project/reject/detail" 파머탭 반려사유 조회 페이지 경로
     * @author 박휘림
     */
    @GetMapping("/rejectreason/{projectNo}")
    public ModelAndView findProjectApplicationReason(ModelAndView mv, @PathVariable int projectNo) {

        ProjectExamineHistoryDTO examineHistory = projectExaminationService.findProjectExamineHisory(projectNo);

        mv.addObject("examinehistory", examineHistory);
        mv.setViewName("/project/reject/detail");
        return mv;
    }
}
