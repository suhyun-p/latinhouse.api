package kr.latinhouse.api.domain.memers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import kr.latinhouse.api.repository.members.dto.MemberContact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberContactInfo {
    private String contactType;
    private String contact;

    public MemberContactInfo(MemberContact t) {
        this.setContactType(t.getContactType());
        this.setContact(t.getContact());
    }
}
