package com.member.tracking.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.member.tracking.model.event.MemberSigninEvent;
import com.member.tracking.model.event.NonMemberSigninEvent;
import com.member.tracking.task.LogAddTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Slf4j
@Component
@RequiredArgsConstructor
public class LogConsumer {

    private final LogAddTask logAddTask;
    private final ObjectMapper objectMapper;

    // 회원 로그인
    @Bean("member_signin")
    public Consumer<String> member_signin() {
        return event -> {
            try {
                // JSON 문자열을 MemberSignin 객체로 변환
                MemberSigninEvent signinEvent = objectMapper.readValue(event, MemberSigninEvent.class);

                // 로그 출력
                //log.info("Nonmember Signin Consumer Stream !!! : {}", event);
                log.info("Member Signin Consumer Stream !!! : {}", signinEvent);

                logAddTask.processEvent(signinEvent);

            } catch (Exception e) {
                log.error("Failed to process member signin event: {}", event, e);
            }
        };
    }

    // 비회원 로그인
    @Bean("nonmember_signin")
    public Consumer<String> nonmember_signin() {
        return event -> {
            try {
                // JSON 문자열을 NonMemberSignin 객체로 변환
                NonMemberSigninEvent signinEvent  = objectMapper.readValue(event, NonMemberSigninEvent.class);

                // 로그 출력
                //log.info("Nonmember Signin Consumer Stream !!! : {}", event);
                log.info("Nonmember Signin Consumer Stream !!! : {}", signinEvent);

                logAddTask.processEvent(signinEvent);

            } catch (Exception e) {
                log.error("Failed to process Nonmember signin event: {}", event, e);
            }

        };
    }

}
