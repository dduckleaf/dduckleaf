package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.projectnotice.dto.ProjectDTO;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.entity.Project;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import com.greedy.dduckleaf.projectnotice.repository.ProjectNoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <pre>
 * Class: ProjectNoticeService
 * Comment : 프로젝트 공지사항
 * History
 * 2022/04/18 (박휘림) 처음 작성 / 목록 조회 메소드 작성 시작
 * 2022/04/21 (박휘림) 목록 조회 메소드 작성 완료, 공지사항 상세조회 메소드 작성 시작
 * 2022/04/22 (박휘림) 공지사항 상세조회 메소드 작성 완료, 공지사항 작성하기 메소드 작성 시작
 * 2022/04/23 (박휘림) 공지사항 작성하기 메소드 작성 완료, 공지사항 수정하기 메소드 작성 시작
 * 2022/04/24 (박휘림) 공지사항 수정하기,삭제하기 메소드 작성 완료
 * </pre>
 * @version 1.0.5
 * @author 박휘림
 */
@Service
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectNoticeService(ProjectNoticeRepository projectNoticeRepository, ModelMapper modelMapper) {
        this.projectNoticeRepository = projectNoticeRepository;
        this.modelMapper = modelMapper;
    }

    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable, int projectNo) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());

        Page<ProjectNotice> projectNoticeList = projectNoticeRepository.findAllByProjectNo(projectNo, pageable);

        return projectNoticeRepository.findAllByProjectNo(projectNo, pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
    }

    public ProjectNoticeDTO findProjectNoticeDetail(int projectNoticeNo) {

        return projectNoticeRepository.findById(projectNoticeNo).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).get();
    }


    @Transactional
    public void registProjectNotice(ProjectNoticeDTO newNotice) {

        projectNoticeRepository.save(modelMapper.map(newNotice, ProjectNotice.class));

    }

    @Transactional
    public void modifyProjectNotice(ProjectNoticeDTO updateNotice) {

        ProjectNotice notice = projectNoticeRepository.findById(updateNotice.getProjectNoticeNo()).get();
        notice.setProjectNoticeTitle(updateNotice.getProjectNoticeTitle());
        notice.setProjectNoticeContent(updateNotice.getProjectNoticeContent());
    }

    @Transactional
    public void removeProjectNotice(int projectNoticeNo) {

        ProjectNotice notice = projectNoticeRepository.findById(projectNoticeNo).get();
        notice.setProjectNoticeStatus("N");
    }
}
