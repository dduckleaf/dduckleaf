package com.greedy.dduckleaf.profile.controller;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.profile.entity.ProfileAttachment;
import com.greedy.dduckleaf.profile.service.ProfileService;
import com.greedy.dduckleaf.projectnotice.dto.ProfileDTO;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


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
 * 2022/04/30 (박상범) 회원의 사진 정보 변경 관련 메소드 작성
 * 2022/05/01 (박상범) 개인 정보 수정 페이지로 이동, 조회 관련 메소드 수정, 회원의 사진 정보 변경 관련 메소드 수정
 * </pre>
 * @version 1.0.4
 * @author 박상범
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Value("${file.path}")
    private String uploadPath;

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * modifyProfile: 회원 번호를 통해 프로필 사진 정보를 포워딩합니다.
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
//    @GetMapping( "/thumbnail")
//    public ModelAndView modifyProfile(ModelAndView mv, @AuthenticationPrincipal CustomUser user) {
//
//        int memberNo = user.getMemberNo();
//
//        ProfileDTO profile = profileService.findProfileByMemberNo(memberNo);
//
//        mv.addObject("profileAttachment", profile.getProfileAttachment());
////        mv.addObject("member", profile.getMember());
//
////        System.out.println(request.getRequestURI());
//
//        mv.setViewName("/profile/thumbnail");
////        if("email".equals(path)){
////        }
////        if("phone".equals(path)){
////            mv.setViewName("profile/modify/phone");
////        }
////        if("pwd".equals(path)){
////            mv.setViewName("profile/modify/pwd");
////        }
//        return mv;
//    }

    /**
     * uploadImg: 회원의 프로필 사진을 변경합니다.
     * @param file: 변경할 프로필 사진 정보
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal CustomUser user) {

        ProfileAttachmentDTO attachment = new ProfileAttachmentDTO();
        String result = "";

        String rootLocation = uploadPath;

        System.out.println(rootLocation);

        String fileUploadPath = rootLocation + "/upload/original";
        String thumbnailPath = rootLocation + "/upload/thumbnail";

        File uploadDirectory = new File(fileUploadPath);
        File thumbnailDirectory = new File(thumbnailPath);

        if(!file.isEmpty()) {

            if(!uploadDirectory.exists() || !thumbnailDirectory.exists()) {

                System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                System.out.println("섬네일 디렉토리 생성 : " + thumbnailDirectory.mkdirs());
            }

            try {

                if(file.getSize() > 0) {

                    String orgName = file.getOriginalFilename();
                    String ext = orgName.substring(orgName.lastIndexOf("."));
                    String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                    file.transferTo(new File(uploadDirectory + "/" + savedName));

                    attachment.setProfileOriginalName(orgName);
                    attachment.setProfileSavedName(savedName);
                    attachment.setProfilePath(fileUploadPath);

                    int width = 50;
                    int height = 55;

                    Thumbnails.of(uploadDirectory + "/" + savedName).forceSize(width, height)
                            .toFile(thumbnailDirectory + "/thumbnail_" + savedName);

                    attachment.setProfileThumbnailPath("/upload/thumbnail/thumbnail_" + savedName);
                }

                attachment.setMemberNo(user.getMemberNo());

                result = profileService.modifyAttachment(attachment);


            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();

                File deleteFile = new File(uploadDirectory + "/" + attachment.getProfileSavedName());
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/thumbnail_" + attachment.getProfileSavedName());
                boolean isDeleted2 = deleteThumbnail.delete();

                if(isDeleted1 && isDeleted2) {
                    e.printStackTrace();
                } else {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * modifyEmail: 개인 정보 수정의 이메일 변경페이지로 포워딩합니다.
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping(value = {"/modify/email", "/modify/phone", "/modify/pwd"})
    public ModelAndView modifyEmail(ModelAndView mv,HttpServletRequest request, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);

        ProfileDTO profile = profileService.findProfileByMemberNo(memberNo);


        mv.addObject("profileAttachment", profile.getProfileAttachment());
        mv.addObject("member", profile.getMember());

        if("email".equals(uri)) {
            mv.setViewName("profile/modify/email");
        }

        if("phone".equals(uri)) {
            mv.setViewName("profile/modify/phone");
        }

        if("pwd".equals(uri)){
            mv.setViewName("profile/modify/pwd");
        }
        return mv;
    }
}
