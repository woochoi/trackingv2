package com.member.tracking.repository;

import com.member.tracking.model.entity.MemberSigninLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSigninLogRepository extends MongoRepository<MemberSigninLog, String> {

    /*
        - 조회 기준
        1. 로그인 이벤트 종류 (MemberSigninLog)
        사이트 유형 코드       siteType
        아이디                 memberKey
        로그인 처리 결과       result
        클라이언트 IP 주소     ipAddress
        로그인 시도 (이벤트 발생 시각)  timestamp
     */

}
