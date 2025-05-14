package com.member.tracking.controller.test;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
public class EventConsumerTestController implements EventConsumerTestControllerSpec {

    private final Consumer<String> member_signin;
    private final Consumer<String> nonmember_signin;

    public EventConsumerTestController(Consumer<String> member_signin, Consumer<String> nonmember_signin) {
        this.member_signin = member_signin;
        this.nonmember_signin = nonmember_signin;
    }

    @Override
    @PostMapping("/test/member_signin")
    public void member_signin(@RequestBody String event) {
        member_signin.accept(event);
    }

    @Override
    @PostMapping("/test/nonmember_signin")
    public void nonmember_signin(@RequestBody String event) {
        nonmember_signin.accept(event);
    }

}
