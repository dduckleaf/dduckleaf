package com.greedy.dduckleaf.project.find;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/list")
    public String projectFind() {

        return "/project/list/projectlist";
    }


}
