package kr.latinhouse.api.service.memers.impl;

import kr.latinhouse.api.controller.members.dto.MemberContactRequest;
import kr.latinhouse.api.controller.members.dto.MemberRequest;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.repository.members.MembersRepository;
import kr.latinhouse.api.repository.members.dto.MemberContact;
import kr.latinhouse.api.repository.members.dto.MemberMain;
import kr.latinhouse.api.service.memers.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public long members(MemberRequest req) {
        MemberMain memberMain = new MemberMain(req);
        for(MemberContactRequest memberContact : req.getContactList()) {
            memberMain.getMemberContactList().add(new MemberContact(memberContact));
        }

        return membersRepository.save(memberMain).getMemberNo();
    }
}
