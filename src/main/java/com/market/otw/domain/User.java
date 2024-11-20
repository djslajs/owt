package com.market.otw.domain;

import static lombok.AccessLevel.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    private String password;

    private String userName;

    private String email;

    private String address1;

    private String address2;

    private String mobile;

    private Long failCount;

    private String regisnDate;

    @Builder
    public User(Long id, String loginId, String password, String userName, String email, String address1, String address2, String mobile, Long failCount, String regisnDate) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
        this.failCount = failCount;
        this.regisnDate = regisnDate;
    }

    public UserEditor.UserEditorBuilder toEditor() {
        return UserEditor.builder()
            .password(password)
            .userName(userName)
            .email(email)
            .address1(address1)
            .address2(address2)
            .mobile(mobile)
            .failCount(failCount)
            .regisnDate( regisnDate)
            ;
    }

    public void edit(UserEditor userEditor) {
        password = userEditor.getPassword();
        userName = userEditor.getUserName();
        email = userEditor.getEmail();
        address1 = userEditor.getAddress1();
        address2 = userEditor.getAddress2();
        mobile = userEditor.getMobile();
        failCount = userEditor.getFailCount();
        regisnDate = userEditor.getRegisnDate();
    }
}
