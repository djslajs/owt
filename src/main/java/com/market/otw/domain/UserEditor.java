package com.market.otw.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEditor {
    private String password;

    private String userName;

    private String email;

    private String address1;

    private String address2;

    private String mobile;

    private Long failCount;

    private String regisnDate;

    @Builder
    public UserEditor(String password, String userName, String email, String address1, String address2, String mobile, Long failCount, String regisnDate) {
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
        this.failCount = failCount;
        this.regisnDate = regisnDate;
    }
}
