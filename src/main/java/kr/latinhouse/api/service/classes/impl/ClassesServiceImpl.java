package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.classes.ClassContactInfo;
import kr.latinhouse.api.domain.classes.ClassDiscountInfo;
import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.domain.classes.ClassNoticeInfo;
import kr.latinhouse.api.domain.memers.MemberContactInfo;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.ClassesRepository;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import kr.latinhouse.api.repository.classes.dto.ClassDiscount;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.repository.classes.dto.ClassNotice;
import kr.latinhouse.api.service.classes.ClassesService;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClassesServiceImpl implements ClassesService {
    private final ClassesRepository classesRepository;
    private final MembersService membersService;

    public List<ClassInfo> classes() {
        List<ClassInfo> classesList = new ArrayList<>();

        for(ClassMain classMain : classesRepository.findAll())
            classesList.add(this.convertTo(classMain));

        return classesList.isEmpty() ? null : classesList;
    }

    public ClassInfo classes(long classNo) {
        ClassInfo classInfo = new ClassInfo();

        if(classesRepository.findById(classNo).isPresent())
            classInfo = this.convertTo(classesRepository.findById(classNo).get());

        return classInfo.equals(new ClassInfo()) ? null : classInfo;
    }

    private ClassInfo convertTo(ClassMain t) {
        ClassInfo classInfo = new ClassInfo();

        classInfo.setClassNo(t.getClassNo());
        classInfo.setTitle(t.getTitle());
        classInfo.setStatus(t.getStatus());
        classInfo.setGenre(t.getGenre());
        classInfo.setRegion(t.getRegion());
        classInfo.setInstructorNo1(t.getInstructor1().getMemberNo());
        classInfo.setInstructorNickname1(t.getInstructor1().getNickname());
        Optional.ofNullable(t.getInstructor2()).ifPresent(i -> {
            classInfo.setInstructorNo2(i.getMemberNo());
            classInfo.setInstructorNickname2(i.getNickname());
        });
        classInfo.setStartDate(new SimpleDateFormat("MM/dd").format(t.getStartDate()));
        classInfo.setEndDate(new SimpleDateFormat("MM/dd").format(t.getEndDate()));
        classInfo.setDateDesc(t.getDateDesc());
        classInfo.setStartTime(t.getStartTime());
        classInfo.setEndTime(t.getEndTime());
        classInfo.setTimeDesc(t.getTimeDesc());
        classInfo.setLocation(t.getLocation());
        classInfo.setPrice(t.getPrice());
        classInfo.setAccount(t.getAcount());

        List<ClassDiscountInfo> discountList = new ArrayList<>();
        for(ClassDiscount discount : t.getClassDiscountList())
            discountList.add(new ClassDiscountInfo(discount));
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

        List<ClassNoticeInfo> noticeList = new ArrayList<>();
        for(ClassNotice notice : t.getClassNoticeList())
            noticeList.add(new ClassNoticeInfo(notice));
        classInfo.setNoticeList(noticeList.isEmpty() ? null : noticeList);

        return classInfo;
    }
}
