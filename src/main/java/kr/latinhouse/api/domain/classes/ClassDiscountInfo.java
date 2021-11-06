package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassDiscountInfo {
    private String type; // E: EarlyBird, C: 커플할인, F: 선착순, S: 타 과목 동시신청 시 할인, M: 멤버 할인
    private String text;
    private Date dateCondition;
    private List<DiscountClassCondition> classCondition;
    private BigDecimal amount;
}
