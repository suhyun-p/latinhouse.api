package kr.latinhouse.api.service.classes;

import kr.latinhouse.api.controller.classes.dto.ClassRequest;
import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.domain.classes.ClassSummary;

import java.text.ParseException;
import java.util.List;

public interface ClassesService {
    List<ClassSummary> classes();
    ClassInfo classes(long classNo);
    long classes(ClassRequest req);
}
