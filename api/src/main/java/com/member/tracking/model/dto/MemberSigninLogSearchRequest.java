package com.member.tracking.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSigninLogSearchRequest {
    private String siteType;
    private String memberKey;
    private String result;
    private String ipAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;
    private int page = 0;
    private int size = 5;
}
