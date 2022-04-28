package com.greedy.dduckleaf.project.find.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.dto.SearchDTO;
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

import javax.servlet.http.HttpServletRequest;
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
    private final static int BUTTON_AMOUNT = 7;
    private final ProjectFindService service;

    @Autowired
    public ProjectFindController(ProjectFindService service) {

        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView projectFind(ModelAndView mv, @PageableDefault Pageable pageable, HttpServletRequest request) {

        String searchValue = (String) request.getParameter("searchValue");
        String category = request.getParameter("rewardCategory");
        System.out.println("category = " + category);
        String status = request.getParameter("progressStatus");
        System.out.println("status = " + status);
        Integer rewardCategory = category != null? Integer.valueOf(category) :0;
        Integer progressStatus = status != null? Integer.valueOf(status) :0;

        SearchDTO searchDTO = new SearchDTO(searchValue, rewardCategory, progressStatus);
        System.out.println("searchDTO = " + searchDTO);System.out.println("searchDTO = " + searchDTO);System.out.println("searchDTO = " + searchDTO);

        Page<ProjectDTO> projectList = service.findProjectLists(searchDTO, pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.addObject("searchValue", searchValue);
        mv.setViewName("/project/list/projectlist");

        return mv;
    }
    @GetMapping("/filter")
    public String sendFilter() {

        return "/common/filter";
    }
}