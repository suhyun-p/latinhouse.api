package kr.latinhouse.api.service.impl;

import kr.latinhouse.api.domain.MemberM;
import kr.latinhouse.api.repository.member.MemberRepository;
import kr.latinhouse.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public List<MemberM> members() {
        return memberRepository.findAll().stream()
                .map(MemberM::new)
                .collect(Collectors.toList());
    }
}
