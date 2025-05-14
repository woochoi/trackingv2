package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SigninProcType {
    DEFAULT("DEFAULT"),
    SSO("SSO"),
    AUTH("AUTH"),
    BRIDGE("BRIDGE"),
    SOCIAL("SOCIAL");


    private final String code;

    SigninProcType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SigninProcType fromCode(String code) {
        for (SigninProcType type : SigninProcType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
