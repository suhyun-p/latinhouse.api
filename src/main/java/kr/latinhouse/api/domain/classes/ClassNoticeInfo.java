package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassNotice;
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
public class ClassNoticeInfo {
    private String noticeType;
    private String notice;

    public ClassNoticeInfo(ClassNotice t) {
        this.setNoticeType(t.getNoticeType());
        this.setNotice(t.getNotice());
    }
}
