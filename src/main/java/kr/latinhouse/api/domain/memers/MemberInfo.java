package kr.latinhouse.api.domain.memers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.members.dto.MemberContact;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<MemberContactInfo> contactList;

    public void update(MemberMain t) {
        this.setMemberNo(t.getMemberNo());
        this.setNickname(t.getNickname());
        this.setSex(t.getSex());
        this.setIsInstructor(t.getIsInstructor());

        List<MemberContactInfo> contactList = new ArrayList<>();
        for(MemberContact contact : t.getMemberContactList())
            contactList.add(new MemberContactInfo(contact));
        this.setContactList(contactList.isEmpty() ? null : contactList);
    }
}
