package kr.latinhouse.api.controller.members.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.members.dto.MemberContact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRequest {
    private String nickname;
    private String sex;
    private Boolean isInstructor;
    private List<MemberContactRequest> contactList;
}
