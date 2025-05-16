package com.member.tracking.service;

import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.query.FindMemberSigninLogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberSigninLogReadService {
    List<MemberSigninLog> getSigninLogs();
    Page<MemberSigninLog> pageAllSigninLogs1(int page, int size);
    Page<MemberSigninLog> pageAllSigninLogs2(Pageable pageable);
    Page<MemberSigninLog> pageAllSigninLogs3(FindMemberSigninLogQuery query);
}
