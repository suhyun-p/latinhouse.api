package kr.latinhouse.api.service.memers;

import kr.latinhouse.api.controller.members.dto.MemberRequest;
import kr.latinhouse.api.domain.memers.MemberInfo;

import java.util.List;

public interface MembersService {
    List<MemberInfo> members();
    MemberInfo members(long memberNo);
    long members(MemberRequest req);
}
