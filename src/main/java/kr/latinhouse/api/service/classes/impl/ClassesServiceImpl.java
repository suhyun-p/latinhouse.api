package kr.latinhouse.api.service.classes.impl;

import kr.latinhouse.api.domain.ClassM;
import kr.latinhouse.api.domain.MemberM;
import kr.latinhouse.api.repository.classes.ClassesRepository;
import kr.latinhouse.api.repository.members.MembersRepository;
import kr.latinhouse.api.service.classes.ClassesService;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClassesServiceImpl implements ClassesService {
    private final ClassesRepository classesRepository;

    public List<ClassM> classes() {
        return classesRepository.findAll().stream()
                .map(ClassM::new)
                .collect(Collectors.toList());
    }
}
