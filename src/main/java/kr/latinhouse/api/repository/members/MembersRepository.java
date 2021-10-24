package kr.latinhouse.api.repository.members;

import kr.latinhouse.api.repository.members.dto.MemberMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<MemberMain, Long> {
}
