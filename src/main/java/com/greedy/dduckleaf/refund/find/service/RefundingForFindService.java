package com.greedy.dduckleaf.refund.find.service;

import com.greedy.dduckleaf.refund.find.dto.RefundingDTO;
import com.greedy.dduckleaf.refund.find.entity.Refunding;
import com.greedy.dduckleaf.refund.find.repository.RefundingForFindRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    private final ModelMapper mapper;

    public RefundingForFindService(RefundingForFindRepository refundingRepo, ModelMapper mapper) {
        this.refundingRepo = refundingRepo;
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

}






















