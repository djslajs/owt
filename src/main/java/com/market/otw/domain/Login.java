package com.market.otw.domain;

import static lombok.AccessLevel.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
public class Login {

    @Id
    @GeneratedValue
    private Long id;

    private String loginId;

    private String password;

    private Long failCount;

    @Builder
    public Login(Long id, String loginId, String password, Long failCount) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.failCount = failCount;
    }
}
