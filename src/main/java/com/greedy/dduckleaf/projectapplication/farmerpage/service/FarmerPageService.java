package com.greedy.dduckleaf.projectapplication.farmerpage.service;

import com.greedy.dduckleaf.projectapplication.dto.RefundPolicyDTO;
import com.greedy.dduckleaf.projectapplication.dto.RewardRegistInfoDTO;
import com.greedy.dduckleaf.projectapplication.entity.RefundPolicy;
import com.greedy.dduckleaf.projectapplication.entity.RewardRegistInfo;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.RefundPolicyForProjectApplicationRepository;
import com.greedy.dduckleaf.projectapplication.projectapplication.repository.RewardRegistInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class: FarmerPageService
 * Comment : 파머 페이지에서 리워드 정보와 반환정책을 조회하는 서비스 클래스 입니다.
 * History
 * 2022/05/08 (박휘림) 처음 작성
 * </pre>
 * @version 1.0.0
 * @author 박휘림
 */
@Service
public class FarmerPageService {

    private final ModelMapper modelMapper;
    private final RefundPolicyForProjectApplicationRepository refundPolicyRepository;
    private final RewardRegistInfoRepository rewardRegistInfoRepository;

    @Autowired
    public FarmerPageService(ModelMapper modelMapper, RefundPolicyForProjectApplicationRepository refundPolicyRepository, RewardRegistInfoRepository rewardRegistInfoRepository) {
        this.modelMapper = modelMapper;
        this.refundPolicyRepository = refundPolicyRepository;
        this.rewardRegistInfoRepository = rewardRegistInfoRepository;
    }

    /**
     * findRefundPolicy: 파머페이지에서 반환 정책을 조회하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @return : 반환 정책 정보
     * @author 박휘림
     */
    public RefundPolicyDTO findRefundPolicy(int projectNo) {

        RefundPolicy refundPolicy = refundPolicyRepository.findByProjectNo(projectNo);

        return modelMapper.map(refundPolicy, RefundPolicyDTO.class);
    }

    /**
     * findRewardInfo: 파머페이지에서 리워드 정보를 조회하는 메소드입니다.
     * @param projectNo: 프로젝트 번호
     * @author 박휘림
     */
    public RewardRegistInfoDTO findRewardInfo(int projectNo) {

        RewardRegistInfo reward = rewardRegistInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(reward, RewardRegistInfoDTO.class);
    }

}
