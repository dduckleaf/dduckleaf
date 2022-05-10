package com.greedy.dduckleaf.authentication.model.service;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.entity.Member;
import com.greedy.dduckleaf.member.entity.ProfileAttachment;
import com.greedy.dduckleaf.member.repository.MemberRepository;
import com.greedy.dduckleaf.member.repository.ProfileAttachmentForMemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final MemberRepository memberRepository;
    private final ProfileAttachmentForMemberRepository profileAttachmentForMemberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationServiceImpl(MemberRepository memberRepository, ProfileAttachmentForMemberRepository profileAttachmentForMemberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.profileAttachmentForMemberRepository = profileAttachmentForMemberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberIdAndWithdrawalStatus(username, "N");

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        ProfileAttachment profileAttachment = profileAttachmentForMemberRepository.findProfileAttachmentByMember_memberNo(member.getMemberNo());

        MemberDTO loginMember = modelMapper.map(member, MemberDTO.class);

        String memberRole = "";

        if(member.getMemberRole() == 1) {
            memberRole = "ROLE_ADMIN";
        } else {
            memberRole = "ROLE_MEMBER";
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(memberRole));

        CustomUser user = new CustomUser(loginMember, authorities);
        user.setProfileThumbnailPath(profileAttachment.getProfileThumbnailPath());

        return user;
    }

    @Override
    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();
        List<String> notMemberPermitList = new ArrayList<>();


        /* 일반회원 권한 */
        /* 일반 멤버만 할 수 있는 url 예)펀딩하기 */
        memberPermitList.add("/member/update");
        memberPermitList.add("/member/logout");
        memberPermitList.add("/member/delete");
        memberPermitList.add("/main/main");

        /* 관리자 권한 */
        /* 관리자만 할 수 있는 url 예)관리자페이지*/
        adminPermitList.add("/admin/list");

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);
        permitListMap.put("notMemberPermitList", notMemberPermitList);

        return permitListMap;
    }
}
