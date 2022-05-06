package com.greedy.dduckleaf.refund.examine.service;

import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.entity.Funding;
import com.greedy.dduckleaf.refund.examine.entity.Refunding;
import com.greedy.dduckleaf.refund.examine.entity.RefundingHistory;
import com.greedy.dduckleaf.refund.examine.entity.SettlementChangeHistory;
import com.greedy.dduckleaf.refund.examine.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;
/**
 * <pre>
 * Class : RefundingForFarmerExamineService
 * Comment :
 *
 * History
 * 2022-05-05 홍성원
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
    public RefundingForFarmerExamineService(ModelMapper mapper, FundingForRefundingFarmerExamineRepository fundingRepo, RefundingForRefundingFarmerExamineRepository refundingRepo, RefundingHistoryForFarmerExamineRepository refundHistoryRepo, RefundingStatusForFarmerExamineRepository refundingStatusRepo, RewardShippingForRefundingFarmerExamineRepository shippingRepo) {

        this.mapper = mapper;
        this.fundingRepo = fundingRepo;
        this.refundingRepo = refundingRepo;
        this.refundHistoryRepo = refundHistoryRepo;
        this.refundingStatusRepo = refundingStatusRepo;
        this.shippingRepo = shippingRepo;
    }

    /**
     * confirmRefunding : 파머가 환불 승인 시 필요한 데이터를 삽입 또는 수정합니다.
     * @param refundiNo : 파머가 승인한 환불 번호를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void confirmRefunding(int refundiNo, int memberNo) {

        /* 환불내역에 상태를 환불 승인으로 변경 후 환불 종료일을 현재시간으로 수정한다. */
        Refunding refunding = refundingRepo.findById(refundiNo).get();
        refunding.setRefundingEndDate(getDateAndTime());
        refunding.setRefundingStatus(refundingStatusRepo.findById(2).get());

        /* 펀딩 신청내역에 펀딩상태를 N으로 변경한다. */
        Funding funding = fundingRepo.findById(refunding.getFunding().getFundingInfoNo()).get();
        funding.setFundingStatus("N");


        /* 환불이력에 승인 내역을 추가한다. */
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

        /* 발송내역에 해당 펀딩 정보를 삭제한다. */
        /* 남기랑 의견조율 해서 반영하자 */
//        shippingRepo.deleteById(shippingRepo.findByFunding_fundingInfoNo(funding.getFundingInfoNo()).getRewardShippingNo());

        /* 정산금 변동 이력 테이블에 금액, 사유 입력 */
        SettlementChangeHistory settlement = new SettlementChangeHistory();
        settlement.setChangedAmount(funding.getDonateAmount());
        settlement.setChangedReason("환불");
        settlement.setChangedDate(getDateAndTime());




        /* 수정된 데이터 변동사항을 DB에 저장한다. */
        fundingRepo.save(funding);
        refundingRepo.save(refunding);
        refundHistoryRepo.save(refundingHistory);
    }

    /**
     * refuseRefunding : 파머가 환불 거절 시 필요한 데이터를 삽입 또는 수정합니다.
     * @param refundingDTO : 파머가 거절한 환불 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void refuseRefunding(RefundingDTO refundingDTO) {

        /* 환불내역에 상태를 환불 거절로 수정한다. */
        Refunding refunding = refundingRepo.findById(refundingDTO.getRefundingInfoNo()).get();
        refunding.setRefundingStatus(refundingStatusRepo.findById(3).get());

        Funding funding = fundingRepo.findById(refunding.getFunding().getFundingInfoNo()).get();

        /* 환불이력에 승인 내역을 추가한다. */
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
    }

    /**
     * registObjection : 서포터가 파머에게 거절 된 환불 내역을 플랫폼에 이의신청 등록합니다.
     * @param refundingNo : 서포터가 이의신청한 환불 번호를 전달받습니다.
     *
     * @author 홍성원
     */
    public void registObjection(int refundingNo) {


    }
}







































