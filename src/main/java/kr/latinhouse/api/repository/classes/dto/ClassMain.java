package kr.latinhouse.api.repository.classes.dto;

import kr.latinhouse.api.controller.classes.dto.ClassRequest;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Column(name = "class_image")
    private String classImage;

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

    @Column(name = "account")
    private String account;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="class_no")
    private List<ClassDiscount> classDiscountList = new ArrayList<>();

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="class_no")
    private List<ClassNotice> classNoticeList = new ArrayList<>();

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="class_no")
    private List<ClassContact> classContactList = new ArrayList<>();

    public ClassMain(ClassRequest req, MemberMain instructor1, MemberMain instructor2) {
        this.title = req.getTitle();
        this.status = req.getStatus();
        this.genre = req.getGenre();
        this.region = req.getRegion();
        this.instructor1 = instructor1;
        this.instructor2 = instructor2;
        this.startDate = req.getStartDate();
        this.endDate = req.getEndDate();
        this.dateDesc = req.getDateDesc();
        this.startTime = req.getStartTime();
        this.endTime = req.getEndTime();
        this.timeDesc = req.getTimeDesc();
        this.location = req.getLocation();
        this.price = req.getPrice();
        this.account = req.getAccount();
    }
}
