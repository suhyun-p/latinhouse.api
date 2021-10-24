package kr.latinhouse.api.service.memers.impl;

import kr.latinhouse.api.domain.MemberM;
import kr.latinhouse.api.repository.members.MembersRepository;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    public List<MemberM> members() {
        return membersRepository.findAll().stream()
                .map(MemberM::new)
                .collect(Collectors.toList());
    }
}
