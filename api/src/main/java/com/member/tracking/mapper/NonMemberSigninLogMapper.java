package com.member.tracking.mapper;

import com.member.tracking.model.dto.NonMemberSigninLogResponse;
import com.member.tracking.model.entity.NonMemberSigninLog;

public class NonMemberSigninLogMapper {
    public static NonMemberSigninLogResponse toResponse(NonMemberSigninLog log) {
        return NonMemberSigninLogResponse.builder()
                .siteType(log.getSiteType())
                .name(log.getName())
                .mobileNo(log.getMobileNo())
                .ipAddress(log.getIpAddress())
                .result(log.getResult())
                .reason(log.getReason())
                .timestamp(log.getTimestamp())
                .nonMemberSigninEvent(log.getNonMemberSigninEvent())
                .insDate(log.getInsDate())
                .build();
    }
}
