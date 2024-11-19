package com.market.otw.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.market.otw.domain.Login;
import com.market.otw.exception.InvalidMessageException;
import com.market.otw.repository.LoginRepository;
import com.market.otw.request.LoginCreate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public void duplicateLoginId( String loginId) {
        if( loginRepository.existsByLoginId( loginId)) {
            throw new InvalidMessageException( "중복된 아이디가 존재합니다.");
        }
    }

    public void create(LoginCreate loginCreate) {
        String loginId = loginCreate.getLoginId();
        duplicateLoginId( loginId);
        Login login = Login.builder()
            .loginId( loginId)
            .password( loginCreate.getPassword())
            .build();

        loginRepository.save( login);
    }
}
