package com.member.tracking.service;

import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.model.entity.NonMemberSigninLog;
import com.member.tracking.mongo.query.FindMemberSigninLogQuery;
import com.member.tracking.mongo.query.FindNonMemberSigninLogQuery;
import com.member.tracking.repository.MemberSigninLogReadRepository;
import com.member.tracking.repository.MemberSigninLogRepository;
import com.member.tracking.repository.NonMemberSigninLogReadRepository;
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
@RequiredArgsConstructor
@Service
public class MemberSigninLogReadServiceImpl implements MemberSigninLogReadService {

    private final MemberSigninLogRepository memberSigninLogRepository;

    private final MemberSigninLogReadRepository memberSigninLogReadRepository;
    private final NonMemberSigninLogReadRepository nonMemberSigninLogReadRepository;


    public List<MemberSigninLog> getSigninLogs() {
        return memberSigninLogRepository.findAll();
    }
    public Page<MemberSigninLog> pageAllSigninLogs1(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("ins_date").descending());
        return memberSigninLogRepository.findAll(pageable);
    }
    public Page<MemberSigninLog> pageAllSigninLogs2(Pageable pageable) {
        return memberSigninLogRepository.findAll(pageable);
    }



    public Page<MemberSigninLog> getMemberSigninLogs(FindMemberSigninLogQuery query) {
        return memberSigninLogReadRepository.findBy(query);
    }

    public Page<NonMemberSigninLog> getNonMemberSigninLogs(FindNonMemberSigninLogQuery query) {
        return nonMemberSigninLogReadRepository.findBy(query);
    }

}
