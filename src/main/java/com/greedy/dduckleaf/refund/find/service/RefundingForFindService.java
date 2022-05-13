package com.greedy.dduckleaf.refund.find.service;

import com.greedy.dduckleaf.refund.find.dto.*;
import com.greedy.dduckleaf.refund.find.entity.FundingCount;
import com.greedy.dduckleaf.refund.find.entity.Project;
import com.greedy.dduckleaf.refund.find.entity.ProjectForAdminList;
import com.greedy.dduckleaf.refund.find.entity.Refunding;
import com.greedy.dduckleaf.refund.find.repository.ProjectForAdminRefundFindRepositroy;
import com.greedy.dduckleaf.refund.find.repository.RefundingForFindRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : RefundingService
 * Comment : 환불 조회
 *
 * History
 * 2022-05-04 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Service
public class RefundingForFindService {

    private final RefundingForFindRepository refundingRepo;
    private final ProjectForAdminRefundFindRepositroy projectRepo;
    private final ModelMapper mapper;

    public RefundingForFindService(RefundingForFindRepository refundingRepo, ProjectForAdminRefundFindRepositroy projectRepo, ModelMapper mapper) {
        this.refundingRepo = refundingRepo;
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }

    /**
     * findRefundingListForMember : 회원의 환불 정보 목록을 조회합니다.
     * @param  memberNo : 회원번호를 전달받습니다.
     * @return Page<RefundingDTO> : 환불 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<RefundingDTO> findRefundingListForMember(int memberNo, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("refundingInfoNo").descending());

        Page<Refunding> refundings = refundingRepo.findByMemberNo(memberNo, pageable);

        return refundings.map(refunding -> mapper.map(refunding, RefundingDTO.class));
    }

    /**
     * findRefundingInfo : 환불정보를 조회합니다.
     * @param  refundNo : 환불 번호를 전달받습니다.
     * @return RefundingDTO  환불 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public RefundingDTO findRefundingInfo(int refundNo) {

        Refunding refunding = refundingRepo.findById(refundNo).get();

        return mapper.map(refunding, RefundingDTO.class);
    }

    /**
     * findFarmerRefundingList : 파머탭에서 환불 목록을 조회합니다.
     * @param memberNo : 파머의 번호를 전달받습니다.
     * @return List<RefundingDTO> : 환불목록을 반환합니다.
     *
     * @author 홍성원
     */
    public List<RefundingDTO> findFarmerRefundingList(int memberNo) {

        return refundingRepo.findByProject_farmerNo(memberNo).stream().map(refunding -> mapper.map(refunding, RefundingDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAdminProjectList : 관리자 페이지에서 한 프로젝트내 환불 목록을 조회합니다./
     * @return projectDTO : 하나의 프로젝트의 환불목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<ProjectForAdminListDTO> findAdminProjectList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNo").descending());

        Page<ProjectForAdminList> projects = projectRepo.findByProgressStatus_progressNoBetween(3, 4, pageable);

        Page<ProjectForAdminListDTO> projectDTOs = projects.map(project -> {
            ProjectForAdminListDTO projectDTO =  mapper.map(project, ProjectForAdminListDTO.class);

            projectDTO.setFundingCount(project.getFundings() != null? project.getFundings().size(): 0);

            List<FundingCount> fundingCount = project.getFundings();
            int refundCount = 0;
            for(int i = 0; i < fundingCount.size(); i++) {
                refundCount += fundingCount.get(i).getRefundings().size();
            }

            projectDTO.setRefundingCount(refundCount);

            return projectDTO;
        });

        return projectDTOs;
    }

    /**
     * findAdminListByProject : 프로젝트 별 환불 개수를 조회합니다.
     * @param  projectNo : 프로젝트 번호를 전달받습니다.
     * @return projectDTOs : 프로젝트 정보를 반환합니다.
     *
     * @author 홍성원
     */
    public Page<ProjectForAdminListDTO> findAdminListByProject(int projectNo, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNo").descending());

        Page<ProjectForAdminList> projects = projectRepo.findAll(pageable);

        Page<ProjectForAdminListDTO> projectDTOs = projects.map(project -> {
            ProjectForAdminListDTO projectDTO =  mapper.map(project, ProjectForAdminListDTO.class);

            projectDTO.setFundingCount(project.getFundings() != null? project.getFundings().size(): 0);

            List<FundingCount> fundingCount = project.getFundings();
            int refundCount = 0;
            for(int i = 0; i < fundingCount.size(); i++) {
                refundCount += fundingCount.get(i).getRefundings().size();
            }

            projectDTO.setRefundingCount(refundCount);

            return projectDTO;
        });

        return projectDTOs;
    }

    /**
     * findAdminRefundingListByProject : 프로젝트의 환불 목록 및 정보를 조회합니다.
     * @param  projectNo : 프로젝트 번호를 전달받습니다.
     * @return refundingDTOs : 환불 정보 목록을 반환합니다.
     *
     * @author 홍성원
     */
    public Page<RefundingForAdminListDTO> findAdminRefundingListByProject(int projectNo, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("refundingInfoNo").descending());

        Page<Refunding> refundings = refundingRepo.findByProject_projectNo(projectNo, pageable);

        Page<RefundingForAdminListDTO> refundingDTOs = refundings.map(refunding -> {
            RefundingForAdminListDTO refundingDTO = new RefundingForAdminListDTO();

            refundingDTO.setRefundingDate(refunding.getRefundingDate());
            refundingDTO.setProjectNo(refunding.getProject().getProjectNo());
            refundingDTO.setRefundStatus(refunding.getRefundingStatus().getRefundingStatusName());
            refundingDTO.setRefundingInfoNo(refunding.getRefundingInfoNo());
            refundingDTO.setRefundingEndDate(refunding.getRefundingEndDate());
            refundingDTO.setProjectName(refunding.getProject().getProjectName());
            refundingDTO.setFarmerName(refunding.getRefundingMemberName());


            return refundingDTO;
        });

       return refundingDTOs;
    }

    /**
     * findAdminRefundingListByStatus : 환불 상태별 목록을 조회합니다.
     * @param status : 상태번호를 전달받습니다.
     * @return refundingDTOs : 환불 목록을 조회합니다.
     *
     * @author 홍성원
     */
    public Page<RefundingForAdminListDTO> findAdminRefundingListByStatus(int status, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("refundingInfoNo").descending());

        String refundStatus = "";
        switch(status) {
            case 1: refundStatus = "요청"; break;
            case 2: refundStatus = "승인"; break;
            case 3: refundStatus = "거절"; break;
        }

        Page<Refunding> refundings = refundingRepo.findByRefundingStatus_refundingStatusNameContaining(refundStatus, pageable);

        Page<RefundingForAdminListDTO> refundingDTOs = refundings.map(refunding -> {
            RefundingForAdminListDTO refundingDTO = new RefundingForAdminListDTO();

            refundingDTO.setRefundingDate(refunding.getRefundingDate());
            refundingDTO.setProjectNo(refunding.getProject().getProjectNo());
            refundingDTO.setRefundStatus(refunding.getRefundingStatus().getRefundingStatusName());
            refundingDTO.setRefundingInfoNo(refunding.getRefundingInfoNo());
            refundingDTO.setRefundingEndDate(refunding.getRefundingEndDate());
            refundingDTO.setProjectName(refunding.getProject().getProjectName());
            refundingDTO.setFarmerName(refunding.getRefundingMemberName());

            return refundingDTO;
        });

        return refundingDTOs;
    }
}