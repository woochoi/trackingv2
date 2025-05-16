package com.member.tracking.model.event;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.time.LocalDateTime;

@ToString
@Builder(builderMethodName = "mappingBuilder", builderClassName = "MappingBuilder", toBuilder = true)
@EqualsAndHashCode(doNotUseGetters = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@TypeAlias("MemberSignin")
public class MemberSigninEvent {
    @NotBlank
    public String type;
    public String userAgent;
    public String osType;
    public String osVersion;
    public String browserType;
    public String browserVersion;
    public String deviceName;
    public String ipAddress;    // 클라이언트 IP 주소
    public String nation;
    public String continent;
    public String url;          // 요청이 전송된 엔드포인트 URL
    public String result;       // 로그인 처리 결과
    public String reason;       // 로그인 처리 결과의 상세 사유 (코드 형태)
    public String siteType;     // 사이트 유형 코드
    public LocalDateTime timestamp;    // 로그인 시도 (이벤트 발생 시각)
    public boolean auto;
    public String signinUiType; // 로그인 UI 유형
    public boolean legacy;
    public String signinType;   // 로그인 방식
    public String memberKey;    // 아이디
    public boolean session;
    public boolean hermes;
    public String memberType;   // 회원 유형
    public String signinProcType; // 로그인 처리 프로세스 유형
}


/*
    {
       "type": "signin",
       "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36",
       "osType": "WIN",
       "osVersion": "",
       "browserType": "CHR",
       "browserVersion": "135.0.0.0",
       "deviceName": "PC",
       "ipAddress": "121.190.208.11",
       "nation": "KR",
       "continent": "AS",
       "url": "https://aaaa/login/loginProc",
       "result": "FAIL",
       "reason": "RESULT_NOT_FOUND",
       "siteType": "G1",
       "timestamp": "2025-04-18T14:26:30.878566191",
       "auto": "false",
       "signinUiType": "DEFAULT",
       "legacy": "false",
       "signinType": "IDPW",
       "session": "false",
       "hermes": "false",
       "signinProcType": "DEFAULT"
    }
 */

