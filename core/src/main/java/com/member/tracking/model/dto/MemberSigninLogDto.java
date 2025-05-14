package com.member.tracking.model.dto;

import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.model.event.MemberSigninEvent;
import lombok.*;

import java.time.Instant;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberSigninLogDto {
    private String _id;
    private String siteType; 	    // 사이트 유형 코드
    private String memberKey; 	    // 아이디
    private String memberType; 	    // 회원 유형
    private String signinType; 	    // 로그인 방식 (IDPW, AUTO)
    private String ipAddress; 	    // 클라이언트 IP 주소
    public String result;           // 로그인 처리 결과
    public String reason;           // 로그인 처리 결과의 상세 사유 (코드 형태)
    public String timestamp;        // 로그인 시도 (이벤트 발생 시각)
    private MemberSigninEvent memberSigninEvent;
    private Instant insDate;
    private Instant deletedAt;

    public static MemberSigninLogDto from(MemberSigninLog memberSigninLog) {
        var dto = new MemberSigninLogDto();
        dto._id = memberSigninLog.get_id();
        dto.siteType = memberSigninLog.getSiteType();
        dto.memberKey = memberSigninLog.getMemberKey();
        dto.memberType = memberSigninLog.getMemberType();
        dto.signinType = memberSigninLog.getSigninType();
        dto.ipAddress = memberSigninLog.getIpAddress();
        dto.result = memberSigninLog.getResult();
        dto.reason = memberSigninLog.getReason();
        dto.timestamp = memberSigninLog.getTimestamp();
        dto.memberSigninEvent = memberSigninLog.getMemberSigninEvent();
        dto.insDate = memberSigninLog.getInsDate();
        dto.deletedAt = memberSigninLog.getDeletedAt();
        return dto;
    }

}
