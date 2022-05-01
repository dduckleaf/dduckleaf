package com.greedy.dduckleaf.settlement.service;

import com.greedy.dduckleaf.settlement.dto.ProjectDTO;
import com.greedy.dduckleaf.settlement.dto.SettlementInfoDTO;
import com.greedy.dduckleaf.settlement.dto.SettlementOverview;
import com.greedy.dduckleaf.settlement.dto.SettlementPaymentInfoDTO;
import com.greedy.dduckleaf.settlement.entity.SettlementInfo;
import com.greedy.dduckleaf.settlement.repository.ProjectForSettlementRepository;
import com.greedy.dduckleaf.settlement.repository.SettlementInfoRepository;
import com.greedy.dduckleaf.settlement.repository.SettlementPaymentInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : SettlementService
 * Comment : 프로젝트 정산 업무에 사용되는 트랜젝션 메소드를 작성하였습니다.
 *
 * History
 * 2022-04-30 (장민주) 처음 작성
 *            (장민주) findSettlementPaymentInfo 서비스 메소드 작성.
 *            (장민주) findSettlementInfoForEndProject 내부연산 메소드 작성.
 *            (장민주) findSettlementPaymentInfoForEndProject 내부연산 메소드 작성.
 *
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
@Service
public class SettlementService {

    @Autowired
    private final SettlementInfoRepository settlementInfoRepository;
    @Autowired
    private final SettlementPaymentInfoRepository settlementPaymentInfoRepository;
    @Autowired
    private final ProjectForSettlementRepository projectRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public SettlementService(SettlementInfoRepository settlementInfoRepository,
                             SettlementPaymentInfoRepository settlementPaymentInfoRepository, ProjectForSettlementRepository projectRepository, ModelMapper modelMapper) {
        this.settlementInfoRepository = settlementInfoRepository;
        this.settlementPaymentInfoRepository = settlementPaymentInfoRepository;
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findSettlementPaymentInfo: 종료된 프로젝트의 정산정보와 회차 별 정산금 지급내역 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return 프로젝트 정산정보와 회차 별 프로젝트 정산금 지급내역정보
     * @author 장민주
     */
    public SettlementOverview findSettlementPaymentInfo(int projectNo) {

        /* 프로젝트의 정산정보 조회 */
        SettlementInfoDTO settlementInfo = findSettlementInfoForEndProject(projectNo);

        /* 조회한 정산정보의 식별번호로 프로젝트의 회차 별 정산금 지급내역 조회 */
        List<SettlementPaymentInfoDTO> settlementPaymentInfos =
                findSettlementPaymentInfoForEndProject(settlementInfo.getSettlementInfoNo());

        /* 조회된 값들을 하나의 DTO에 담아 반환 */
        SettlementOverview settlementOverview = new SettlementOverview();
        settlementOverview.setSettlementInfo(settlementInfo);
        settlementOverview.setSettlementPaymentInfos(settlementPaymentInfos);

        return settlementOverview;
    }

    /**
     * 메소드명: (내부연산 메소드) 종료된 프로젝트의 정산정보 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return DTO 타입으로 형변환하여 영속성을 해제한 정산정보 조회결과
     * @author 장민주
     */
    @Transactional
    public SettlementInfoDTO findSettlementInfoForEndProject(int projectNo) {

        SettlementInfo settlementInfo = settlementInfoRepository.findByProject_ProjectNo(projectNo);
        System.out.println("settlementInfo = " + settlementInfo);

         SettlementInfoDTO s = modelMapper.map(settlementInfo, SettlementInfoDTO.class);
        System.out.println("s = " + s);

         return s;
    }

    /**
     * findSettlementPaymentInfoForEndProject: (내부연산 메소드) 종료된 프로젝트의 정산금 지급내역 조회를 요청하는 메소드입니다.
     * @param settlementInfoNo: 정산정보 번호
     * @return DTO 타입으로 형변환하여 영속성을 해제한 정산금 지급내역 조회결과
     * @author 장민주
     */
    @Transactional
    public List<SettlementPaymentInfoDTO> findSettlementPaymentInfoForEndProject(int settlementInfoNo) {

        List<SettlementPaymentInfoDTO> ffff = (settlementPaymentInfoRepository.findBySettlementInfo_SettlementInfoNo(settlementInfoNo).stream()
                .map(settlementPaymentInfo -> modelMapper.map(settlementPaymentInfo, SettlementPaymentInfoDTO.class))
                .collect(Collectors.toList()));

        ffff.forEach(System.out::println);

        return ffff;
    }

    public Page<ProjectDTO> findAllEndProjectsAchievedSuccess(int progressStatus, int achievementRate, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("projectNo").descending());

        return projectRepository.findAllByProgressStatusAndAchievementRateGreaterThan(progressStatus, achievementRate, pageable)
                .map(project -> modelMapper.map(project, ProjectDTO.class));
    }

}
