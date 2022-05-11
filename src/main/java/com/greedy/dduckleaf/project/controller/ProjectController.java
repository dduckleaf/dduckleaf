package com.greedy.dduckleaf.project.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.project.dto.FundingInfoDTO;
import com.greedy.dduckleaf.project.dto.ProjectDTO;
import com.greedy.dduckleaf.project.dto.ProjectDetailDTO;
import com.greedy.dduckleaf.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Class : ProjectController
 * Comment : 프로젝트
 * History
 * 2022-04-27 (차화응) 처음 작성 / 개별 프로젝트 상세조회 메소드 작성
 * 2022-05-08 (박상범) 개별 프로젝트 상세 조회 메소드 수정
 * </pre>
 * @version 1.0.0
 * @author 차화응
 * @author 박상범
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * findProjectDetail : 개별 프로젝트 상세정보를 조회합니다.
     * @param mv : 요청 경로를 담는 객체
     * @param projectNo : 조회할 개별 프로젝트 번호
     * @param user : 로그인된 회원 정보
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 박상범, 박휘림, 차화응
     */
    @GetMapping("/projectdetail/{projectNo}")
    public ModelAndView findProjectDetail(ModelAndView mv, @PathVariable int projectNo, @AuthenticationPrincipal CustomUser user, @PageableDefault Pageable pageable) throws ParseException {

        ProjectDetailDTO projectDetail = projectService.findProjectDetail(projectNo, user, pageable);

        String endDate = projectDetail.getProject().getEndDate().replace("-","");
        String nowDate = java.sql.Date.valueOf(LocalDate.now()).toString().replace("-","");

        String format = "yyyyMMdd";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        Date end = simpleDateFormat.parse(endDate);
        Date now = simpleDateFormat.parse(nowDate);

        long diffSec = Math.abs(end.getTime() - now.getTime());
        long diffDay = TimeUnit.DAYS.convert(diffSec, TimeUnit.MILLISECONDS);

        mv.addObject("attachment", projectDetail.getAttachmentList());
        mv.addObject("projectInfo", projectDetail.getProjectApplicationInfo());
        mv.addObject("projectNotice", projectDetail.getProjectNotice());
        mv.addObject("project", projectDetail.getProject());
        mv.addObject("followingStatus", projectDetail.getFollowingStatus());

        if(projectDetail.getProject().getProgressStatus() == 2) {

            mv.setViewName("project/scheduled/detail");
        }

        if(projectDetail.getProject().getProgressStatus() == 3) {

            mv.addObject("supporter", projectDetail.getFundingInfoList());
            mv.addObject("day", diffDay);
            mv.setViewName("project/progressing/detail");
        }

        if(projectDetail.getProject().getProgressStatus() == 4) {
            mv.addObject("supporter", projectDetail.getFundingInfoList());
            mv.setViewName("project/end/detail");
        }

        return mv;
    }


}
