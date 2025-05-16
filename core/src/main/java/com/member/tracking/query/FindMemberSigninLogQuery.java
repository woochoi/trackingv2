package com.member.tracking.query;

import lombok.*;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class FindMemberSigninLogQuery {
    private String  siteType;   // 사이트 유형 코드
    private String  memberKey;  // 아이디
    private String  result;     // 로그인 처리 결과
    private String  ipAddress;  // 클라이언트 IP 주소
    private LocalDateTime from; // from
    private LocalDateTime to; // to
    private Pageable pageable;
}

