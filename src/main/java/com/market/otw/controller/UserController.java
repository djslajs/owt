package com.market.otw.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.market.otw.request.LoginCreate;
import com.market.otw.request.UserCreate;
import com.market.otw.service.LoginService;
import com.market.otw.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void post(@RequestBody @Valid UserCreate request) {
        // request.validate();
        userService.create(request);
    }
}
