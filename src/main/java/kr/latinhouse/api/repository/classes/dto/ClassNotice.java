package kr.latinhouse.api.repository.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.controller.classes.dto.ClassNoticeRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "class_notice")
public class ClassNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "class_no")
    private Long classNo;

    @Column(name = "notice_type")
    private String noticeType;

    @Column(name = "notice")
    private String notice;

    public ClassNotice(ClassNoticeRequest req) {
        this.noticeType = req.getNoticeType();
        this.notice = req.getNotice();
    }
}
