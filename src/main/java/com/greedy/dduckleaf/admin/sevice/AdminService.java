package com.greedy.dduckleaf.admin.sevice;

import com.greedy.dduckleaf.admin.dto.DashBoardDTO;
import com.greedy.dduckleaf.admin.repository.FundingInfoForAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class: AdminService
 * Comment : 관리자 전용 기능
 * History
 * 2022/05/10 (박상범) 처음 작성 / 관리자 페이지 대시보드 조회 관련 메소드 작성
 * </pre>
 * @version 1.0.2
 * @author 박상범
 */
@Service
public class AdminService {

    private final FundingInfoForAdminRepository fundingInfoForAdminRepository;

    @Autowired
    public AdminService(FundingInfoForAdminRepository fundingInfoForAdminRepository) {
        this.fundingInfoForAdminRepository = fundingInfoForAdminRepository;
    }

    /**
     * findDashBoard: 관심 프로젝트로 등록합니다.
     * @return 월별 펀딩금, 성공 프로젝트 갯수, 실패 프로젝트 갯수, 회원 가입 횟수, 회원 탈퇴 횟수를 DashBoardDTO에 담아 리턴합니다.
     * @author 박상범
     */
    public DashBoardDTO findDashBoard() {

        List<Object[]> totalAmountList = fundingInfoForAdminRepository.findTotalAmountByMonth();
        List<Object[]> successProjectAmountList = fundingInfoForAdminRepository.findSuccessProjectAmountByMonth();
        List<Object[]> failedProjectAmountList = fundingInfoForAdminRepository.findFailedProjectAmountByMonth();
        List<Object[]> registMemberAmountList = fundingInfoForAdminRepository.findRegistMemberAmountByMonth();
        List<Object[]> removeMemberAmountList = fundingInfoForAdminRepository.findRemoveMemberAmountByMonth();

        return new DashBoardDTO(totalAmountList, successProjectAmountList, failedProjectAmountList, registMemberAmountList, removeMemberAmountList);
    }
}
