package kr.latinhouse.api.repository.member;

import kr.latinhouse.api.repository.member.dto.MemberMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberMain, Long> {
}
