package kr.latinhouse.api.domain;

import kr.latinhouse.api.repository.classes.dto.ClassMain;
import lombok.Data;

@Data
public class ClassM {
    private long classNo;
    private String title;

    public ClassM(ClassMain t) {
        this.setClassNo(t.getClassNo());
        this.setTitle(t.getTitle());
    }

}
