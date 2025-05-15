package com.member.tracking.model.mapper;

import com.member.tracking.model.MemberSigninLogResponse;
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
                .deletedAt(log.getDeletedAt())
                .build();
    }
}
