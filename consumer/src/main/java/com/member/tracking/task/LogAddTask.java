package com.member.tracking.task;


import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.model.entity.NonMemberSigninLog;
import com.member.tracking.model.event.MemberSigninEvent;
import com.member.tracking.model.event.NonMemberSigninEvent;
import com.member.tracking.service.MemberSigninLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;


@Component
@RequiredArgsConstructor
public class LogAddTask {

    private final MemberSigninLogService memberSigninLogService;

    // 회원 로그인
    public void processEvent(MemberSigninEvent event) {
        Instant now = Instant.now();
        Instant retention = now.plus(Duration.ofMinutes(3));
        //Instant retention = now.plus(Duration.ofDays(90));

        MemberSigninLog memberSigninLog = MemberSigninLog.builder()
                .siteType(event.siteType)
                .memberKey(event.memberKey)
                .memberType(event.memberType)
                .signinType(event.signinType)
                .ipAddress(event.ipAddress)
                .result(event.result)
                .reason(event.reason)
                .timestamp(event.timestamp)
                .memberSigninEvent(event)
                .insDate(now)
                .deletedAt(retention)
                .build();

        memberSigninLogService.insert(memberSigninLog);
    }

    // 비회원 로그인
    public void processEvent(NonMemberSigninEvent event) {
        Instant now = Instant.now();
        Instant retention = now.plus(Duration.ofMinutes(3));
        //Instant retention = now.plus(Duration.ofDays(90));

        NonMemberSigninLog nonMemberSigninLog = NonMemberSigninLog.builder()
                .siteType(event.siteType)
                .name(event.name)
                .mobileNo(event.mobileNo)
                .ipAddress(event.ipAddress)
                .result(event.result)
                .reason(event.reason)
                .timestamp(event.timestamp)
                .nonMemberSigninEvent(event)
                .insDate(now)
                .deletedAt(retention)
                .build();

        memberSigninLogService.insert(nonMemberSigninLog);
    }





}
