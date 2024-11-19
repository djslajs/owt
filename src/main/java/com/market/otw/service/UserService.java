package com.market.otw.service;

import org.springframework.stereotype.Service;
import com.market.otw.repository.UserRepository;
import com.market.otw.request.UserCreate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public void create( UserCreate userCreate) {

    }
}
