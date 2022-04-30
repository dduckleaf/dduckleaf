package com.greedy.dduckleaf.profile.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import com.greedy.dduckleaf.profile.service.ProfileService;
import com.greedy.dduckleaf.projectnotice.dto.ProfileDTO;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * <pre>
 * Class: ProfileController
 * Comment : 프로필
 * History
 * 2022/04/29 (박상범) 처음 작성 / 개인 정보 수정 페이지로 이동, 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.0
 * @author 박상범
 */
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * modifyProfile: 회원 번호를 통해 프로필 사진, 이메일 변경을 할 수 있는 페이지로 포워딩합니다.
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping("/modify")
    public ModelAndView modifyProfile(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();

        ProfileDTO profile = profileService.findProfileByMemberNo(memberNo);

        mv.addObject("profile", profile);
        mv.setViewName("/profile/modify/email");

        return mv;
    }
}
