package com.member.tracking.model.query;

import lombok.*;

import java.time.Instant;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FindMemberSigninLogQuery {
    private String  siteType;   // 사이트 유형 코드
    private String  memberKey;  // 아이디
    private String  result;     // 로그인 처리 결과
    private String  ipAddress;  // 클라이언트 IP 주소
    private Instant timestamp;  // 로그인 시도 (이벤트 발생 시각)
}

