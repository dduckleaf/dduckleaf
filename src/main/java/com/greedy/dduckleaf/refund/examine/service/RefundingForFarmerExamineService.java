package com.greedy.dduckleaf.refund.examine.service;

import com.greedy.dduckleaf.refund.examine.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.examine.repository.FundingForRefundingFarmerExamineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    public RefundingForFarmerExamineService(ModelMapper mapper, FundingForRefundingFarmerExamineRepository fundingRepo) {
        this.mapper = mapper;
        this.fundingRepo = fundingRepo;
    }

    /**
     * confirmRefunding : 파머가 환불 승인 시 필요한 데이터를 삽입 또는 수정합니다.
     * @param refunding : 파머가 승인한 환불 정보를 전달받습니다.
     *
     * @author 홍성원
     */
    @Transactional
    public void confirmRefunding(RefundingDTO refunding) {
        /* 펀딩 신청내역에 펀딩 취소여부를 Y로 변경한다. */

        /* 환불내역에 상태를 환불 승인으로 변경 후 환불 종료일을 현재시간으로 수정한다. */

        /* 환불이력에 승인 내역을 추가한다. */

        /* 발송내역에 해당 펀딩 정보를 삭제한다. */

    }
}







































