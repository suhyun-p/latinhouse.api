package kr.latinhouse.api.domain.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private String location;
    private BigDecimal price;
    private List<ClassScheduleInfo> scheduleList;
    private List<ClassDiscountInfo> discountList;
    private List<ClassContactInfo> contactList;
    private List<ClassNoticeInfo> noticeList;

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

        List<ClassScheduleInfo> scheduleList = new ArrayList<>();
        for(ClassSchedule schedule : t.getClassScheduleList())
            scheduleList.add(new ClassScheduleInfo(schedule));
        this.setScheduleList(scheduleList.isEmpty() ? null : scheduleList);

        List<ClassDiscountInfo> discountList = new ArrayList<>();
        for(ClassDiscount discount : t.getClassDiscountList())
            discountList.add(new ClassDiscountInfo(discount));
        this.setDiscountList(discountList.isEmpty() ? null : discountList);

        List<ClassContactInfo> contactList = new ArrayList<>();
        for(ClassContact contact : t.getClassContactList())
            contactList.add(new ClassContactInfo(contact));
        this.setContactList(contactList.isEmpty() ? null : contactList);

        List<ClassNoticeInfo> noticeList = new ArrayList<>();
        for(ClassNotice notice : t.getClassNoticeList())
            noticeList.add(new ClassNoticeInfo(notice));
        this.setNoticeList(noticeList.isEmpty() ? null : noticeList);
    }
}
