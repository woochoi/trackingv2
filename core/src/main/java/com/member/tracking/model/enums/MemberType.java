package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MemberType {
    PP("PP"),   // 개인1
    EP("EP"),   // 개인2
    IB1("IB1"), // 개인3
    IS1("IS1"); // 개인4

    private final String code;

    MemberType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static MemberType fromCode(String code) {
        for (MemberType type : MemberType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
