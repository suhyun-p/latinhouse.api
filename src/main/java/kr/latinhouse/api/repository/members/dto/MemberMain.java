package kr.latinhouse.api.repository.members.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "is_instructor")
    private Boolean isInstructor;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="member_no")
    private List<MemberContact> memberContactList;
}
