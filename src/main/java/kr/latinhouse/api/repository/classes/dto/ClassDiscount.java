package kr.latinhouse.api.repository.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "class_discount")
public class ClassDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "class_no")
    private Long classNo;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_condition")
    private String discountCondition;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;
}
