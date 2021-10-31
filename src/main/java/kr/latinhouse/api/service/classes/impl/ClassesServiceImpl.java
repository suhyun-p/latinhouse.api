package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.classes.ClassContactInfo;
import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.repository.classes.ClassesRepository;
import kr.latinhouse.api.repository.classes.dto.ClassContact;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.service.classes.ClassesService;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        classesRepository.findAll().stream().forEach(classMain -> {
            ClassInfo classInfo = new ClassInfo();
            classInfo.update(classMain);
            classInfo.setContactList(this.contactList(classMain));

            classesList.add(classInfo);
        });
        return classesList.isEmpty() ? null : classesList;
    }

    public ClassInfo classes(long classNo) {
        ClassInfo classInfo = new ClassInfo();
        classesRepository.findById(classNo).ifPresent(classMain -> {
            classInfo.update(classMain);
            classInfo.setContactList(this.contactList(classMain));
        });
        return classInfo.equals(new ClassInfo()) ? null : classInfo;
    }

    private List<ClassContactInfo> contactList(ClassMain classMain) {
        List<ClassContactInfo> classContactInfoList = new ArrayList<>();
        for(ClassContact classContact : classMain.getClassContactList()) {
            classContactInfoList.add(this.convertTo(classContact));
        }
        return classContactInfoList.isEmpty() ? null : classContactInfoList;
    }

    private ClassContactInfo convertTo(ClassContact t) {
        ClassContactInfo classContactInfo = new ClassContactInfo();
        if(t.getMemberNo() != null && t.getContactType() != null) {
            Optional.ofNullable(membersService.members(t.getMemberNo())).ifPresent(memberInfo -> {
                Optional.ofNullable(memberInfo.getContactList()).ifPresent(memberContactInfo -> {
                    memberContactInfo.stream()
                            .filter(contactInfo -> contactInfo.getContactType().equals(t.getContactType()))
                            .findFirst()
                            .ifPresent(contact -> {
                                classContactInfo.setNickname(memberInfo.getNickname());
                                classContactInfo.setContactType(t.getContactType());
                                classContactInfo.setContact(contact.getContact());
                            });
                });
            });
        }
        else {
            classContactInfo.setContact(t.getContact());
        }

        return classContactInfo.equals(new ClassContactInfo()) ? null : classContactInfo;
    }
}
