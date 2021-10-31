package kr.latinhouse.api.repository.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "class_main")
public class ClassMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_no", nullable = false)
    private Long classNo;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "genre")
    private String genre;

    @Column(name = "region")
    private String region;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no_1")
    private MemberMain instructor1;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_no_2")
    private MemberMain instructor2;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "date_desc")
    private String dateDesc;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "time_desc")
    private String timeDesc;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="class_no")
    private List<ClassDiscount> classDiscountList;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="class_no")
    private List<ClassNotice> classNoticeList;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="class_no")
    private List<ClassContact> classContactList;
}
