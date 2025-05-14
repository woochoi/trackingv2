package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SigninType {
    IDPW("IDPW"),       // ID/PW 로그인
    AUTO("AUTO"),       // 자동로그인
    KAKAO("KAKAO"),     // 카카오 로그인
    APPLE("APPLE"),     // 애플 로그인
    NAVER("NAVER"),     // 네이버 로그인
    GOOGLE("GOOGLE");   // 구글 로그인

    private final String code;

    SigninType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SigninType fromCode(String code) {
        for (SigninType type : SigninType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
