package com.member.tracking.mapper;

import com.member.tracking.model.dto.MemberSigninLogResponse;
import com.member.tracking.model.entity.MemberSigninLog;

public class MemberSigninLogMapper {
    public static MemberSigninLogResponse toResponse(MemberSigninLog log) {
        return MemberSigninLogResponse.builder()
                .siteType(log.getSiteType())
                .memberKey(log.getMemberKey())
                .memberType(log.getMemberType())
                .signinType(log.getSigninType())
                .ipAddress(log.getIpAddress())
                .result(log.getResult())
                .reason(log.getReason())
                .timestamp(log.getTimestamp())
                .memberSigninEvent(log.getMemberSigninEvent())
                .insDate(log.getInsDate())
                .build();
    }
}
