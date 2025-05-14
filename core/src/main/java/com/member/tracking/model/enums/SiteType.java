package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SiteType {
    G1("G1"),
    G2("G2"),
    G3("G3"),
    A1("A1"),
    A2("A2"),
    A3("A3");

    private final String code;

    SiteType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SiteType fromCode(String code) {
        for (SiteType type : SiteType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}