package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import kr.latinhouse.api.repository.classes.dto.ClassDiscount;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.repository.classes.dto.ClassNotice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
    private String startDate;
    private String endDate;
    private String dateDesc;
    private String startTime;
    private String endTime;
    private String timeDesc;
    private String location;
    private BigDecimal price;
    private String account;
    private List<ClassDiscountInfo> discountList;
    private List<ClassContactInfo> contactList;
    private List<ClassNoticeInfo> noticeList;
}
