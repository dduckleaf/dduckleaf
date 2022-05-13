package com.greedy.dduckleaf.followingproject.service;

import com.greedy.dduckleaf.followingproject.dto.ProjectDTO;
import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import com.greedy.dduckleaf.followingproject.entity.Project;
import com.greedy.dduckleaf.followingproject.entity.ProjectAttachment;
import com.greedy.dduckleaf.followingproject.repository.FollowingProjectRepository;
import com.greedy.dduckleaf.followingproject.repository.ProjectAttachmentForFollowingProjectRepository;
import com.greedy.dduckleaf.followingproject.repository.ProjectForFollowingProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Class: FollowingProjectService
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 등록 관련 메소드 작성, 관심 프로젝트 취소 관련 메소드 작성
 * 2022/05/09 (박상범) 관심 프로젝트 목록 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.2
 * @author 박상범
 */
@Service
public class FollowingProjectService {

    private final FollowingProjectRepository followingProjectRepository;
    private final ProjectForFollowingProjectRepository projectForFollowingProjectRepository;
    private final ProjectAttachmentForFollowingProjectRepository projectAttachmentForFollowingProjectRepository;
    private final ModelMapper modelMapper;
    private final String FOLLOWING_PROJECT_REGIST_MESSAGE = "관심 프로젝트로 등록되었습니다.";
    private final String FOLLOWING_PROJECT_REMOVE_MESSAGE = "관심 프로젝트에서 제외되었습니다.";

    @Autowired
    public FollowingProjectService(FollowingProjectRepository followingProjectRepository, ProjectForFollowingProjectRepository projectForFollowingProjectRepository, ProjectAttachmentForFollowingProjectRepository projectAttachmentForFollowingProjectRepository, ModelMapper modelMapper) {
        this.followingProjectRepository = followingProjectRepository;
        this.projectForFollowingProjectRepository = projectForFollowingProjectRepository;
        this.projectAttachmentForFollowingProjectRepository = projectAttachmentForFollowingProjectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * registFollowingProject: 관심 프로젝트로 등록합니다.
     * @param projectNo:  관심 프로젝트로 등록할 프로젝트 번호
     * @param memberNo:  로그인된 회원의 회원 번호
     * @return "관심 프로젝트로 등록되었습니다."를 리턴합니다.
     * @author 박상범
     */
    @Transactional
    public String registFollowingProject(int projectNo, int memberNo) {

        FollowingProject followingProject = new FollowingProject();
        Project project = projectForFollowingProjectRepository.findById(projectNo).get();

        followingProject.setProject(project);
        followingProject.setMemberNo(memberNo);

        followingProjectRepository.save(followingProject);

        return FOLLOWING_PROJECT_REGIST_MESSAGE;
    }

    /**
     * removeFollowingProject:
     * @param projectNo:  프로젝트 번호
     * @param memberNo:  회원 번호
     * @return "관심 프로젝트에서 제외되었습니다."를 return합니다.
     * @author 박상범
     */
    @Transactional
    public String removeFollowingProject(int projectNo, int memberNo) {

        FollowingProject followingProject = followingProjectRepository.findByProjectProjectNoAndMemberNo(projectNo, memberNo);

        followingProjectRepository.deleteById(followingProject.getFollowingProjectNo());

        return FOLLOWING_PROJECT_REMOVE_MESSAGE;
    }

    /**
     * findFollowingProjectListA: 관심 프로젝트 목록을 조회합니다.
     * @param memberNo:  회원 번호
     * @return  회원이 관심프로젝트로 등록한 프로젝트 목록을 return합니다.
     * @author 박상범
     */
    public List<ProjectDTO> findFollowingProjectList(int memberNo) throws ParseException {

        List<Project> foundFollowingProjectList = projectForFollowingProjectRepository.findFollowingProjectList(memberNo);

        List<ProjectDTO> followingProjectList = new ArrayList<>();

        for(int i = 0; i < foundFollowingProjectList.size(); i++) {

            ProjectDTO project = modelMapper.map(foundFollowingProjectList.get(i), ProjectDTO.class);

            String endDate = foundFollowingProjectList.get(i).getEndDate().replace("-","");
            String nowDate = java.sql.Date.valueOf(LocalDate.now()).toString().replace("-","");

            String format = "yyyyMMdd";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
            Date end = simpleDateFormat.parse(endDate);
            Date now = simpleDateFormat.parse(nowDate);

            long diffSec = Math.abs(end.getTime() - now.getTime());
            long diffDay = TimeUnit.DAYS.convert(diffSec, TimeUnit.MILLISECONDS);

            List<ProjectAttachment> projectAttachmentList = projectAttachmentForFollowingProjectRepository.findByProjectProjectNo(foundFollowingProjectList.get(i).getProjectNo());

            project.setDeadLine(diffDay);
            project.setAttachmentSavedName(projectAttachmentList.get(0).getProjectAttachmentSaveName());

            followingProjectList.add(project);
        }

        return followingProjectList;
    }
}
