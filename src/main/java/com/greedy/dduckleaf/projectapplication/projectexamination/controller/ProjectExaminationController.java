package com.greedy.dduckleaf.projectapplication.projectexamination.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.projectapplication.dto.ProjectApplicationInfoDTO;
import com.greedy.dduckleaf.projectapplication.projectexamination.service.ProjectExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * Class: ProjectExaminationController
 * Comment : 프로젝트 심사
 * History
 * 2022/05/02 (박휘림) 처음 작성 /  findProjectApplicationInfoList 메소드 작성
 * </pre>
 * @version 1.0.0
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

    @GetMapping("/list")
    public ModelAndView findProjectApplicationInfoList(ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ProjectApplicationInfoDTO> projectApplicationInfoList = projectExaminationService.findProjectApplicationList(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectApplicationInfoList);

        mv.addObject("projectApplicationInfoList", projectApplicationInfoList);
        mv.addObject("paging", paging);
        mv.setViewName("project/manage/application/list");

        return mv;
    }



}
