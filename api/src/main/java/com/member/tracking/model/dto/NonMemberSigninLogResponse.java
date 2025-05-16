package com.member.tracking.model.dto;

import com.member.tracking.model.event.NonMemberSigninEvent;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NonMemberSigninLogResponse {
    private String siteType; 	    // 사이트 유형 코드
    private String name;            // 이름
    private String mobileNo;        // 휴대폰
    private String ipAddress; 	    // 클라이언트 IP 주소
    public String result;           // 로그인 처리 결과
    public String reason;           // 로그인 처리 결과의 상세 사유 (코드 형태)
    public LocalDateTime timestamp;        // 로그인 시도 (이벤트 발생 시각)
    private NonMemberSigninEvent nonMemberSigninEvent;
    private LocalDateTime insDate;
}
