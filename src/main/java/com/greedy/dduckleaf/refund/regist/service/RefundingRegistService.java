package com.greedy.dduckleaf.refund.regist.service;

import com.greedy.dduckleaf.refund.regist.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.regist.entity.Funding;
import com.greedy.dduckleaf.refund.regist.entity.Refunding;
import com.greedy.dduckleaf.refund.regist.repository.FundingForRefundingRegistRepository;
import com.greedy.dduckleaf.refund.regist.repository.RefundingForRegistRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : RefundingRegistService
 * Comment :
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

    public RefundingRegistService(FundingForRefundingRegistRepository fundingRepo, RefundingForRegistRepository refundingRepo) {
        this.fundingRepo = fundingRepo;
        this.refundingRepo = refundingRepo;
    }

    @Transactional
    public void registRefunding(RefundingDTO refundingInfo) {
        Refunding refunding = new Refunding();
        Funding fundingInfo = fundingRepo.findById(refundingInfo.getFundingInfoNo()).get();
        refunding.setRefundingDate(getDateAndTime());
        refunding.setRefundingCategoryNo(refunding.getRefundingCategoryNo());
        refunding.setRefundingReason(refundingInfo.getRefundingReason());
        refunding.setRefundingStatus("환불신청");
        refunding.setProjectNo(fundingInfo.getProjectNo());
        refunding.setRefundingAccount(fundingInfo.getRefundAccount());
        refunding.setRefundingMemberName(fundingInfo.getRefundName());
        refunding.setMemberNo(fundingInfo.getMemberNo());
        refunding.setFundingInfoNo(refundingInfo.getFundingInfoNo());

        System.out.println("refunding = " + refunding);
        refundingRepo.save(refunding);
        refunding = refundingRepo.findLatest();
        System.out.println("refunding = " + refunding);
    }
}




































