package kr.latinhouse.api.repository.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.controller.classes.dto.ClassContactRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "class_contact")
public class ClassContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "class_no")
    private Long classNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact")
    private String contact;

    public ClassContact(ClassContactRequest req) {
        this.memberNo = Long.parseLong(req.getMemberNo());
        this.contactType = req.getContactType();
        this.contact = req.getContact();
    }
}
