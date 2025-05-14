package com.member.tracking.controller.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;

@Tag(name = "Consumer 호출 테스트 API")
public interface EventConsumerTestControllerSpec {
    @Operation(
            requestBody = @RequestBody(
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "회원 로그인", value = MEMBER_SIGNIN_PAYLOAD)
                                    }
                            )
                    }
            )
    )
    void member_signin(String event);

    String MEMBER_SIGNIN_PAYLOAD = """
            {
               "type": "signin",
               "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36",
               "osType": "MAC",
               "osVersion": "10_15_7",
               "browserType": "CHR",
               "browserVersion": "135.0.0.0",
               "deviceName": "Mac",
               "ipAddress": "192.111.11.11",
               "nation": "UNK",
               "continent": "UNK",
               "url": "https://test.com/login",
               "result": "SUCCESS",
               "reason": "RESULT_SUCCESS",
               "siteType": "G1",
               "timestamp": "2025-04-18T14:33:13.217236108",
               "auto": "false",
               "signinUiType": "DEFAULT",
               "legacy": "false",
               "signinType": "IDPW",
               "memberKey": "105138778",
               "session": "false",
               "hermes": "false",
               "memberType": "EP",
               "signinProcType": "DEFAULT"
            }
            """;

    @Operation(
            requestBody = @RequestBody(
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(name = "비회원 로그인", value = NONMEMBER_SIGNIN_PAYLOAD)
                                    }
                            )
                    }
            )
    )
    void nonmember_signin(String event);

    String NONMEMBER_SIGNIN_PAYLOAD = """
            {
               "type": "non-signin",
               "name": "이",
               "mobileNo": "1234",
               "userAgent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36",
               "osType": "MAC",
               "osVersion": "10_15_7",
               "browserType": "CHR",
               "browserVersion": "135.0.0.0",
               "deviceName": "Mac",
               "ipAddress": "192.111.11.11",
               "nation": "UNK",
               "continent": "UNK",
               "url": "https://test.com/login",
               "result": "FAIL",
               "reason": "RESULT_NOT_FOUND",
               "siteType": "G1",
               "timestamp": "2025-04-18T14:35:38.638707117",
               "session": "false"
            }
            """;
}
