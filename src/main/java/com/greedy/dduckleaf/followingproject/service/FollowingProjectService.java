package com.greedy.dduckleaf.followingproject.service;

import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import com.greedy.dduckleaf.followingproject.entity.Project;
import com.greedy.dduckleaf.followingproject.repository.FollowingProjectRepository;
import com.greedy.dduckleaf.followingproject.repository.ProjectForFollowingProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class: FollowingProjectService
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 등록 관련 메소드 작성, 관심 프로젝트 취소 관련 메소드 작성
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Service
public class FollowingProjectService {

    private final FollowingProjectRepository followingProjectRepository;
    private final ProjectForFollowingProjectRepository projectForFollowingProjectRepository;
    private final ModelMapper modelMapper;
    private final String FOLLOWING_PROJECT_REGIST_MESSAGE = "관심 프로젝트로 등록되었습니다.";
    private final String FOLLOWING_PROJECT_REMOVE_MESSAGE = "관심 프로젝트에서 제외되었습니다.";

    @Autowired
    public FollowingProjectService(FollowingProjectRepository followingProjectRepository, ProjectForFollowingProjectRepository projectForFollowingProjectRepository, ModelMapper modelMapper) {
        this.followingProjectRepository = followingProjectRepository;
        this.projectForFollowingProjectRepository = projectForFollowingProjectRepository;
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
}
