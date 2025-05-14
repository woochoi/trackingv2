package com.member.tracking.controller.test;

import com.member.tracking.model.entity.Member;
import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.service.MemberService;
import com.member.tracking.service.MemberSigninLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberTestController {
    private final MemberService service;

    private final MemberSigninLogService memberSigninLogService;

    @GetMapping("signin-log-list")
    public void viewSigninLogs() {
        List<MemberSigninLog> logs = memberSigninLogService.getSigninLogs();

        logs.stream()
                .forEach(log1 -> log.info(String.valueOf(log1)));



    }


    @PostMapping
    public Member create(@RequestBody Member member) {
        return service.create(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable String id) {
        return service.getById(id);
    }

}
