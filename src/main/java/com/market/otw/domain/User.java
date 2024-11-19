package com.market.otw.domain;

import static lombok.AccessLevel.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;

    private String userName;

    private String email;

    private String address1;

    private String address2;

    private String mobile;

    @Builder
    public User(Long id, String userName, String email, String address1, String address2, String mobile) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
    }
}
