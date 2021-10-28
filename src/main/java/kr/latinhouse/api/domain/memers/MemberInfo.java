package kr.latinhouse.api.domain.memers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberInfo {
    private long memberNo;
    private String nickname;
    private String sex;
    private Boolean isInstructor;

    public MemberInfo(MemberMain t) {
        this.setMemberNo(t.getMemberNo());
        this.setNickname(t.getNickname());
        this.setSex(t.getSex());
        this.setIsInstructor(t.getIsInstructor());
    }

    public void convertTo(MemberMain t) {
        this.setMemberNo(t.getMemberNo());
        this.setNickname(t.getNickname());
        this.setSex(t.getSex());
        this.setIsInstructor(t.getIsInstructor());
    }
}
