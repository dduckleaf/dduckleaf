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
 * 2022/04/30 (박상범) 회원의 사진 정보 변경 관련 메소드 작성
 * </pre>
 * @version 1.0.1
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

        ProfileAttachmentDTO profileAttachment = profileService.findProfileByMemberNo(memberNo);

        mv.addObject("profileAttachment", profileAttachment);
        mv.setViewName("/profile/thumbnail");

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
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request, @AuthenticationPrincipal CustomUser user) {

        ProfileAttachmentDTO attachment = new ProfileAttachmentDTO();
        String result = "";

        String rootLocation = request.getSession().getServletContext().getRealPath("resources");

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
                    attachment.setMemberNo(user.getMemberNo());

                    int width = 50;
                    int height = 55;

                    Thumbnails.of(uploadDirectory + "/" + savedName).forceSize(width, height)
                            .toFile(thumbnailDirectory + "/thumbnail_" + savedName);

                    attachment.setProfileThumbnailPath("/resources/upload/thumbnail/thumbnail_" + savedName);
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
                    System.out.println("업로드 실패로 인한 사진 삭제 완료 !!!");
                    e.printStackTrace();
                } else {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
