package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassScheduleInfo {
    private String date;
    private String startTime;
    private String endTime;

    public ClassScheduleInfo(ClassSchedule t) {
        this.setDate(new SimpleDateFormat("MM/dd").format(t.getStartDate()));
        this.setStartTime(new SimpleDateFormat("HH:mm").format(t.getStartDate()));
        this.setEndTime(new SimpleDateFormat("HH:mm").format(t.getEndDate()));
    }
}
