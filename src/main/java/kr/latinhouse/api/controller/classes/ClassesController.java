package kr.latinhouse.api.controller.classes;

import kr.latinhouse.api.controller.classes.dto.ClassRequest;
import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.service.classes.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassesController {

    @Autowired
    ClassesService classesService;

    @GetMapping("/classes")
    public List<ClassInfo> classes() {
        return classesService.classes(); }

    @GetMapping("/classes/{classNo}")
    public ClassInfo classes(@PathVariable long classNo) { return classesService.classes(classNo); }

    @PostMapping("/classes")
    public long classes(@RequestBody ClassRequest req) {
        return classesService.classes(req);
    }
}
