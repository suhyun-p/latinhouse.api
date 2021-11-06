package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassSummary {
    private long classNo;
    private String title;
    private String genre;
    private String region;
    private String instructorNickname1;
    private String instructorNickname2;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private BigDecimal price;

    public ClassSummary(ClassInfo info) {
        this.setClassNo(info.getClassNo());
        this.setTitle(info.getTitle());
        this.setGenre(info.getGenre());
        this.setRegion(info.getRegion());
        this.setInstructorNickname1(info.getInstructorNickname1());
        this.setInstructorNickname2(info.getInstructorNickname2());
        this.setStartDate(info.getStartDate());
        this.setEndDate(info.getEndDate());
        this.setStartTime(info.getStartTime());
        this.setEndTime(info.getEndTime());
        this.setPrice(info.getPrice());
    }
}
