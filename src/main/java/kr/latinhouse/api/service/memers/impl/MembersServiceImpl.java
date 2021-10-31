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
        List<MemberInfo> memberInfos = new ArrayList<>();
        membersRepository.findAll().stream().forEach(memberMain -> {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.update(memberMain);
            memberInfos.add(memberInfo);
        });
        return memberInfos.isEmpty() ? null : memberInfos;
    }

    public MemberInfo members(long memberNo) {
        MemberInfo memberInfo = new MemberInfo();
        membersRepository.findById(memberNo).ifPresent(memberMain -> {
            memberInfo.update(memberMain);
        });
        return memberInfo.equals(new MemberInfo()) ? null : memberInfo;
    }
}
