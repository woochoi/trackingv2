package com.member.tracking.controller;

import com.member.tracking.model.ApiResponse;
import com.member.tracking.model.MemberSigninLogResponse;
import com.member.tracking.model.SigninLogSearchRequest;
import com.member.tracking.model.dto.PageResponse;
import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.model.mapper.MemberSigninLogMapper;
import com.member.tracking.model.query.FindMemberSigninLogQuery;
import com.member.tracking.service.MemberSigninLogReadService;
import com.member.tracking.service.MemberSigninLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberTrackingRestController {
    // Core Service
    private final MemberSigninLogService memberSigninLogService;

    private final MemberSigninLogReadService memberSigninLogReadService;

    // 프론트 조회 어드민 페이지에 제공해 줄 API 를 만든다!

    @GetMapping("/all-signin-log-list")
    public List<MemberSigninLog> allSigninLogs() { // 니중에 API Response 로 변경한다. (openfeign)
        List<MemberSigninLog> logs = memberSigninLogReadService.getSigninLogs();
        return logs;
    }

    @GetMapping("/all-signin-log-list-page1")
    public Page<MemberSigninLog> pageAllSigninLogs1(@RequestParam(defaultValue = "0") int page) {
        Page<MemberSigninLog> logs = memberSigninLogReadService.pageAllSigninLogs1(page, 10);
        return logs;
    }

    @GetMapping("/all-signin-log-list-page2") // PageDto
    public ApiResponse<PageResponse<MemberSigninLogResponse>> pageAllSigninLogs2( // MemberSigninLogResponse
        SigninLogSearchRequest request
    ) {
        log.info("pageAllSigninLogs2");

        Instant now = Instant.now();
        //Instant retention = now.plus(Duration.ofMinutes(3));
        Instant retention = now.plus(Duration.ofDays(1));

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize()); // pageableSort

        Instant historyDateGte = request.getFrom() != null ? request.getFrom() : now;
        Instant historyDateLte = request.getTo() != null ? request.getTo() : now.plus(Duration.ofDays(1));

        var qy = FindMemberSigninLogQuery.builder()
                .siteType(request.getSiteType())
                .memberKey(request.getMemberKey())
                .result(request.getResult())
                .ipAddress(request.getIpAddress())
                .from(historyDateGte)
                .to(historyDateLte)
                .pageable(pageable)
                .build();

        Page<MemberSigninLog> list = memberSigninLogReadService.pageAllSigninLogs2(pageable);

        // 엔티티 → DTO 매핑
        List<MemberSigninLogResponse> content = list.getContent().stream()
                .map(MemberSigninLogMapper::toResponse)
                .collect(Collectors.toList());

        PageResponse<MemberSigninLogResponse> response = new PageResponse<>(
                content,
                list.getNumber(),
                list.getSize(),
                list.getTotalElements(),
                list.getTotalPages()
        );

        return ApiResponse.ok(response);
    }


    @GetMapping("/all-signin-log-list-page3") // PageDto
    public ApiResponse<PageResponse<MemberSigninLogResponse>> pageAllSigninLogs3( // MemberSigninLogResponse
            SigninLogSearchRequest request
    ) {
        log.info("pageAllSigninLogs2");

        Instant now = Instant.now();
        //Instant retention = now.plus(Duration.ofMinutes(3));
        Instant retention = now.plus(Duration.ofDays(1));

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize()); // pageableSort

        Instant historyDateGte = request.getFrom() != null ? request.getFrom() : now;
        Instant historyDateLte = request.getTo() != null ? request.getTo() : now.plus(Duration.ofDays(1));

        var qy = FindMemberSigninLogQuery.builder()
                .siteType(request.getSiteType())
                .memberKey(request.getMemberKey())
                .result(request.getResult())
                .ipAddress(request.getIpAddress())
                .from(historyDateGte)
                .to(historyDateLte)
                .pageable(pageable)
                .build();

        //Page<MemberSigninLog> list = memberSigninLogReadService.pageAllSigninLogs2(pageable);
        Page<MemberSigninLog> list = memberSigninLogReadService.pageAllSigninLogs3(qy);


        // 엔티티 → DTO 매핑
        List<MemberSigninLogResponse> content = list.getContent().stream()
                .map(MemberSigninLogMapper::toResponse)
                .collect(Collectors.toList());

        PageResponse<MemberSigninLogResponse> response = new PageResponse<>(
                content,
                list.getNumber(),
                list.getSize(),
                list.getTotalElements(),
                list.getTotalPages()
        );

        return ApiResponse.ok(response);
    }



}
