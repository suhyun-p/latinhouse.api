package kr.latinhouse.api.repository.members.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.controller.members.dto.MemberContactRequest;
import kr.latinhouse.api.controller.members.dto.MemberRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
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

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="member_no")
    private List<MemberContact> memberContactList = new ArrayList<>();

    public MemberMain(MemberRequest req) {
        this.nickname = req.getNickname();
        this.sex = req.getSex();
        this.isInstructor = req.getIsInstructor();
    }
}
