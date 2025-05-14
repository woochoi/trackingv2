package com.member.tracking.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Platform {
    DESKTOP("PC"),
    MOBILE_WEB("MW"),
    IPHONE_APP("IOS_APP"),
    ANDROID_APP("AOS_APP");

    private final String code;

    Platform(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static Platform fromCode(String code) {
        for (Platform platform : Platform.values()) {
            if (platform.code.equals(code)) {
                return platform;
            }
        }
        return null;
    }
}
