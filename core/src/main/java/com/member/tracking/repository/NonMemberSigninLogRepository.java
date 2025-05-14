package com.member.tracking.repository;

import com.member.tracking.model.entity.NonMemberSigninLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NonMemberSigninLogRepository extends MongoRepository<NonMemberSigninLog, String> {

    /*
        - 조회 기준
        1. 로그인 이벤트 종류 (NonMemberSigninLog)
        사이트 유형 코드     siteType
        이름              name
        휴대폰 번호         mobileNo
        클라이언트 IP 주소   ipAddress
        로그인 처리 결과     result
        로그인 시도 (이벤트 발생 시각)  timestamp
     */

}
