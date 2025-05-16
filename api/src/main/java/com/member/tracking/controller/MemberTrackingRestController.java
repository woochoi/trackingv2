package com.member.tracking.controller;

import com.member.tracking.model.common.ApiResponse;
import com.member.tracking.model.dto.MemberSigninLogResponse;
import com.member.tracking.model.dto.MemberSigninLogSearchRequest;
import com.member.tracking.model.common.PageResponse;
import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.mapper.MemberSigninLogMapper;
import com.member.tracking.mongo.query.FindMemberSigninLogQuery;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberTrackingRestController {
    // Core Service
    private final MemberSigninLogReadService memberSigninLogReadService;

    @GetMapping("/signin-log-list")
    public List<MemberSigninLog> getMemberSigninLogList() { // 니중에 API Response 로 변경한다. (openfeign)

        log.info("signin-log-list");

        List<MemberSigninLog> logs = memberSigninLogReadService.getSigninLogs();
        return logs;
    }

    @GetMapping("/signin-log-list-paging1")
    public Page<MemberSigninLog> getMemberSigninLogListPaging1(@RequestParam(defaultValue = "0") int page) {

        log.info("signin-log-list-paging1");

        Page<MemberSigninLog> logs = memberSigninLogReadService.pageAllSigninLogs1(page, 10);
        return logs;
    }

    @GetMapping("/signin-log-list-paging2") // PageDto
    public ApiResponse<PageResponse<MemberSigninLogResponse>> getMemberSigninLogListPaging2(
      MemberSigninLogSearchRequest request
    ) {
        log.info("signin-log-list-paging2");
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

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


    @GetMapping("/signin-log-list-paging3") // PageDto
    public ApiResponse<PageResponse<MemberSigninLogResponse>> getMemberSigninLogListPaging3(
      MemberSigninLogSearchRequest request
    ) {
        log.info("signin-log-list-paging3");

        LocalDateTime historyDateGte = request.getFrom() != null ? request.getFrom().atStartOfDay() : null;
        LocalDateTime historyDateLte = request.getTo() != null ? request.getTo().atTime(23, 59, 59) : null;
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        var query = FindMemberSigninLogQuery.builder()
                .siteType(request.getSiteType())
                .memberKey(request.getMemberKey())
                .result(request.getResult())
                .ipAddress(request.getIpAddress())
                .from(historyDateGte)
                .to(historyDateLte)
                .pageable(pageable)
                .build();

        Page<MemberSigninLog> list = memberSigninLogReadService.pageAllSigninLogs3(query);

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
