package com.greedy.dduckleaf.projectnotice.service;

import com.greedy.dduckleaf.projectnotice.dto.ProjectDTO;
import com.greedy.dduckleaf.projectnotice.dto.ProjectNoticeDTO;
import com.greedy.dduckleaf.projectnotice.entity.Project;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import com.greedy.dduckleaf.projectnotice.repository.ProjectForProjectNoticeRepository;
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
 * 2022/04/24 (박휘림) 회원 번호로 진행 중인 프로젝트 번호 조회 메소드 작성
 * </pre>
 * @version 1.0.5
 * @author 박휘림
 */
@Service
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;
    private final ProjectForProjectNoticeRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectNoticeService(ProjectNoticeRepository projectNoticeRepository, ProjectForProjectNoticeRepository projectRepository, ModelMapper modelMapper) {
        this.projectNoticeRepository = projectNoticeRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findProjectNoticeList: 프로젝트 공지사항 목록을 조회합니다.
     * @param pageable: 페이징 정보를 담는 객체
     * @param projectNo: 진행 중인 프로젝트 번호
     * @return 프로젝트 공지사항 목록
     * @author 박휘림
     */
    public Page<ProjectNoticeDTO> findProjectNoticeList(Pageable pageable, int projectNo) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNoticeNo").descending());

        Page<ProjectNotice> projectNoticeList = projectNoticeRepository.findAllByProjectNoticeStatusAndProjectNo("Y", projectNo, pageable);

        return projectNoticeRepository.findAllByProjectNoticeStatusAndProjectNo("Y", projectNo, pageable).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class));
    }

    /**
     * findProjectNoByFarmerNo: 로그인한 회원번호로 진행중인 프로젝트의 번호를 조회합니다.
     * @param farmerNo: 회원(파머) 번호
     * @return 진행 중인 프로젝트가 있을 경우 해당 프로젝트의 번호를 리턴하고 진행 중인 프로젝트가 없을 경우 0을 리턴
     * @author 박휘림
     */
    public int findProjectNoByFarmerId(int farmerNo) {

        Project project = projectRepository.findByFarmerNoAndAndProgressStatus(farmerNo, 3);

        return project != null? project.getProjectNo() : 0;
    }

    /**
     * findProjectNoticeDetail: 프로젝트 공지사항 상세정보를 조회합니다.
     * @param projectNoticeNo: 조회할 프로젝트 공지사항 번호
     * @return 공지사항 상세정보
     * @author 박휘림
     */
    public ProjectNoticeDTO findProjectNoticeDetail(int projectNoticeNo) {

        return projectNoticeRepository.findById(projectNoticeNo).map(projectNotice -> modelMapper.map(projectNotice, ProjectNoticeDTO.class)).get();
    }

    /**
     * registProjectNotice: 프로젝트 공지사항을 등록합니다.
     * @param newNotice: 등록할 공지사항 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void registProjectNotice(ProjectNoticeDTO newNotice) {

        projectNoticeRepository.save(modelMapper.map(newNotice, ProjectNotice.class));

    }

    /**
     * modifyProjectNotice: 프로젝트 공지사항을 수정합니다.
     * @param updateNotice: 수정할 공지사항 정보를 담은 객체
     * @author 박휘림
     */
    @Transactional
    public void modifyProjectNotice(ProjectNoticeDTO updateNotice) {

        ProjectNotice notice = projectNoticeRepository.findById(updateNotice.getProjectNoticeNo()).get();
        notice.setProjectNoticeTitle(updateNotice.getProjectNoticeTitle());
        notice.setProjectNoticeContent(updateNotice.getProjectNoticeContent());
    }

    /**
     * removeProjectNotice: 프로젝트 공지사항을 삭제합니다.
     * @param projectNoticeNo: 삭제할 프로젝트 번호
     * @author 박휘림
     */
    @Transactional
    public int removeProjectNotice(int projectNoticeNo) {

        ProjectNotice notice = projectNoticeRepository.findById(projectNoticeNo).get();
        notice.setProjectNoticeStatus("N");

        return notice.getProjectNo();
    }

    /**
     * findProjectInfo: 프로젝트 정보를 조회합니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 정보를 담은 dto
     * @author 박휘림
     */
    public ProjectDTO findProjectInfo(int projectNo) {

        Project project = projectRepository.findByProjectNo(projectNo);

        return modelMapper.map(project, ProjectDTO.class);
    }
}
