package com.greedy.dduckleaf.refund.find.service;

import com.greedy.dduckleaf.refund.find.dto.ProjectForAdminListDTO;
import com.greedy.dduckleaf.refund.find.dto.ProjectForAdminRefundingListDTO;
import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
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
 * Comment :
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

    public Page<RefundingDTO> findRefundingListForMember(int memberNo, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("refundingInfoNo").descending());

        Page<Refunding> refundings = refundingRepo.findByMemberNo(memberNo, pageable);

        return refundings.map(refunding -> mapper.map(refunding, RefundingDTO.class));
    }

    public RefundingDTO findRefundingInfo(int refundNo) {

        Refunding refunding = refundingRepo.findById(refundNo).get();
        System.out.println("refunding = " + refunding);

        return mapper.map(refunding, RefundingDTO.class);
    }

    public List<RefundingDTO> findFarmerRefundingList(int memberNo) {

        return refundingRepo.findByProject_farmerNo(memberNo).stream().map(refunding -> mapper.map(refunding, RefundingDTO.class)).collect(Collectors.toList());
    }

    public Page<ProjectForAdminListDTO> findAdminProjectList(Pageable pageable) {

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
}






















