package com.greedy.dduckleaf.profile.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;
import com.greedy.dduckleaf.profile.dto.ProfileDTO;
import com.greedy.dduckleaf.profile.service.ProfileService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
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
 * 2022/05/01 (박상범) 개인 정보 수정 페이지로 이동, 조회 관련 메소드 수정, 회원의 사진 정보 변경 관련 메소드 수정, 이메일 변경 페이지로 이동, 휴대전화 번호 변경 페이지로 이동, 비밀번호 변경 페이지로 이동 관련 메소드 수정
 * 2022/05/02 (박상범) 이메일 인증번호 전송 관련 메소드 작성, 회원의 이메일 주소 변경 관련 메소드 작성, 휴대전화 번호로 인증번호 전송 관련 메소드 작성, 회원의 휴대전화 번호 변경 관련 메소드 작성, 회원의 비밀번호 변경 관련 메소드 작성
 * 2022/05/03 (박상범) 회원의 프로필 이미지를 기본 프로필 이미지로 변경 관련 메소드 작성
 * 2022/05/04 (박상범) 회원의 사진 정보 변경 관련 메소드 수정, 회원의 프로필 이미지를 기본 프로필 이미지로 변경 관련 메소드 수정
 * </pre>
 * @version 1.0.8
 * @author 박상범
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Value("${file.path}")
    private String uploadPath;

    private final ProfileService profileService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProfileController(ProfileService profileService, PasswordEncoder passwordEncoder) {
        this.profileService = profileService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * modifyEmail: 개인 정보 수정의 이메일 변경 페이지, 휴대전화 번호 변경 페이지, 비밀번호 변경 페이지로 포워딩합니다.
     * @param user: 로그인된 회원의 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping(value = {"/modify/email", "/modify/phone", "/modify/pwd"})
    public ModelAndView modifyEmail(ModelAndView mv, HttpServletRequest request, @AuthenticationPrincipal CustomUser user) {

        int memberNo = user.getMemberNo();
        String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);

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

        String result = "";
        ProfileAttachmentDTO profileAttachment = new ProfileAttachmentDTO();

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

                    profileAttachment.setProfileOriginalName(orgName);
                    profileAttachment.setProfileSavedName(savedName);
                    profileAttachment.setProfilePath(fileUploadPath);

                    int width = 400;
                    int height = 400;

                    Thumbnails.of(uploadDirectory + "/" + savedName).forceSize(width, height)
                            .toFile(thumbnailDirectory + "/thumbnail_" + savedName);

                    profileAttachment.setProfileThumbnailPath("/upload/thumbnail/thumbnail_" + savedName);
                }

                profileAttachment.setMemberNo(user.getMemberNo());

                result = profileService.modifyAttachment(profileAttachment);
                user.setProfileThumbnailPath(profileAttachment.getProfileThumbnailPath());

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();

                File deleteFile = new File(uploadDirectory + "/" + profileAttachment.getProfileSavedName());
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/thumbnail_" + profileAttachment.getProfileSavedName());
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
     * sendEmailVerification: 입력받은 이메일 주소로 인증번호를 전송한다.
     * @param email: 인증 번호를 받을 이메일 주소
     * @return mv
     * @author 박상범
     */
    @PostMapping(value = {"/send/email/verification"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String sendEmailVerification(@RequestBody String email) {

        String result = profileService.sendEmailVerification(email);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(result);
    }

    /**
     * modifyEmail: 회원의 이메일 주소를 변경합니다.
     * @param email: 변경할 이메일 주소
     * @param user: 로그인된 회원 정보
     * @return mv
     * @author 박상범
     */
    @PostMapping("/modify/email")
    public ModelAndView modifyEmail(ModelAndView mv, String email, @AuthenticationPrincipal CustomUser user) {

        MemberDTO member = new MemberDTO();
        member.setMemberNo(user.getMemberNo());
        member.setEmail(email);

        profileService.modifyEmail(member);

        mv.setViewName("redirect:/following/list");

        return mv;
    }

    /**
     * sendVerification: 입력받은 휴대전화 번호로 인증번호를 전송한다.
     * @param phone: 인증 번호를 받을 이메일 주소
     * @return mv
     * @author 박상범
     */
    @PostMapping(value = {"/send/phone/verification"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String sendPhoneVerification(@RequestBody String phone) {

        String result = profileService.sendPhoneVerification(phone);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(result);
    }

    /**
     * modifyPhone: 회원의 휴대전화 번호를 변경합니다.
     * @param phone: 변경할 휴대전화 번호
     * @param user: 로그인된 회원 정보
     * @return mv
     * @author 박상범
     */
    @PostMapping("/modify/phone")
    public ModelAndView modifyPhone(ModelAndView mv, String phone, @AuthenticationPrincipal CustomUser user) {

        MemberDTO member = new MemberDTO();
        member.setMemberNo(user.getMemberNo());
        member.setPhone(phone);

        profileService.modifyPhone(member);

        mv.setViewName("redirect:/following/list");

        return mv;
    }

    /**
     * modifyMemberPwd: 회원의 비밀번호를 변경합니다.
     * @param memberPwd: 변경할 비밀번호
     * @param user: 로그인된 회원 정보
     * @return mv
     * @author 박상범
     */
    @PostMapping("/modify/pwd")
    public ModelAndView modifyMemberPwd(ModelAndView mv, String memberPwd, @AuthenticationPrincipal CustomUser user) {

        MemberDTO member = new MemberDTO();
        member.setMemberNo(user.getMemberNo());
        member.setMemberPwd(passwordEncoder.encode(memberPwd));

        profileService.modifyMemberPwd(member);

        mv.setViewName("redirect:/following/list");

        return mv;
    }

    /**
     * removeImage: 회원의 프로필 이미지를 기본 이미지로 변경합니다.
     * @param user: 로그인된 회원 정보
     * @return mv
     * @author 박상범
     */
    @GetMapping(value = {"/remove/thumbnail"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String removeImage(@AuthenticationPrincipal CustomUser user) {

        String profileAttachmentPath = profileService.removeProfileAttachment(user.getMemberNo());
        user.setProfileThumbnailPath(profileAttachmentPath);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(profileAttachmentPath);
    }
}
