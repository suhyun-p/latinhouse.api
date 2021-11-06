package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.classes.*;
import kr.latinhouse.api.domain.memers.MemberContactInfo;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.ClassesRepository;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import kr.latinhouse.api.repository.classes.dto.ClassDiscount;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import kr.latinhouse.api.service.classes.ClassesService;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;
    private final MembersService membersService;

    public List<ClassInfo> classes() {
        List<ClassInfo> classesList = new ArrayList<>();
        for(ClassMain classMain : classesRepository.findAll()) {
            classesList.add(this.convertTo(classMain));
        }
        return classesList.isEmpty() ? null : classesList;
    }

    public ClassInfo classes(long classNo) {
        ClassInfo classInfo = new ClassInfo();
        if(classesRepository.findById(classNo).isPresent()) {
            classInfo = this.convertTo(classesRepository.findById(classNo).get());
        }
        return classInfo.equals(new ClassInfo()) ? null : classInfo;
    }

    private ClassInfo convertTo(ClassMain t) {

        ClassInfo classInfo = ClassInfo.builder()
                .classNo(t.getClassNo())
                .title(t.getTitle())
                .status(t.getStatus())
                .genre(t.getGenre())
                .region(t.getRegion())
                .instructorNo1(t.getInstructor1().getMemberNo())
                .instructorNickname1(t.getInstructor1().getNickname())
                .instructorNo2(Optional.ofNullable(t.getInstructor2()).map(MemberMain::getMemberNo).orElse(null))
                .instructorNickname2(Optional.ofNullable(t.getInstructor2()).map(MemberMain::getNickname).orElse(null))
                .startDate(new SimpleDateFormat("MM/dd").format(t.getStartDate()))
                .endDate(new SimpleDateFormat("MM/dd").format(t.getEndDate()))
                .dateDesc(t.getDateDesc())
                .startTime(t.getStartTime())
                .endTime(t.getEndTime())
                .timeDesc(t.getTimeDesc())
                .location(t.getLocation())
                .price(t.getPrice())
                .account(t.getAcount())
                .build();

        List<ClassDiscountInfo> discountList = new ArrayList<>();
        for(ClassDiscount d : t.getClassDiscountList()) {
            ClassDiscountInfo classDiscountInfo = ClassDiscountInfo.builder()
                    .type(d.getDiscountType())
                    .text(d.getDiscountText())
                    .amount(d.getDiscountAmount())
                    .build();

            switch (d.getDiscountType()) {
                case "E":
                    classDiscountInfo.setDateCondition(d.getDiscountDateCondition());
                    break;
                case "S":
                    List<DiscountClassCondition> classConditionList = new ArrayList<>();
                    for(String classNo : d.getDiscountClassCondition().split(",")) {
                        classConditionList.add(DiscountClassCondition.builder()
                                .classNo(Long.parseLong(classNo))
                                .classTitle(classesRepository.findById(Long.parseLong(classNo)).get().getTitle())
                                .build());
                    }
                    classDiscountInfo.setClassCondition(classConditionList);
                    break;
            }

            discountList.add(classDiscountInfo);
        }
        classInfo.setDiscountList(discountList.isEmpty() ? null : discountList);

        List<ClassContactInfo> contactList = new ArrayList<>();
        for(ClassContact contact : t.getClassContactList()) {
            if(contact.getMemberNo() != null) {
                MemberInfo member = membersService.members(contact.getMemberNo());
                MemberContactInfo memberContact = member.getContactList().stream()
                        .filter(x -> x.getContactType().equals(contact.getContactType()))
                        .findFirst()
                        .orElse(null);

                contactList.add(ClassContactInfo.builder()
                        .nickname(member.getNickname())
                        .contactType(contact.getContactType())
                        .contact(Optional.ofNullable(memberContact)
                                .map(MemberContactInfo::getContact)
                                .orElse(null))
                        .build());
            }
            else {
                contactList.add(ClassContactInfo.builder()
                        .contactType(contact.getContactType())
                        .contact(contact.getContact())
                        .build());
            }
        }
        classInfo.setContactList(contactList.isEmpty() ? null : contactList);

        Optional.ofNullable(t.getClassNoticeList()).ifPresent(noticeList -> {
            classInfo.setNoticeList(noticeList.stream()
                    .map(ClassNoticeInfo::new)
                    .collect(Collectors.toList()));
        });

        return classInfo;
    }
}
