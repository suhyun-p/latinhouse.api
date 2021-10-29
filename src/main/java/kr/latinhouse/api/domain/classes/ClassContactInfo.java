package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassContactInfo {
    private long memberNo;
    private String contactType;
    private String contact;

    public ClassContactInfo(ClassContact t) {
        this.setMemberNo(t.getMemberNo());
        this.setContactType(t.getContactType());
        this.setContact(t.getContact());
    }
}
