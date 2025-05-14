package com.member.tracking.controller;

import com.member.tracking.model.MemberSigninLogResponse;
import com.member.tracking.model.MemberTrackingApiResponse;
import com.member.tracking.model.dto.PageDto;
import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.service.MemberSigninLogService;
import com.member.tracking.service.MemberTrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberTrackingRestController {

    // Core Service
    private final MemberSigninLogService memberSigninLogService;

    // 프론트 조회 어드민 페이지에 제공해 줄 API 를 만든다!

    @GetMapping("signin-log-list")
    public List<MemberSigninLog> viewSigninLogs() { // 니중에 API Response 로 변경한다. (openfeign)
        List<MemberSigninLog> logs = memberSigninLogService.getSigninLogs();
        return logs;
    }

    @GetMapping("/signin-log-list-page")
    public Page<MemberSigninLog> viewSigninLogs(@RequestParam(defaultValue = "0") int page) {
        Page<MemberSigninLog> logs = memberSigninLogService.getSigninLogs(page, 10);
        return logs;
    }


    /*@GetMapping("/signin-logs")
    public MemberTrackingApiResponse<PageDto<MemberSigninLogResponse>> viewSigninLogs1(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        log.info("!!!!!!!!!!!!!!");
        Pageable pageable = PageRequest.of(page, size); // pageableSort

        var list = memberSigninLogService.getSigninLogs2(pageable);
    }*/



}
