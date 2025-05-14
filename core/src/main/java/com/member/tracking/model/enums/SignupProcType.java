package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SignupProcType {
    NormalSignUp("NSUP"),           // 가입 동선1
    BusinessSignUp("BSUP");         // 가입 동선2


    private final String code;

    SignupProcType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SignupProcType fromCode(String code) {
        for (SignupProcType type : SignupProcType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
