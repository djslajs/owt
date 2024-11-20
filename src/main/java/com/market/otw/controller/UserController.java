package com.market.otw.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.market.otw.request.user.Login;
import com.market.otw.request.user.UserCreate;
import com.market.otw.request.user.UserEdit;
import com.market.otw.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")
    public void join(@RequestBody @Valid UserCreate request) {
        // request.validate();
        userService.create(request);
    }

    @PostMapping("/user/login")
    public void login(@RequestBody @Valid Login request) {
        // request.validate();
        userService.login(request);
    }

    @PostMapping("/user/edit")
    public void edit(@RequestBody @Valid UserEdit request) {
        // request.validate();
        userService.edit(request);
    }

    @PostMapping("/user/resign")
    public void resign(@RequestBody @Valid UserEdit request) {
        // request.validate();
        userService.resign(request);
    }
}
