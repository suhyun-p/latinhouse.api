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
    private String discountType;
    private String discountCondition;
    private BigDecimal discountAmount;

    public ClassDiscountInfo(ClassDiscount t) {
        this.setDiscountType(t.getDiscountType());
        this.setDiscountCondition(t.getDiscountCondition());
        this.setDiscountAmount(t.getDiscountAmount());
    }
}
