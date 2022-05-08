package com.greedy.dduckleaf.followingproject.service;

import com.greedy.dduckleaf.followingproject.dto.FollowingProjectDTO;
import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import com.greedy.dduckleaf.followingproject.repository.FollowingProjectRepository;
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
    private final ModelMapper modelMapper;

    @Autowired
    public FollowingProjectService(FollowingProjectRepository followingProjectRepository, ModelMapper modelMapper) {
        this.followingProjectRepository = followingProjectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * registFollowingProject: 관심 프로젝트로 등록합니다.
     * @param followingProject:  회원 번호와 프로젝트 번호를 담은 FollowingProjectDTO 객체입니다.
     * @return "관심 프로젝트로 등록되었습니다."를 리턴합니다.
     * @author 박상범
     */
    @Transactional
    public String registFollowingProject(FollowingProjectDTO followingProject) {

        followingProjectRepository.save(modelMapper.map(followingProject, FollowingProject.class));

        return "관심 프로젝트로 등록되었습니다.";
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

        FollowingProject followingProject = followingProjectRepository.findByProjectNoAndMemberNo(projectNo, memberNo);

        followingProjectRepository.deleteById(followingProject.getFollowingProjectNo());

        return "관심 프로젝트에서 제외되었습니다.";
    }
}
