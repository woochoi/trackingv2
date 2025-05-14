package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SigninUiType {
    DEFAULT("DEFAULT"),   // default
    LAYER("LAYER"),       // layer
    POPUP("POPUP");       // popup

    private final String code;

    SigninUiType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static SigninUiType fromCode(String code) {
        for (SigninUiType type : SigninUiType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
