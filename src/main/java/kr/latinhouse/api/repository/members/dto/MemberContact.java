package kr.latinhouse.api.repository.members.dto;

import kr.latinhouse.api.controller.members.dto.MemberContactRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member_contact")
public class MemberContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact")
    private String contact;

    public MemberContact(MemberContactRequest req) {
        this.contactType = req.getContactType();
        this.contact = req.getContact();
    }
}
