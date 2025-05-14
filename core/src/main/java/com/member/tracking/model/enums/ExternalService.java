package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExternalService {
    FROM_KAKAOLINK("FROM_KAKAOLINK"),       // 카카오
    FROM_NAVERLINK("FROM_NAVERLINK");       // 네이버

    private final String code;

    ExternalService(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static ExternalService fromCode(String code) {
        for (ExternalService service : ExternalService.values()) {
            if (service.code.equals(code)) {
                return service;
            }
        }
        return null;
    }
}
