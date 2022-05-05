package com.greedy.dduckleaf.myfunding.service;

import com.greedy.dduckleaf.email.EmailSender;
import com.greedy.dduckleaf.myfunding.dto.MyFundingDTO;
import com.greedy.dduckleaf.myfunding.entity.FundingInfo;
import com.greedy.dduckleaf.myfunding.entity.MockFundJoinHistory;
import com.greedy.dduckleaf.myfunding.entity.TicketChangeHistory;
import com.greedy.dduckleaf.myfunding.repository.FundingInfoForMyFundingRepository;
import com.greedy.dduckleaf.myfunding.repository.MockFundJoinHistoryForMyFundingRepository;
import com.greedy.dduckleaf.myfunding.repository.TicketChangeHistoryForMyFundingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : MyFundingService
 * Comment : 마이펀딩
 * History
 * 2022/04/28 (박상범) 처음 작성 / 펀딩 횟수, 모의 펀딩 횟수, 티켓 갯수를 조회 관련 메소드 추가
 * </pre>
 * @version 1.0.1
 * @author 박상범
 */
@Service
public class MyFundingService {

    private final FundingInfoForMyFundingRepository fundingInfoForMyFundingRepository;
    private final MockFundJoinHistoryForMyFundingRepository mockFundJoinHistoryForMyFundingRepository;
    private final TicketChangeHistoryForMyFundingRepository ticketChangeHistoryForMyFundingRepository;

    @Autowired
    public MyFundingService(FundingInfoForMyFundingRepository fundingInfoForMyFundingRepository, MockFundJoinHistoryForMyFundingRepository mockFundJoinHistoryForMyFundingRepository, TicketChangeHistoryForMyFundingRepository ticketChangeHistoryForMyFundingRepository) {
        this.fundingInfoForMyFundingRepository = fundingInfoForMyFundingRepository;
        this.mockFundJoinHistoryForMyFundingRepository = mockFundJoinHistoryForMyFundingRepository;
        this.ticketChangeHistoryForMyFundingRepository = ticketChangeHistoryForMyFundingRepository;
    }

    /**
     * findMyFundingByMemberNo: 회원 번호를 통해 회원의 펀딩 횟수, 모의펀딩 횟수, 티켓 갯수를 조회합니다.
     * @param memberNo: 로그인된 회원의 번호
     * @return 펀딩 횟수, 모의펀딩 횟수, 티켓 갯수를 담은 MyFundingDTO 객체를 리턴합니다.
     * @author 박상범
     */
    public MyFundingDTO findMyFundingByMemberNo(int memberNo){

        MyFundingDTO myfunding = new MyFundingDTO();

        List<FundingInfo> fundingInfoList = fundingInfoForMyFundingRepository.findFundingByMemberNoAndProjectProgressStatus(memberNo);
        List<MockFundJoinHistory> mockFundJoinHistoryList = mockFundJoinHistoryForMyFundingRepository.findByMember_memberNo(memberNo);
        List<TicketChangeHistory> ticketChangeHistoryList = ticketChangeHistoryForMyFundingRepository.findByMember_memberNo(memberNo);

        int ticketAmount = 0;

        for(int i = 0; i < ticketChangeHistoryList.size(); i++) {
            ticketAmount += ticketChangeHistoryList.get(i).getTicketAmount();
        }

        myfunding.setFundingTimes(fundingInfoList.size());
        myfunding.setMockFundingTimes(mockFundJoinHistoryList.size());
        myfunding.setTicketAmount(ticketAmount);

        return myfunding;
    }
}
