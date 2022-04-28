package com.greedy.dduckleaf.project.find.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.service.ProjectFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : ProjectController
 * Comment : 프로젝트 조회 컨트롤러
 *
 * History
 * 2022-04-27 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Controller
@RequestMapping("/project/find")
public class ProjectFindController {

    private final ProjectFindService service;

    @Autowired
    public ProjectFindController(ProjectFindService service) {

        this.service = service;
    }


    @GetMapping("/list")
    public ModelAndView projectFind(ModelAndView mv, @PageableDefault Pageable pageable) {


        int buttonAmount = 7;
        Page<ProjectDTO> projectList = service.findProjectLists(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, buttonAmount);

        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.setViewName("/project/list/projectlist");

        return mv;
    }
}