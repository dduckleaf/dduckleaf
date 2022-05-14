package com.greedy.dduckleaf.project.find.controller;

import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.project.finalfield.CodeForProject;
import com.greedy.dduckleaf.project.find.dto.ProjectDTO;
import com.greedy.dduckleaf.project.find.dto.SearchDTO;
import com.greedy.dduckleaf.project.find.service.ProjectFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
public class ProjectFindController implements CodeForProject {

    private final ProjectFindService service;

    @Autowired
    public ProjectFindController(ProjectFindService service) {

        this.service = service;
    }

    /**
     * projectFind : 프로젝트 목록조회 정보를 조회 후 포워딩요청을 보냅니다.
     * @param pageable 목록조회 페이징정보가 담긴 Pageable 인스턴스를 전달받습니다.
     * @param request : 검색용 검색어와, 필터 조회용 리워드 카테고리와 프로젝트 상태를 전달받습니다.
     * @return projectList : 조회한 프로젝트의 목록을 반환합니다.
     * @return paging : 페이징 정보를 반환합니다.
     * @return searchValue : 검색어를 반환합니다.
     *
     * @author 홍성원
     */
    @GetMapping("/list")
    public ModelAndView projectFind(ModelAndView mv, @PageableDefault Pageable pageable, HttpServletRequest request) {

        /* request에서 프런트에서 전달한 검색어, 리워드 카테고리, 프로젝트 상태를 꺼내, 저장합니다.  */
        String searchValue = (String) request.getParameter("searchValue");
        String category = request.getParameter("rewardCategory");
        String status = request.getParameter("progressStatus");

        /* 리워드 카테고리, 프로젝트 상태는 Integer 자료형으로 받아 Null Pointer Exception 발생을 예방합니다. */
        Integer rewardCategory = category != null? Integer.valueOf(category) :0;
        Integer progressStatus = status != null? Integer.valueOf(status) :0;

        /* request에서 추출한 검색에 필요한 정보를 SearchDTO에 담아 서비스의 프로젝트 조회메소드에 전달인자로 넣어 호출합니다. */
        SearchDTO searchDTO = new SearchDTO(searchValue, rewardCategory, progressStatus);
        Page<ProjectDTO> projectList = service.findProjectLists(searchDTO, pageable);

        /* 한 페이지에 표시할 버튼의 개수를 설정합니다. */
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        /* 조회한 프로젝트목록과, 페이징 정보, 검색정보를 Model에 저장 후 반환합니다. */
        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.addObject("searchDTO", searchDTO);
        mv.addObject("intent", "list");
        mv.setViewName("/project/list/projectlist");

        return mv;
    }

    @GetMapping("/end")
    public ModelAndView sendEndProjectListPage(ModelAndView mv, @PageableDefault Pageable pageable) {

        /* 페이징 정보를 담아 프로젝트 목록을 조회합니다. */
        Page<ProjectDTO> projectList = service.findProjectListsByProgressingNo(PROJECT_PROGRESS_STATUS_종료, pageable);

        /* 한 페이지에 표시할 버튼의 개수를 설정합니다. */
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        /* 조회한 프로젝트목록과, 페이징 정보, 검색정보를 Model에 저장 후 반환합니다. */
        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.addObject("intent", "end");
        mv.setViewName("/project/list/endlist");

        return mv;
    }

    @GetMapping("/progressing")
    public ModelAndView sendProgressingProjectListPage(ModelAndView mv, @PageableDefault Pageable pageable, HttpServletRequest request) {

        /* 페이징 정보를 담아 프로젝트 목록을 조회합니다. */
        Page<ProjectDTO> projectList = service.findProjectListsByProgressingNo(PROJECT_PROGRESS_STATUS_진행중,pageable);

        /* 한 페이지에 표시할 버튼의 개수를 설정합니다. */
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        /* 조회한 프로젝트목록과, 페이징 정보, 검색정보를 Model에 저장 후 반환합니다. */
        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.addObject("intent", "progressing");
        mv.setViewName("/project/list/progressinglist");

        return mv;
    }

    @GetMapping("/expected")
    public ModelAndView sendExpectedProjectListPage(ModelAndView mv, @PageableDefault Pageable pageable, HttpServletRequest request) {

        /* 페이징 정보를 담아 프로젝트 목록을 조회합니다. */
        Page<ProjectDTO> projectList = service.findProjectListsByProgressingNo(PROJECT_PROGRESS_STATUS_오픈예정, pageable);

        /* 한 페이지에 표시할 버튼의 개수를 설정합니다. */
        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(projectList, BUTTON_AMOUNT);

        /* 조회한 프로젝트목록과, 페이징 정보, 검색정보를 Model에 저장 후 반환합니다. */
        mv.addObject("projectList", projectList);
        mv.addObject("paging", paging);
        mv.addObject("intent", "expected");
        mv.setViewName("/project/list/expectedlist");
        return mv;
    }
}