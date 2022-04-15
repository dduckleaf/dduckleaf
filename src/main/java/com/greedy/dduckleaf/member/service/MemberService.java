package com.greedy.dduckleaf.member.service;

import com.greedy.dduckleaf.member.dto.MemberDTO;
import com.greedy.dduckleaf.member.entity.Member;
import com.greedy.dduckleaf.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(ModelMapper modelMapper, MemberRepository memberRepository) {
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registMember(MemberDTO member) {
        memberRepository.save(modelMapper.map(member, Member.class));
    }
}
