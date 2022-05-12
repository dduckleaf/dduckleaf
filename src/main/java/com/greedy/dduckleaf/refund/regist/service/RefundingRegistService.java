package com.greedy.dduckleaf.refund.regist.service;

import com.greedy.dduckleaf.refund.regist.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.regist.entity.Funding;
import com.greedy.dduckleaf.refund.regist.entity.Project;
import com.greedy.dduckleaf.refund.regist.entity.Refunding;
import com.greedy.dduckleaf.refund.regist.entity.RefundingHistory;
import com.greedy.dduckleaf.refund.regist.repository.FundingForRefundingRegistRepository;
import com.greedy.dduckleaf.refund.regist.repository.ProjectForRefundingRegistRepository;
import com.greedy.dduckleaf.refund.regist.repository.RefundingForRegistRepository;
import com.greedy.dduckleaf.refund.regist.repository.RefundingHistoryForRefundRegistRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : RefundingRegistService
 * Comment : 환불 등록
 *
 * History
 * 2022-05-03 홍성원
 * </pre>
 *
 * @author 홍성원
 * @version 1.0.0
 */
@Service
public class RefundingRegistService {
    private final FundingForRefundingRegistRepository fundingRepo;
    private final RefundingForRegistRepository refundingRepo;
    private final ProjectForRefundingRegistRepository projectRepo;
    private final RefundingHistoryForRefundRegistRepository historyRepo;

    public RefundingRegistService(FundingForRefundingRegistRepository fundingRepo, RefundingForRegistRepository refundingRepo, ProjectForRefundingRegistRepository projectRepo, RefundingHistoryForRefundRegistRepository historyRepo) {
        this.fundingRepo = fundingRepo;
        this.refundingRepo = refundingRepo;
        this.projectRepo = projectRepo;
        this.historyRepo = historyRepo;

    }
    /**
     * registRefunding : 환불정보를 등록합니다
     * @param refundingInfo : 등록 할 환불 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void registRefunding(RefundingDTO refundingInfo) {


        Refunding refunding = new Refunding();
        /* 환불 번호로 환불 정보를 조회합니다. */
        Funding fundingInfo = fundingRepo.findById(refundingInfo.getFundingInfoNo()).get();
        String date = getDateAndTime();

        /* 전달받은 환불 정보를 엔티티에 옮겨줍니다. */
        refunding.setRefundingDate(date);
        refunding.setRefundingCategoryNo(refundingInfo.getRefundingCategoryNo());
        refunding.setRefundingReason(refundingInfo.getRefundingReason());
        refunding.setRefundingStatusNo(1);
        refunding.setProjectNo(fundingInfo.getProjectNo());
        refunding.setBankNo(refundingInfo.getBankNo());
        refunding.setRefundingAccount(fundingInfo.getRefundAccount());
        refunding.setRefundingMemberName(fundingInfo.getRefundName());
        refunding.setMemberNo(fundingInfo.getMemberNo());
        refunding.setFundingInfoNo(refundingInfo.getFundingInfoNo());

        /* 환불 정보를 DB에 삽입합니다.*/
        refundingRepo.save(refunding);

        /* 등록한 환불 번호를 조회 후 환불 이력 정보를 등록합니다. */
        refunding = refundingRepo.findLatest();
        Project project = projectRepo.findById(refunding.getProjectNo()).get();

        RefundingHistory history = new RefundingHistory();
        history.setRefundingHistoryDate(date);
        history.setRefundingStatus(1);
        history.setHistoryCategory("신청");
        history.setRefundingAmount(fundingInfo.getFundingAmount());
        history.setRefundingHistoryCategory("환불신청");
        history.setRefundingInfoNo(refunding.getRefundingInfoNo());
        history.setRefundingMemberNo(project.getFarmer().getMemberNo());

        historyRepo.save(history);
    }
}