package com.greedy.dduckleaf.shippingmanagement.service;

import com.greedy.dduckleaf.shippingmanagement.dto.ProjectDTO;
import com.greedy.dduckleaf.shippingmanagement.entity.Project;
import com.greedy.dduckleaf.shippingmanagement.repository.ProjectForShippingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : ShippingService
 * Comment : 발송관리
 * History
 * 2022/05/06 (조남기) 마이페이지 파머 탭 파머 프로젝트 조회 관련 메소드 구현 완료, 발송 리워드 정보 조회 구현 시작
 * </pre>
 * @version 1.0.0
 * @author 조남기
 */
@Service
public class ShippingService {

    private final ProjectForShippingRepository shippingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShippingService(ProjectForShippingRepository shippingRepository,
                           ModelMapper modelMapper) {
        this.shippingRepository = shippingRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProjectListByMemberNo : 로그인한 회원의 프로젝트 목록을 조회합니다.
     * @param memberNo : 로그인 회원 정보를 담는 객체
     *
     * @author 조남기
     */
    public List<ProjectDTO> findProjectListByMemberNo(int memberNo) {

        List<Project> projectList = shippingRepository.findProjectNoByFarmerMemberNo(memberNo);

        return projectList.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
    }
}
