package kr.latinhouse.api.controller;

import kr.latinhouse.api.domain.MemberM;
import kr.latinhouse.api.service.memers.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MembersController {

    @Autowired
    MembersService membersService;

    @GetMapping("/members")
    public List<MemberM> members() { return membersService.members(); }
}
