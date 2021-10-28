package kr.latinhouse.api.service.classes;

import kr.latinhouse.api.domain.classes.ClassInfo;

import java.util.List;

public interface ClassesService {
    List<ClassInfo> classes();
    ClassInfo classes(long classNo);
}
