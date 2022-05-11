package com.greedy.dduckleaf.settlement.calculate.service;

import com.greedy.dduckleaf.settlement.calculate.dto.*;
import com.greedy.dduckleaf.settlement.calculate.entity.*;
import com.greedy.dduckleaf.settlement.calculate.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : SettlementCalculateService
 * Comment : 프로젝트 정산금 게산에 사용되는 트랜젝션 메소드를 작성하였습니다.
 *
 * History
 * 2022-05-05 (장민주) 처음 작성
 * 2022-05-05 (장민주) calculateSettlementForProject 서비스메소드 작성
 * 2022-05-05 (장민주) getFeeApplyRateForProject 내부연산메소드 작성
 * 2022-05-05 (장민주) findPaymentHistoriesForProject 내부연산메소드 작성
 * 2022-05-05 (장민주) findRefundingInfosForProject 내부연산메소드 작성
 * 2022-05-05 (장민주) getRefundingStatusNo 내부연산메소드 작성
 * 2022-05-05 (장민주) findProject 내부연산메소드 작성
 * 2022-05-05 (장민주) findSettlementInfo 서비스메소드 작성
 *
 * 2022-05-06 (장민주) calculateSettlementForProject 리팩토링 -> 내부연산메소드로 변경
 * 2022-05-06 (장민주) registSettlementInfo 서비스메소드 작성
 *
 * 2022-05-08 (장민주) getFeeApplyRateForProject 내부연산 메소드 반환타입 수정
 * 2022-05-08 (장민주) findSettlementInfo => findSettlementInfoPackage 서비스메소드 수정
 * 2022-05-08 (장민주) getSettlementInfo 내부연산 메소드 작성
 * 2022-05-08 (장민주) calculateSettlementForEachPaymentRound 내부연산 메소드 작성
 * 2022-05-08 (장민주) registOrModifySettlementPaymentInfo 서비스메소드 작성
 * 2022-05-08 (장민주) findSettlementInfoPackage 서비스메소드 수정
 *
 * 2022-05-11 (장민주) getSettlementInfo 내부연산 메소드 수정
 * 2022-05-11 (장민주) saveSettlementPaymentHistory 내부연산 메소드 작성
 * 2022-05-11 (장민주) findSettlementInfoPackage 서비스 메소드 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.3
 */
@Service
public class SettlementCalculateService {

    @Autowired
    private final RefundingInfoForSettlementCalculateRepository refundingInfoRepository;
    @Autowired
    private final RefundingStatusForSettlementRepository refundingStatusRepository;
    @Autowired
    private final PaymentHistoryForSettlementCalculateRepository paymentHistoryRepository;
    @Autowired
    private final ProjectApplyFeeInfoForSettlementCalculateRepository projectApplyFeeInfoRepository;
    @Autowired
    private final ProjectForSettlementCalculateRepository projectRepository;
    @Autowired
    private final SettlementInfoForSettlementCalculateRepository settlementInfoRepository;
    @Autowired
    private final SettlementPaymentStandardForSettlementCalculateRepository settlementPaymentStandardRepository;
    @Autowired
    private final SettlementPaymentInfoForCalculateRepository settlementPaymentInfoRepository;
    @Autowired
    private final SettlementPaymentHistoryForCalculateRepository settlementPaymentHistoryRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public SettlementCalculateService(RefundingInfoForSettlementCalculateRepository refundingInfoRepository,
                                      RefundingStatusForSettlementRepository refundingStatusRepository,
                                      PaymentHistoryForSettlementCalculateRepository paymentHistoryRepository,
                                      ProjectApplyFeeInfoForSettlementCalculateRepository projectApplyFeeInfoRepository,
                                      ProjectForSettlementCalculateRepository projectRepository,
                                      SettlementInfoForSettlementCalculateRepository settlementInfoRepository,
                                      SettlementPaymentStandardForSettlementCalculateRepository settlementPaymentStandardRepository,
                                      SettlementPaymentInfoForCalculateRepository settlementPaymentInfoRepository,
                                      SettlementPaymentHistoryForCalculateRepository settlementPaymentHistoryRepository,
                                      ModelMapper modelMapper) {
        this.refundingInfoRepository = refundingInfoRepository;
        this.refundingStatusRepository = refundingStatusRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.projectApplyFeeInfoRepository = projectApplyFeeInfoRepository;
        this.projectRepository = projectRepository;
        this.settlementInfoRepository = settlementInfoRepository;
        this.settlementPaymentStandardRepository = settlementPaymentStandardRepository;
        this.settlementPaymentInfoRepository = settlementPaymentInfoRepository;
        this.settlementPaymentHistoryRepository = settlementPaymentHistoryRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * registSettlementInfo: 계산한 정산정보를 TBL_SETTLEMENT_INFO 테이블에 INSERT 요청하는 메소드입니다.
     *                       프로젝트의 정산정보가 이미 존재하면 해당 행에 대한 UPDATE를 요청합니다.
     * @param projectNo: 프로젝트번호
     * @author 장민주
     */
    @Transactional
    public void registSettlementInfo(int projectNo) {

        /* 해당프로젝트에 대한 정산정보가 존재하는지 확인 */
        SettlementInfo foundSettlementInfo = settlementInfoRepository.findByProject_ProjectNo(projectNo);

        /* 새롭게 등록할 정산정보를 호출한다 */
        SettlementInfo newSettlementInfo = calculateSettlementForProject(projectNo);

        /* 프로젝트에 대한 정산정보가 없는 경우 새로운 행을 insert하고, 존재하는 경우 기존 행을 update한다 */
        if(foundSettlementInfo == null) {
            settlementInfoRepository.save(newSettlementInfo);
        }

        if(foundSettlementInfo != null) {
            foundSettlementInfo.setFundingTotalAmount(newSettlementInfo.getFundingTotalAmount());
            foundSettlementInfo.setDonateAmount(newSettlementInfo.getDonateAmount());
            foundSettlementInfo.setSettlementTotalAmount(newSettlementInfo.getSettlementTotalAmount());
            foundSettlementInfo.setTotalCommissionAmount(newSettlementInfo.getTotalCommissionAmount());
            foundSettlementInfo.setCalculateDate(getDateAndTime());
        }
    }

    /**
     * calculateSettlementForProject: 프로젝트의 정산금을 계산하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 정산정보
     * @author 장민주
     */
    private SettlementInfo calculateSettlementForProject(int projectNo) {

        /* 하나의 프로젝트에 대한 결제이력 조회 */
        List<FundingInfoDTO> fundingInfos = findPaymentHistoriesForProject(projectNo);

        /* 하나의 프로젝트에 대한 환불내역 조회 */
        List<RefundingInfoDTO> refundingInfos = findRefundingInfosForProject(projectNo);

        /* 결제이력에서 펀딩내역_펀딩금을 추출하여 다 더해주어 총펀딩금 구하기 */
        int totalFundingAmount = fundingInfos.stream().mapToInt(FundingInfoDTO::getFundingAmount).sum();

        /* 환불내역에서 펀딩내역_후원금을 추출하여 다 더해주어 총후원금 구하기 */
        int totalDonateAmount = fundingInfos.stream().mapToInt(FundingInfoDTO::getDonateAmount).sum();

        /* 환불내역에서 펀딩금을 추출하여 다 더해주어 총펀딩금에서 제외해야할 펀딩금 구하기 */
        int totalFundingAmountOfRefunding = refundingInfos.stream().mapToInt(RefundingInfoDTO::getFundingAmount).sum();

        /* 환불내역에서 후원금을 추출하여 다 더해주어 총펀딩금에서 제외해야할 후웜금 구하기 */
        int totalDonateAmountOfRefunding = refundingInfos.stream().mapToInt(RefundingInfoDTO::getDonateAmount).sum();

        /* 최종펀딩금액 */
        int fundingTotalAmount = totalFundingAmount - totalFundingAmountOfRefunding;

        /* 최종후원금액 */
        int donateAmount = totalDonateAmount - totalDonateAmountOfRefunding;

        /* 수수료율 조회 */
        int feeApplyRate = getFeeApplyRateForProject(projectNo).getFeePolicy().getFeeApplyRate();
        System.out.println("feeApplyRate = " + feeApplyRate);
        double feeRateConvertedIntoPercentage = ((double) feeApplyRate / (double) 100);

        /* (최종펀딩금액 + 최종후원금액)에 수수료율 곱하어 수수료 게산하기 */
        int totalCommissionAmount = (int) ((fundingTotalAmount + donateAmount) * feeRateConvertedIntoPercentage);

        /* (최종펀딩금액 + 최종후원금액)에서 수수료를 빼 정산금 계산하기 */
        int settlementTotalAmount = (fundingTotalAmount + donateAmount) - totalCommissionAmount;

        /* 계산한 정산정보를 정산정보 테이블에 삽입하기 위해 entity객체에 set한다 */
        SettlementInfo settlementInfo = new SettlementInfo();
        settlementInfo.setProject(findProject(projectNo));
        settlementInfo.setSettlementTotalAmount(settlementTotalAmount);
        settlementInfo.setFundingTotalAmount(fundingTotalAmount);
        settlementInfo.setDonateAmount(donateAmount);
        settlementInfo.setTotalCommissionAmount(totalCommissionAmount);
        settlementInfo.setCalculateDate(getDateAndTime());

        return settlementInfo;
    }

    /**
     * getFeeApplyRateForProject: (내부연산 메소드) 프로젝트에 적용된 수수료율을 구하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 적용 수수료율
     * @author 장민주
     */
    private ProjectApplyFeeInfoDTO getFeeApplyRateForProject(int projectNo) {

        ProjectApplyFeeInfo feeInfo = projectApplyFeeInfoRepository.findByProjectNo(projectNo);

        return modelMapper.map(feeInfo, ProjectApplyFeeInfoDTO.class);
    }

    /**
     * getPaymentHistoriesForProject: (내부연산 메소드) 프로젝트의 결제이력 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 결제이력 목록
     * @author 장민주
     */
    private List<FundingInfoDTO> findPaymentHistoriesForProject(int projectNo) {

        /* 결제가 완료된, 핀딩상태가 Y인 내역을 조회 */
        String paymentResultStatus = "결제완료";
        String fundingStatus = "Y";

        /* 프로젝트의 모든 결제이력 조회 */
        List<PaymentHistory> paymentHistories =
                paymentHistoryRepository.findAllByPaymentResultStatusAndFundingInfo_Project_ProjectNoAndFundingInfo_FundingStatus
                        (paymentResultStatus, projectNo, fundingStatus);

        /* 결제이력 정보 내 펀딩신청내역만 추출하여 List객체에 담는다 */
        List<FundingInfoDTO> fundingInfos = new ArrayList<>();

        paymentHistories.forEach(paymentHistory -> {
            FundingInfo fundingInfo = paymentHistory.getFundingInfo();
            fundingInfos.add(modelMapper.map(fundingInfo, FundingInfoDTO.class));
        });

        return fundingInfos;
    }

    /**
     * findRefundingInfosForProject: (내부연산 메소드) 프로젝트 환불내역 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 환불내역 목록
     * @author 장민주
     */
    private List<RefundingInfoDTO> findRefundingInfosForProject(int projectNo) {

        /* 환불승인번호 조회 */
        int refundingStatusNo = getRefundingStatusNo();

        /* 환불내역조회 */
        List<RefundingInfoDTO> refundingInfos = new ArrayList<>();

        /* 조회한 값을 RefundingInfoDTO에 옮겨담기 */
        refundingInfoRepository.findRefundingInfosForSettlement(projectNo, refundingStatusNo).forEach(refundingInfo -> {
            RefundingInfoDTO refundingInfoDTO = new RefundingInfoDTO();

            refundingInfoDTO.setRefundingInfoNo(refundingInfo.getRefundingInfoNo());
            refundingInfoDTO.setRefundingDate(refundingInfo.getRefundingDate());
            refundingInfoDTO.setRefundingStatusNo(refundingInfo.getRefundingStatus().getRefundingStatusNo());
            refundingInfoDTO.setProjectNo(refundingInfo.getProject().getProjectNo());
            refundingInfoDTO.setRefundingEndDate(refundingInfo.getRefundingEndDate());
            refundingInfoDTO.setProjectEndDate(refundingInfo.getProject().getEndDate());
            refundingInfoDTO.setRefundingInfoNo(refundingInfo.getFundingInfo().getFundingInfoNo());
            refundingInfoDTO.setFundingAmount(refundingInfo.getFundingInfo().getFundingAmount());
            refundingInfoDTO.setDonateAmount(refundingInfo.getFundingInfo().getDonateAmount());

            refundingInfos.add(refundingInfoDTO);
        });

        return refundingInfos;
    }

    /**
     * getRefundingStatusNo: (내부연산 메소드) 환불승인번호를 조회를 요청하는 메소드입니다.
     * @return 환불승인번호
     * @author 장민주
     */
    private int getRefundingStatusNo() {

        String refundingStatusName = "환불승인";

        RefundingStatus refundingStatus = refundingStatusRepository.findByRefundingStatusName(refundingStatusName);

        /* 환불승인번호만 추출하여 반환한다 */
        int refundingStatusNo = refundingStatus.getRefundingStatusNo();

        return refundingStatusNo;
    }

    /**
     * findProject: (내부연산 메소드) 프로젝트번호로 프로젝트 엔티티 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 엔티티
     * @author 장민주
     */
    private Project findProject(int projectNo) {

        return projectRepository.findById(projectNo);
    }

    /**
     * getSettlementInfo: (내부연산 메소드) 프로젝트 번호로 정산정보 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 프로젝트 정산정보
     * @author 장민주
     */
    private SettlementInfoDTO getSettlementInfo(int projectNo) {

        /* 정산정보가 존재하는지 여부 확인 */
        SettlementInfo foundSettlementInfo = settlementInfoRepository.findByProject_ProjectNo(projectNo);

        Boolean isExist = false;
        if(foundSettlementInfo != null) {
            isExist = true;
        }

        /* 정산정보가 존재하지 않는 경우, 먼저 정산정보를 계산하고 등록한다  */
        if(isExist == false) {
            registSettlementInfo(projectNo);
        }

        return modelMapper.map(settlementInfoRepository.findByProject_ProjectNo(projectNo), SettlementInfoDTO.class);
    }


    /**
     * findSettlementInfo: 프로젝트번호로 종합 정산정보 조회를 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 기본정산정보, 회차별 정산정보 지급(예정)내역, 적용수수료정보
     * @author 장민주
     */
    public SettlementInfoPackage findSettlementInfoPackage(int projectNo) {
        /* 기본정산정보, 회차별 정산정보 지급내역, 적용수수료정보를 담는 DTO 인스턴스 생성 */
        SettlementInfoPackage settlementInfoPackage = new SettlementInfoPackage();

        /* 프로젝트 적용 수수료정책 조회 */
        ProjectApplyFeeInfoDTO feeInfo = getFeeApplyRateForProject(projectNo);
        settlementInfoPackage.setFeeInfo(feeInfo);

        /* 프로젝트 정산정보 조회 */
        SettlementInfoDTO settlementInfo = getSettlementInfo(projectNo);
        settlementInfoPackage.setSettlementInfo(settlementInfo);

        /* 회차별 정산금 지급내역 목록 조회 */
        List<SettlementPaymentInfo> settlementPaymentInfos =
                settlementPaymentInfoRepository.findBySettlementInfo_SettlementInfoNo(settlementInfo.getSettlementInfoNo());

        if(!settlementPaymentInfos.isEmpty()) {
            settlementInfoPackage.setSettlementPaymentInfos(settlementPaymentInfos.stream().map(settlementPaymentInfo ->
                    modelMapper.map(settlementPaymentInfo, SettlementPaymentInfoDTO.class)).collect(Collectors.toList()));
        }

        /* 조회결과가 없으면 회차별 정산금 계산 method를 호출한다 */
        if(settlementPaymentInfos.isEmpty()) {
            List<SettlementPaymentInfo> newSettlementPaymentInfos = calculateSettlementForEachPaymentRound(projectNo);
            /* 계산한 회차별 정산금 지급(예정) 내역 저장 */
            registOrModifySettlementPaymentInfo(projectNo);

            settlementInfoPackage.setSettlementPaymentInfos(newSettlementPaymentInfos.stream().map(settlementPaymentInfo ->
                    modelMapper.map(settlementPaymentInfo, SettlementPaymentInfoDTO.class)).collect(Collectors.toList()));
        }

        return settlementInfoPackage;
    }

    /**
     * calculateSettlementForEachPaymentRound: 회차별 정산금 계산 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @return 회차별 정산금 지급내역 목록
     * @author 장민주
     */
    private List<SettlementPaymentInfo> calculateSettlementForEachPaymentRound(int projectNo) {

        /* 프로젝트 정산정보 조회 */
        SettlementInfoDTO settlementInfo = getSettlementInfo(projectNo);

        /* 정산금지급기준 조회 */
        String standardName = "기본";
        List<SettlementPaymentStandard> settlementPaymentStandards = settlementPaymentStandardRepository.findAllByStandardName(standardName);

        int totalAmount = settlementInfo.getFundingTotalAmount() + settlementInfo.getDonateAmount();

        List<SettlementPaymentInfo> settlementPaymentInfos = new ArrayList<>();
        settlementPaymentStandards.forEach(settlementPaymentStandard -> {
            /* 회차별 정산금 지급비율 */
            double rate = settlementPaymentStandard.getSettlementPaymentStandardPK()
                    .getSettlementPaymentRoundRate().getSettlementPaymentRate();
            /* 총정산금에 회차별 정산금 지급비율을 곱해 회차별 지급급액을 구한다 */
            int paymentAmount = (int) ((double) totalAmount * rate);

            SettlementPaymentInfo settlementPaymentInfo = new SettlementPaymentInfo();
            settlementPaymentInfo.setSettlementInfo(modelMapper.map(settlementInfo, SettlementInfo.class));
            settlementPaymentInfo.setSettlementPaymentStandard(modelMapper.map(settlementPaymentStandard, SettlementPaymentStandard.class));
            settlementPaymentInfo.setSettlementPaymentAmount(paymentAmount);
            settlementPaymentInfo.setFarmerSettlementCheckStatus("N");
            settlementPaymentInfo.setSettlementPaymentStatus("지급예정");

            settlementPaymentInfos.add(settlementPaymentInfo);
        });

        return settlementPaymentInfos;
    }

    /**
     * registOrModifySettlementPaymentInfo: 회차별 정산금 지급내역 정보를 데이터베이스에 등록 또는 수정을 요청하는 메소드입니다.
     * @param projectNo: 프로젝트번호
     * @author 장민주
     */
    @Transactional
    public void registOrModifySettlementPaymentInfo(int projectNo) {

        /* 프로젝트 정산정보 조회 */
        SettlementInfoDTO settlementInfo = getSettlementInfo(projectNo);

        /* 회차별 정산금 지급금액 다시 계산 */
        List<SettlementPaymentInfo> newSettlementPaymentInfos = calculateSettlementForEachPaymentRound(projectNo);
        System.out.println("newSettlementPaymentInfos = " + newSettlementPaymentInfos);

        /* 정산정보에 대한 회차별 정산금 지급내역 데이터가 존재하는지 확인 */
        List<SettlementPaymentInfo> foundSettlementPaymentInfos =
                settlementPaymentInfoRepository.findBySettlementInfo_SettlementInfoNo(settlementInfo.getSettlementInfoNo());

        /* 회차별 정산금 지급내역이 존재하지 않는 경우, 회차별 정산금액을 계산하여 새로운 row를 insert */
        if(foundSettlementPaymentInfos.isEmpty()) {
            settlementPaymentInfoRepository.saveAll(newSettlementPaymentInfos);
        }

        /* 회차별 정산금 지급내역이 존재하는 경우, 기존 row를 update */
        if(!foundSettlementPaymentInfos.isEmpty()) {
            for(int i = 0; i < foundSettlementPaymentInfos.size(); i++) {
                foundSettlementPaymentInfos.get(i)
                        .setSettlementPaymentAmount(newSettlementPaymentInfos.get(i).getSettlementPaymentAmount());
            }
        }

        /* 정산금 지급내역에 대한 이력 추가 */
        newSettlementPaymentInfos.forEach(settlementPaymentInfo -> {
            saveSettlementPaymentHistory(settlementPaymentInfo);
        });
    }

    /**
     * saveSettlementPaymentHistory: 회차별 정산금 지급내역 테이블 변동에 따른
     *                               회차별 정산금 지급내역 히스토리에 새로운 행을 추가 요청하는 메소드입니다.
     * @param settlementPaymentInfo: 생성된 회차별 정산금 지급내역
     * @author 장민주
     */
    @Transactional
    public void saveSettlementPaymentHistory(SettlementPaymentInfo settlementPaymentInfo) {

        SettlementPaymentHistory settlementPaymentHistory = new SettlementPaymentHistory();
        /* 회차별 정산금 지급내역 생성에 따른 히스토리 데이터 추가 */
        settlementPaymentHistory.setSettlementPaymentInfo(settlementPaymentInfo);
        settlementPaymentHistory.setSettlementPaymentHistoryDate(getDateAndTime());
        settlementPaymentHistory.setSettlementPaymentHistoryCategory("지급금액계산");
        settlementPaymentHistory.setSettlementStatus("확인요청중");

        settlementPaymentHistoryRepository.save(settlementPaymentHistory);
    }
}
