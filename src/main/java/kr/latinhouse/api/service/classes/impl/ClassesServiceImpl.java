package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.ClassesRepository;
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

        for(ClassMain classMain : classesRepository.findAll()) {
            classesList.add(this.convertTo(classMain));
        }

        return classesList.isEmpty() ? null : classesList;
    }

    public ClassInfo classes(long classNo) {
        ClassInfo classInfo = new ClassInfo();

        Optional<ClassMain> classMain = classesRepository.findById(classNo);
        if(classMain.isPresent()) classInfo = this.convertTo(classMain.get());

        return classInfo.equals(new ClassInfo()) ? null : classInfo;
    }

    private ClassInfo convertTo(ClassMain classMain) {
        MemberInfo instructor1 = membersService.members(classMain.getInstructorNo1());
        MemberInfo instructor2 = null;
        if(Optional.ofNullable(classMain.getInstructorNo2()).isPresent()) {
            instructor2 = membersService.members(classMain.getInstructorNo2());
        }

        return new ClassInfo(classMain, instructor1, instructor2);
    }
}
