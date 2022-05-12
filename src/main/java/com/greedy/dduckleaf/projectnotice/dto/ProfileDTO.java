package com.greedy.dduckleaf.projectnotice.dto;

import com.greedy.dduckleaf.profile.dto.MemberDTO;
import com.greedy.dduckleaf.profile.dto.ProfileAttachmentDTO;

public class ProfileDTO {

    private MemberDTO member;
    private ProfileAttachmentDTO profileAttachment;

    public ProfileDTO() {}

    public ProfileDTO(MemberDTO member, ProfileAttachmentDTO profileAttachment) {
        this.member = member;
        this.profileAttachment = profileAttachment;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public ProfileAttachmentDTO getProfileAttachment() {
        return profileAttachment;
    }

    public void setProfileAttachment(ProfileAttachmentDTO profileAttachment) {
        this.profileAttachment = profileAttachment;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "member=" + member +
                ", profileAttachment=" + profileAttachment +
                '}';
    }
}
