package com.greedy.dduckleaf.followingproject.service;

import com.greedy.dduckleaf.followingproject.dto.FollowingProjectDTO;
import com.greedy.dduckleaf.followingproject.entity.FollowingProject;
import com.greedy.dduckleaf.followingproject.repository.FollowingProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class: FollowingProjectService
 * Comment : 관심 프로젝트
 * History
 * 2022/05/08 (박상범) 처음 작성 / 관심 프로젝트 등록 관련 메소드 작성
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

    public String registFollowingProject(FollowingProjectDTO followingProject) {

        followingProjectRepository.save(modelMapper.map(followingProject, FollowingProject.class));

        return "관심프로젝트로 등록되었습니다.";
    }
}
