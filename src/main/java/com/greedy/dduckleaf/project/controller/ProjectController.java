package com.greedy.dduckleaf.project.controller;

import com.greedy.dduckleaf.project.dto.ProjectDTO;
import com.greedy.dduckleaf.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class : ProjectController
 * Comment : 프로젝트
 * History
 * 2022-04-27 (차화응) 처음 작성 / 개별 프로젝트 상세조회 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 차화응
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
     * @return mv : 뷰로 전달할 데이터와 경로를 담는 객체
     *
     * @author 차화응
     */
    @GetMapping("/projectdetail/{projectNo}")
    public ModelAndView findProjectDetail(ModelAndView mv, @PathVariable int projectNo) {

//        projectNo = 2;
        ProjectDTO project = projectService.findProjectDetail(projectNo);

        System.out.println("컨트롤러" + project);
        System.out.println("컨트롤러" + project);
        System.out.println("컨트롤러" + project);
        System.out.println("컨트롤러" + project);
        System.out.println("컨트롤러" + project);

        if(project.getProgressStatus() == 2) {
            mv.addObject("project", project);
            mv.setViewName("project/scheduled/detail");
        } else if(project.getProgressStatus() == 3) {
            mv.addObject("project", project);
            mv.setViewName("project/progressing/detail");
        } else if(project.getProgressStatus() == 4) {
            mv.addObject("project", project);
            mv.setViewName("project/end/detail");
        }

        return mv;
    }
}
