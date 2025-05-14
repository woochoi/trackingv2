package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SignupType {
    IDPW("IDPW"),               // 아이디/패스워드 입력 가입
    KAKAO("KAKAO"),             // 카카오 소셜 가입
    APPLE("APPLE"),             // 애플 소셜 가입
    NAVER("NAVER"),             // 네이버 소셜 가입
    GOOGLE("GOOGLE");           // 구글 소셜 가입

    private final String code;

    SignupType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SignupType fromCode(String code) {
        for (SignupType type : SignupType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
