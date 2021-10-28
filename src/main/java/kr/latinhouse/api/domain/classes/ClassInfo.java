package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassInfo {
    private long classNo;
    private String title;
    private String status; // S1: Open, S2: In Progress, S3: Hold, S4: Closed
    private String genre; // S: Salsa, B: Bachata
    private String region; // GN: Gangnam, HD: Hongdae
    private Long instructorNo1;
    private String instructorNickname1;
    private Long instructorNo2;
    private String instructorNickname2;
    private String location;
    private BigDecimal price;

    public ClassInfo(ClassMain t, MemberInfo instructor1, MemberInfo instructor2) {
        this.setClassNo(t.getClassNo());
        this.setTitle(t.getTitle());
        this.setStatus(t.getStatus());
        this.setGenre(t.getGenre());
        this.setRegion(t.getRegion());
        this.setInstructorNo1(instructor1.getMemberNo());
        this.setInstructorNickname1(instructor1.getNickname());
        Optional.ofNullable(instructor2).ifPresent(i -> {
            this.setInstructorNo2(i.getMemberNo());
            this.setInstructorNickname2(i.getNickname());
        });
        this.setLocation(t.getLocation());
        this.setPrice(t.getPrice());
    }
}
