package kr.latinhouse.api.controller.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassDiscountRequest {
    private String discountType;
    private String discountText;
    private Date discountDateCondition;
    private String discountClassCondition;
    private BigDecimal discountAmount;
}
