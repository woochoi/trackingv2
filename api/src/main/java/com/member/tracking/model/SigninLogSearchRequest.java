package com.member.tracking.model;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class SigninLogSearchRequest {
    private String siteType;
    private Long memberKey;
    private String result;
    private String ipAddress;
    private Instant from;
    private Instant to;
    private int page = 0;
    private int size = 5;
}
