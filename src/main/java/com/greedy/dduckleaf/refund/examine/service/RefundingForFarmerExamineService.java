package com.greedy.dduckleaf.refund.examine.service;

import com.greedy.dduckleaf.refund.examine.dto.RefundObjectionHistoryDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.dto.RefundingObjectionDTO;
import com.greedy.dduckleaf.refund.examine.entity.*;
import com.greedy.dduckleaf.refund.examine.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;
/**
 * <pre>
 * Class : RefundingForFarmerExamineService
 * Comment : 환불 심사
 *
 * History
 * 2022-05-05 홍성원 작성
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Service
public class RefundingForFarmerExamineService {

    private final ModelMapper mapper;
    private final FundingForRefundingFarmerExamineRepository fundingRepo;
    private final RefundingForRefundingFarmerExamineRepository refundingRepo;
    private final RefundingHistoryForFarmerExamineRepository refundHistoryRepo;
    private final RefundingStatusForFarmerExamineRepository refundingStatusRepo;
    private final RewardShippingForRefundingFarmerExamineRepository shippingRepo;
    private final SettlementInfoForRefundingExamineRepository settlementInfoRepo;
    private final SettlementChangeHistoryForRefundingExamineRepository settlementHistoryRepo;
    private final RefundingObjectionRepository objectionRepo;
    private final RefundObjectionHistoryRepository refundObjectionHistoryRepo;
    private final RefundingObjectionRepository refundObjectionRepo;
    private final ProjectForRefundingExamineRepository projectRepo;

    public RefundingForFarmerExamineService(ModelMapper mapper, FundingForRefundingFarmerExamineRepository fundingRepo, RefundingForRefundingFarmerExamineRepository refundingRepo, RefundingHistoryForFarmerExamineRepository refundHistoryRepo, RefundingStatusForFarmerExamineRepository refundingStatusRepo, RewardShippingForRefundingFarmerExamineRepository shippingRepo, SettlementInfoForRefundingExamineRepository settlementInfoRepo, SettlementChangeHistoryForRefundingExamineRepository settlementHistoryRepo, RefundingObjectionRepository objectionRepo, RefundObjectionHistoryRepository refundObjectionHistoryRepo, RefundingObjectionRepository refundObjectionRepo, ProjectForRefundingExamineRepository projectRepo) {

        this.mapper = mapper;
        this.fundingRepo = fundingRepo;
        this.refundingRepo = refundingRepo;
        this.refundHistoryRepo = refundHistoryRepo;
        this.refundingStatusRepo = refundingStatusRepo;
        this.shippingRepo = shippingRepo;
        this.settlementInfoRepo = settlementInfoRepo;
        this.settlementHistoryRepo = settlementHistoryRepo;
        this.objectionRepo = objectionRepo;
        this.refundObjectionHistoryRepo = refundObjectionHistoryRepo;
        this.refundObjectionRepo = refundObjectionRepo;
        this.projectRepo = projectRepo;
    }

    /**
     * confirmRefunding : 파머가 환불 승인 시 필요한 데이터를 삽입 또는 수정합니다.
     * @param refundiNo : 파머가 승인한 환불 번호를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void confirmRefunding(int refundiNo, int memberNo) {

        /* 환불내역에 상태를 환불 승인으로 변경 후 환불 종료일을 현재시간으로 수정합니다. */
        Refunding refunding = refundingRepo.findById(refundiNo).get();
        refunding.setRefundingEndDate(getDateAndTime());
        refunding.setRefundingStatus(refundingStatusRepo.findById(2).get());

        /* 펀딩 신청내역에 펀딩상태를 N으로 변경합니다. */
        Funding funding = fundingRepo.findById(refunding.getFunding().getFundingInfoNo()).get();
        funding.setFundingStatus("N");

        /* 환불이력에 승인 내역을 추가합니다. */
        RefundingHistory refundingHistory = new RefundingHistory();
        refundingHistory.setManagerType("파머");
        refundingHistory.setRefundingHistoryDate(getDateAndTime());
        refundingHistory.setRefundingStatusNo(2);
        refundingHistory.setHistoryCategory("승인");
        refundingHistory.setRefundingInfoNo(refundiNo);
        refundingHistory.setRefundingAmount(funding.getFundingAmount());
        refundingHistory.setRefundingHistoryCategory("환불신청");
        refundingHistory.setRefundingMemberNo(refunding.getMemberNo());
        refundingHistory.setManagerNo(memberNo);
        refundHistoryRepo.save(refundingHistory);
        refundingHistory = refundHistoryRepo.findLastest();

        /* 정산금 변동 이력을 추가합니다. */
        /* 1. 펀딩금에 관한 이력을 추가합니다. */
        SettlementChangeHistory settlementHistory = new SettlementChangeHistory();
        settlementHistory.setChangedAmount(funding.getFundingAmount() - funding.getDonateAmount());
        settlementHistory.setChangedReason("환불");
        settlementHistory.setChangedDate(getDateAndTime());
        int projectNo = funding.getProjectNo();
        SettlementInfo settlementInfo = settlementInfoRepo.findByProjectNo(projectNo);
        settlementHistory.setSettlementInfoNo(settlementInfo.getSettlementInfoNo());
        settlementHistory.setSettlementChangedCategory(2);
        settlementHistory.setRefundingHistoryNo(refundingHistory.getRefundingHisotryNo());
        settlementHistoryRepo.save(settlementHistory);

        /* 2. 후원금에 관한 이력을 추가합니다. */
        SettlementChangeHistory settlementHistoryDonate = new SettlementChangeHistory();
        settlementHistoryDonate.setChangedAmount(funding.getDonateAmount());
        settlementHistoryDonate.setChangedReason("환불");
        settlementHistoryDonate.setChangedDate(getDateAndTime());
        settlementHistoryDonate.setSettlementInfoNo(settlementInfo.getSettlementInfoNo());
        settlementHistoryDonate.setSettlementChangedCategory(2);
        settlementHistoryDonate.setRefundingHistoryNo(refundingHistory.getRefundingHisotryNo());
        settlementHistoryRepo.save(settlementHistoryDonate);

        /* 발송내역에 해당 펀딩 정보를 삭제합니다. */
        /* 남기랑 의견조율 해서 반영하자 */
//        shippingRepo.deleteById(shippingRepo.findByFunding_fundingInfoNo(funding.getFundingInfoNo()).getRewardShippingNo());

        /* 정산금 변동 이력 테이블에 금액, 사유 입력 */
        SettlementChangeHistory settlement = new SettlementChangeHistory();
        settlement.setChangedAmount(funding.getDonateAmount());
        settlement.setChangedReason("환불");
        settlement.setChangedDate(getDateAndTime());

        fundingRepo.save(funding);
        refundingRepo.save(refunding);
    }

    /**
     * refuseRefunding : 파머가 환불 거절 시 필요한 데이터를 삽입 또는 수정합니다.
     * @param refundingDTO : 파머가 거절한 환불 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void refuseRefunding(RefundingDTO refundingDTO) {

        /* 환불내역에 상태를 환불 거절로 수정합니다다. */
        Refunding refunding = refundingRepo.findById(refundingDTO.getRefundingInfoNo()).get();
        refunding.setRefundingStatus(refundingStatusRepo.findById(3).get());

        Funding funding = fundingRepo.findById(refunding.getFunding().getFundingInfoNo()).get();

        /* 환불이력에 승인 내역을 추가합니다. */
        RefundingHistory refundingHistory = new RefundingHistory();
        refundingHistory.setManagerType("파머");
        refundingHistory.setRefundingHistoryDate(getDateAndTime());
        refundingHistory.setRefundingStatusNo(3);
        refundingHistory.setHistoryCategory("거절");
        refundingHistory.setRefundingInfoNo(refundingDTO.getRefundingInfoNo());
        refundingHistory.setRefundingAmount(funding.getFundingAmount());
        refundingHistory.setRefundingHistoryCategory("환불신청");
        refundingHistory.setRefundingMemberNo(refunding.getMemberNo());
        refundingHistory.setManagerNo(refundingDTO.getMemberNo());
        refundingHistory.setRefundingRefuseReason(refundingDTO.getRefundingReason());

        refundingRepo.save(refunding);
        refundHistoryRepo.save(refundingHistory);

        /* 환불 승인 시 프로젝트 달성률에 반영합니다. */
        /* 달성률 반영 */
        Project project = projectRepo.findById(funding.getProjectNo()).get();

        double target = project.getFundTargetAmount();
        int amount = 0;

        List<Funding> fundingList = project.getFundings();

        for(int i = 0; i < fundingList.size(); i++) {

            amount += fundingList.get(i).getFundingAmount();
        }

        amount -= funding.getFundingAmount();

        double rate = amount / target * 100;
        project.setAchievementRate(rate);

        projectRepo.save(project);
    }

    /**
     * registObjection : 서포터가 파머에게 거절 된 환불 내역을 플랫폼에 이의신청 등록합니다.
     * @param refundingNo : 서포터가 이의신청한 환불 번호를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void registObjection(int refundingNo) {

        Refunding refunding = refundingRepo.findById(refundingNo).get();
        RefundingObjection objection = new RefundingObjection();
        objection.setRefundObjectionMemberNo(refunding.getMemberNo());
        objection.setRefundingInfoNo(refundingNo);
        objection.setRefundStatus("신청");

        objectionRepo.save(objection);
        objection = objectionRepo.findLastest();

        RefundObjectionHistory refundObjectionHistory = new RefundObjectionHistory();

        refundObjectionHistory.setHistoryDate(getDateAndTime());
        refundObjectionHistory.setHistoryCategory("신청");
        refundObjectionHistory.setRefundObjectionNo(objection.getRefundObjectionNo());

        refundObjectionHistoryRepo.save(refundObjectionHistory);


        /* 환불 상태를 심사 요청으로 변경합니다. */
        RefundingStatus status = refundingStatusRepo.findById(4).get();
        refunding.setRefundingStatus(status);
        refundingRepo.save(refunding);
    }

    /**
     * findObjectionList : 이의신청 내역을 조회합니다.
     * @param pageable : 페이지 정보다 담긴 변수를 전달받습니다.
     *
     * @author 홍성원
     */
    public Page<RefundingObjectionDTO> findObjectionList(Pageable pageable) {

        Page<RefundingObjection> objections = objectionRepo.findAll(pageable);

        Page<RefundingObjectionDTO> objectionDTOs = objections.map(objection -> {
            return mapper.map(objection, RefundingObjectionDTO.class);
        });

        return objectionDTOs;
    }

     /**
      * examineObjectionconfirm : 환불 심사의 이의신청을 승인합니다.
      * @param refundingNo : 이의신청의 정보를 전달받습니다.
      * @author 홍성원
      */
    public void examineObjectionconfirm(int refundingNo, int memberNo) {

        /* 환불 이의신청 내역 상태를 승인으로 변경합니다. */
        RefundingObjection refundingObjection = refundObjectionRepo.findByRefundingInfoNo(refundingNo).get(0);
        refundingObjection.setRefundStatus("승인");

        refundObjectionRepo.save(refundingObjection);

        /* 환불 이의신청 이력에 승인 내역을 추가합니다. */
        RefundObjectionHistory refuseObjectionHistory = new RefundObjectionHistory();
        refuseObjectionHistory.setHistoryDate(getDateAndTime());
        refuseObjectionHistory.setRefundObjectionNo(refundingObjection.getRefundObjectionNo());
        refuseObjectionHistory.setHistoryCategory("승인");

        refundObjectionHistoryRepo.save(refuseObjectionHistory);

        /* 환불 내역 정보를 환불승인으로 수정합니다. */
        Refunding refunding = refundingRepo.findById(refundingObjection.getRefundingInfoNo()).get();
        RefundingStatus refundingStatus = refundingStatusRepo.findById(5).get();
        refunding.setRefundingStatus(refundingStatus);
        refunding.setRefundingEndDate(getDateAndTime());

        refundingRepo.save(refunding);

        /* 환불 이력에 승인 결과를 추가합니다. */
        RefundingHistory refundingHistory = new RefundingHistory();
        refundingHistory.setManagerType("관리자");
        refundingHistory.setRefundingHistoryDate(getDateAndTime());
        refundingHistory.setRefundingStatusNo(refundingStatus.getRefundingStatusNo());
        refundingHistory.setHistoryCategory("승인");
        refundingHistory.setRefundingHistoryCategory("플랫폼환불신청");
        refundingHistory.setRefundingInfoNo(refunding.getRefundingInfoNo());
        refundingHistory.setRefundingObjectionNo(refundingObjection.getRefundObjectionNo());
        refundingHistory.setRefundingMemberNo(refunding.getMemberNo());
        refundingHistory.setManagerNo(memberNo);

        refundHistoryRepo.save(refundingHistory);

        /* 환불 승인 시 프로젝트 달성률에 반영합니다. */
        /* 달성률 반영 */
        Project project = projectRepo.findById(refunding.getProject().getProjectNo()).get();
        double target = project.getFundTargetAmount();
        int amount = 0;
        List<Funding> fundingList = project.getFundings();
        for(int i = 0; i < fundingList.size(); i++) {

            amount += fundingList.get(i).getFundingAmount();
        }
        amount -= refunding.getFunding().getFundingAmount();

        double rate = amount / target * 100;

        project.setAchievementRate(rate);
        projectRepo.save(project);
     }

      /**
       * examineObjextionrefuse : 환불 심사의 이의신청을 거절합니다.
       * @param historyDTO : 이의신청의 번호 및 거절사유가 담긴 정보를 전달받습니다.
       * @return
       * @author 홍성원
       */
    public void examineObjectionRefuse(RefundObjectionHistoryDTO historyDTO, int memberNo) {

         /* 이의신청 내역의 상태를 거절로 변경합니다 */
        RefundingObjection refundingObjection = refundObjectionRepo.findByRefundingInfoNo(historyDTO.getRefundInfoNo()).get(0);
        refundingObjection.setRefundStatus("거절");

        refundObjectionRepo.save(refundingObjection);

        /* 이의신청 이력에 거절 내역을 추가합니다. */
        RefundObjectionHistory history = new RefundObjectionHistory();
        history.setHistoryDate(getDateAndTime());
        history.setRefundObjectionNo(refundingObjection.getRefundObjectionNo());
        history.setRefuseReason(historyDTO.getRefuseReason());
        history.setHistoryCategory("거절");

        refundObjectionHistoryRepo.save(history);

        /* 환불 내역 정보를 환불거절로 수정합니다. */
        Refunding refunding = refundingRepo.findById(refundingObjection.getRefundingInfoNo()).get();
        RefundingStatus refundingStatus = refundingStatusRepo.findById(6).get();
        refunding.setRefundingStatus(refundingStatus);
        refunding.setRefundingEndDate(getDateAndTime());

        refundingRepo.save(refunding);

        /* 환불 이력에 거절 결과를 추가합니다. */
        RefundingHistory refundingHistory = new RefundingHistory();

        refundingHistory.setManagerType("관리자");
        refundingHistory.setRefundingHistoryDate(getDateAndTime());
        refundingHistory.setRefundingStatusNo(refundingStatus.getRefundingStatusNo());
        refundingHistory.setHistoryCategory("거절");
        refundingHistory.setRefundingHistoryCategory("플랫폼환불신청");
        refundingHistory.setRefundingInfoNo(refunding.getRefundingInfoNo());
        refundingHistory.setRefundingObjectionNo(refundingObjection.getRefundObjectionNo());
        refundingHistory.setRefundingMemberNo(refunding.getMemberNo());
        refundingHistory.setManagerNo(memberNo);

        refundHistoryRepo.save(refundingHistory);
    }
}