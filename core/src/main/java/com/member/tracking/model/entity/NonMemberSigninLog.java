package com.member.tracking.model.entity;

import com.member.tracking.model.event.NonMemberSigninEvent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
//@TypeAlias("nonmember_signin_logs")
@Document(collection = "nonmember_signin_logs")
public class NonMemberSigninLog {
    @Id
    private String _id;

    @Field("site_type")
    private String siteType; 	    // 사이트 유형 코드

    @Field("name")
    private String name;            // 이름

    @Field("mobile")
    private String mobileNo;        // 휴대폰

    @Field("ip")
    private String ipAddress; 	    // 클라이언트 IP 주소

    @Field("result")
    public String result;           // 로그인 처리 결과

    @Field("reason")
    public String reason;           // 로그인 처리 결과의 상세 사유 (코드 형태)

    @Field("login_date")
    public String timestamp;        // 로그인 시도 (이벤트 발생 시각)

    @Field("detail_log")
    private NonMemberSigninEvent nonMemberSigninEvent;

    @Field("ins_date")
    private Instant insDate;

    @Field("retention_date")
    @Indexed(expireAfter = "0")
    private Instant deletedAt;
}
