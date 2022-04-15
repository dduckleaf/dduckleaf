package com.greedy.dduckleaf.authentication.model.service;

import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.repository.MemberRepository;
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

    @Autowired
    public AuthenticationServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDTO member = new MemberDTO();

        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getMemberRole()));

        return new CustomUser(member, authorities);
    }

    @Override
    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();

        /* 관리자 권한 */
        adminPermitList.add("/");

        /* 일반회원 권한 */
        memberPermitList.add("/member/update");
        memberPermitList.add("/member/logout");
        memberPermitList.add("/member/delete");

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);

        return permitListMap;
    }
}
