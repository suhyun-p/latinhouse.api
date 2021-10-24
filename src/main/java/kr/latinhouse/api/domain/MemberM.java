package kr.latinhouse.api.domain;

import kr.latinhouse.api.repository.members.dto.MemberMain;
import lombok.Data;

@Data
public class MemberM {
    private long memberNo;
    private String nickname;
    private String sex;
    private Boolean isInstructor;

    public MemberM(MemberMain t) {
        this.setMemberNo(t.getMemberNo());
        this.setNickname(t.getNickname());
        this.setSex(t.getSex());
        this.setIsInstructor(t.getIsInstructor());
    }
}
