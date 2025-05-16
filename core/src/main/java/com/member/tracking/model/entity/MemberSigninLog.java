package com.member.tracking.model.entity;

import com.member.tracking.model.event.MemberSigninEvent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
//@TypeAlias("member_signin_logs")
@Document(collection = "member_signin_logs")
public class MemberSigninLog {
    @Id
    private String _id;

    @Field("site_type")
    private String siteType; 	    // 사이트 유형 코드

    @Field("member_id")
    private String memberKey; 	    // 아이디

    @Field("member_type")
    private String memberType; 	    // 회원 유형

    @Field("signin_type")
    private String signinType; 	    // 로그인 방식 (IDPW, AUTO)

    @Field("ip")
    private String ipAddress; 	    // 클라이언트 IP 주소

    @Field("result")
    public String result;           // 로그인 처리 결과

    @Field("reason")
    public String reason;           // 로그인 처리 결과의 상세 사유 (코드 형태)

    @Field("login_date")
    public LocalDateTime timestamp;        // 로그인 시도 (이벤트 발생 시각)   "expireAt": new ISODate("2024-11-07T10:32:47.157Z")}}

    @Field("detail_log")
    private MemberSigninEvent memberSigninEvent;

    @Field("ins_date")
    private LocalDateTime insDate;

    @Field("retention_date")
    @Indexed(expireAfter = "0")
    private LocalDateTime deletedAt;


    // https://www.mongodb.com/ko-kr/docs/manual/tutorial/expire-data/
    // 90일 지난 알림 삭제 시 사용하는 TTL 인덱스 (예: 30일)
    // db.member_tracking.createIndex({ "deletedAt":1 }, { "name": "ix_deletedAt","expireAfterSeconds": 2592000 })
    // db.member_tracking.createIndex({ "deletedAt":1 }, { "name": "ix_deletedAt","expireAfterSeconds": 0 })

    // TTL 적용된 인덱스를 MongoDB에서 확인하려면:
    // db.member_signin_log.getIndexes()
    // TTL 인덱스를 제거해도 기존 도큐먼트는 삭제되지 않으며, 더 이상 자동 삭제도 되지 않습니다.
    // db.member_signin_log.dropIndex("deletedAt_1")

    //  @Indexed(expireAfter = "10s") String expireAfterTenSeconds;
    //  @Indexed(expireAfter = "1d") String expireAfterOneDay;
    //  @Indexed(expireAfter = "P2D") String expireAfterTwoDays;
    //  @Indexed(expireAfter = "#{@mySpringBean.timeout}") String expireAfterTimeoutObtainedFromSpringBean;
}
