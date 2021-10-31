package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.ClassesRepository;
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
            classesList.add(classInfo);
        });
        return classesList.isEmpty() ? null : classesList;
    }

    public ClassInfo classes(long classNo) {
        ClassInfo classInfo = new ClassInfo();
        classesRepository.findById(classNo).ifPresent(classMain -> {
            classInfo.update(classMain);
        });
        return classInfo.equals(new ClassInfo()) ? null : classInfo;
    }
}
