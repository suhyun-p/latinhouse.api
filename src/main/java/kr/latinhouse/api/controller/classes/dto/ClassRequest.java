package kr.latinhouse.api.controller.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.domain.classes.ClassContactInfo;
import kr.latinhouse.api.domain.classes.ClassDiscountInfo;
import kr.latinhouse.api.domain.classes.ClassNoticeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassRequest {
    private String title;
    private String status;
    private String genre;
    private String region;
    private Long instructorNo1;
    private Long instructorNo2;
    private Date startDate;
    private Date endDate;
    private String dateDesc;
    private String startTime;
    private String endTime;
    private String timeDesc;
    private String location;
    private BigDecimal price;
    private String account;
    private List<ClassDiscountRequest> discountList;
    private List<ClassContactRequest> contactList;
    private List<ClassNoticeRequest> noticeList;
}
