package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.classes.dto.ClassDiscount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassDiscountInfo {
    private String discountType; // E: EarlyBird, C: 커플할인, F: 선착순, S: 타 과목 동시신청 시 할인, M: 멤버 할인
    private String discountCondition;
    private String discountText;
    private BigDecimal discountAmount;

    public ClassDiscountInfo(ClassDiscount t) {
        this.setDiscountType(t.getDiscountType());
        this.setDiscountCondition(t.getDiscountCondition());
        this.setDiscountAmount(t.getDiscountAmount());
    }
}
