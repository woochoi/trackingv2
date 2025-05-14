package com.member.tracking.service;

import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.model.entity.NonMemberSigninLog;
import com.member.tracking.repository.MemberSigninLogRepository;
import com.member.tracking.repository.NonMemberSigninLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSigninLogService {
    // Core Repository
    private final MemberSigninLogRepository memberSigninLogRepository;
    private final NonMemberSigninLogRepository nonMemberSigninLogRepository;

    /**
     * 회원 로그인
     * @param memberSigninLog
     */
    public void insert(MemberSigninLog memberSigninLog) {
        MemberSigninLog result = memberSigninLogRepository.insert(memberSigninLog);
        log.info("inserted: {}", result);
    }

    /**
     * 비회원 로그인
     * @param nonMemberSigninLog
     */
    public void insert(NonMemberSigninLog nonMemberSigninLog) {
        NonMemberSigninLog result = nonMemberSigninLogRepository.insert(nonMemberSigninLog);
        log.info("inserted: {}", result);
    }


    /**
     * 테스트
     * member_signin_logs 전체를 조회 한다!
     * 페이징이 필요
     * @return
     */
    public List<MemberSigninLog> getSigninLogs() {
        return memberSigninLogRepository.findAll();
    }

    public Page<MemberSigninLog> getSigninLogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("ins_date").descending());
        return memberSigninLogRepository.findAll(pageable);
    }


    public Page<MemberSigninLog> getSigninLogs2(Pageable pageable) {
        return memberSigninLogRepository.findAll(pageable);
    }




}
