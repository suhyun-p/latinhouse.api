package kr.latinhouse.api.service.memers.impl;

import kr.latinhouse.api.domain.classes.ClassInfo;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.classes.dto.ClassMain;
import kr.latinhouse.api.repository.members.MembersRepository;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    public List<MemberInfo> members() {
        return membersRepository.findAll().stream()
                .map(MemberInfo::new)
                .collect(Collectors.toList());
    }

    public MemberInfo members(long memberNo) {
        MemberInfo memberInfo = new MemberInfo();

        Optional<MemberMain> memberMain = membersRepository.findById(memberNo);
        if(memberMain.isPresent()) memberInfo = this.convertTo(memberMain.get());

        return memberInfo.equals(new ClassInfo()) ? null : memberInfo;
    }

    private MemberInfo convertTo(MemberMain memberMain) {
        return new MemberInfo(memberMain);
    }
}
