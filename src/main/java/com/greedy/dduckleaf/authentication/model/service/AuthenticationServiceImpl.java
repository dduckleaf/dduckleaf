package com.greedy.dduckleaf.authentication.model.service;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.entity.Member;
import com.greedy.dduckleaf.member.entity.PermitByUrl;
import com.greedy.dduckleaf.member.entity.ProfileAttachment;
import com.greedy.dduckleaf.member.repository.MemberRepository;
import com.greedy.dduckleaf.member.repository.PermitByUrlForMemberRepository;
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
    private final PermitByUrlForMemberRepository permitByUrlForMemberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationServiceImpl(MemberRepository memberRepository, ProfileAttachmentForMemberRepository profileAttachmentForMemberRepository, PermitByUrlForMemberRepository permitByUrlForMemberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.profileAttachmentForMemberRepository = profileAttachmentForMemberRepository;
        this.permitByUrlForMemberRepository = permitByUrlForMemberRepository;
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

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getMemberCategory().getMemberRoleName()));

        CustomUser user = new CustomUser(loginMember, authorities);
        user.setProfileThumbnailPath(profileAttachment.getProfileThumbnailPath());

        return user;
    }

    @Override
    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();

        List<PermitByUrl> adminPermitByUrlList = permitByUrlForMemberRepository.findByMemberRole(1);
        List<PermitByUrl> memberPermitByUrlList = permitByUrlForMemberRepository.findByMemberRole(2);

        for(int i = 0; i < adminPermitByUrlList.size(); i++) {
            adminPermitList.add(adminPermitByUrlList.get(i).getPermitByUrl());
        }

        for(int i = 0; i < memberPermitByUrlList.size(); i++) {
            memberPermitList.add(memberPermitByUrlList.get(i).getPermitByUrl());
        }

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);

        return permitListMap;
    }
}
