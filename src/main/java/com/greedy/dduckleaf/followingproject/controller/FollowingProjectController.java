package com.greedy.dduckleaf.followingproject.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.followingproject.dto.FollowingProjectDTO;
import com.greedy.dduckleaf.followingproject.dto.ProjectDTO;
import com.greedy.dduckleaf.followingproject.service.FollowingProjectService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

/**
 * <pre>
 * Class: FollowingProjectController
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 등록 관련 메소드 작성, 관심 프로젝트 취소 관련 메소드 작성
 * 2022/05/09 (박상범) 관심 프로젝트 목록 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.2
 * @author 박상범
 */
@Controller
@RequestMapping("/following")
public class FollowingProjectController {

    private final FollowingProjectService followingProjectService;

    public FollowingProjectController(FollowingProjectService followingProjectService) {
        this.followingProjectService = followingProjectService;
    }

    /**
     * registFollowingProject: 관심 프로젝트로 등록합니다.
     * @param projectNo:  프로젝트 번호
     * @param user:  로그인된 회원의 정보
     * @return gson.toJson(result): "관심 프로젝트로 등록되었습니다."를 리턴합니다.
     * @author 박상범
     */
    @PostMapping(value = {"/regist"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String registFollowingProject(@RequestBody int projectNo, @AuthenticationPrincipal CustomUser user) {

        String result = followingProjectService.registFollowingProject(projectNo, user.getMemberNo());

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        System.out.println(result);

        return gson.toJson(result);
    }

    /**
     * removeFollowingProject: 관심 프로젝트에서 제외합니다.
     * @param projectNo:  프로젝트 번호
     * @param user:  로그인된 회원의 정보
     * @return gson.toJson(result): "관심 프로젝트에서 제외되었습니다."를 리턴합니다.
     * @author 박상범
     */
    @PostMapping(value = {"/remove"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String removeFollowingProject(@RequestBody int projectNo, @AuthenticationPrincipal CustomUser user) {

        String result = followingProjectService.removeFollowingProject(projectNo, user.getMemberNo());

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        System.out.println(result);

        return gson.toJson(result);
    }

    /**
     * followingProjectList: 관심 프로젝트 목록을 조회합니다.
     * @param user:  로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping("/list")
    public ModelAndView followingProjectList(ModelAndView mv, @AuthenticationPrincipal CustomUser user) throws ParseException {

        List<ProjectDTO> followingProjectList = followingProjectService.findFollowingProjectList(user.getMemberNo());

        mv.addObject("followingProjectList", followingProjectList);
        mv.setViewName("/following/list");

        return mv;
    }
}
