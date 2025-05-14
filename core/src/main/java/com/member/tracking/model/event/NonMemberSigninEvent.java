package com.member.tracking.model.event;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;

@ToString
@Builder(builderMethodName = "mappingBuilder", builderClassName = "MappingBuilder", toBuilder = true)
@EqualsAndHashCode(doNotUseGetters = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@TypeAlias("NonMemberSignin")
public class NonMemberSigninEvent {
    public String type;
    public String userAgent;
    public String osType;
    public String osVersion;
    public String browserType;
    public String browserVersion;
    public String deviceName;
    public String ipAddress;
    public String nation;
    public String continent;
    public String url;
    public String result;
    public String reason;
    public String siteType;
    public String timestamp;    // 로그인 시도 (이벤트 발생 시각)
    public String session;
    public String name = "홍";        // 추가
    public String mobileNo = "1234";  // 추가
}
/*
    {
       "type": "non-signin",
       "name"; "이",
       "mobileNo": "1234",
       "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36",
       "osType": "MAC",
       "osVersion": "10_15_7",
       "browserType": "CHR",
       "browserVersion": "135.0.0.0",
       "deviceName": "Mac",
       "ipAddress": "192.168.12.34",
       "nation": "UNK",
       "continent": "UNK",
       "url": "https://aaa/login/loginProc",
       "result": "FAIL",
       "reason": "RESULT_NOT_FOUND",
       "siteType": "G1",
       "timestamp": "2025-04-18T14:35:38.638707117",
       "session": "false"
    }
 */