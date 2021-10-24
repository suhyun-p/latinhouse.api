package kr.latinhouse.api.repository.classes;

import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassMain, Long> {
}
