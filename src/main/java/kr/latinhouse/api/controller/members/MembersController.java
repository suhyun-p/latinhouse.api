package kr.latinhouse.api.controller.members;

import kr.latinhouse.api.controller.members.dto.MemberRequest;
import kr.latinhouse.api.domain.memers.MemberInfo;
import kr.latinhouse.api.service.memers.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MembersController {

    @Autowired
    MembersService membersService;

    @GetMapping("/members")
    public List<MemberInfo> members() { return membersService.members(); }

    @GetMapping("/members/{memberNo}")
    public MemberInfo members(@PathVariable long memberNo) { return membersService.members(memberNo); }

    @PostMapping("/members")
    public long members(@RequestBody MemberRequest req) {
        return membersService.members(req);
    }
}
