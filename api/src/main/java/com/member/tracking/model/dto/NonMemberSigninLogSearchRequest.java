package com.member.tracking.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class NonMemberSigninLogSearchRequest {
    private String siteType;
    private String name;
    private String mobileNo;
    private String result;
    private String ipAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;
    private int page = 0;
    private int size = 5;
}
