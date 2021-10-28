package kr.latinhouse.api.repository.classes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "instructor_no_1")
    private Long instructorNo1;

    @Column(name = "instructor_no_2")
    private Long instructorNo2;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="class_no")
    private List<ClassSchedule> classScheduleList;

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
