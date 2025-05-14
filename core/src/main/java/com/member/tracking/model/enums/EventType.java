package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {
    SIGNIN("signin"), // 로그인
    SIGNOUT("signout"), // 로그아웃
    NON_SIGNIN("non-signin"), // 비회원 로그인
    SIGNUP("signup"), // 가입
    WITHDRAW("withdraw"); // 탈퇴



    private final String code;

    EventType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static EventType fromCode(String code) {
        for (EventType type : EventType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
