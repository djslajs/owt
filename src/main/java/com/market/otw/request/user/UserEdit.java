package com.market.otw.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEdit {

    @NotBlank(message = "로그인 아이디를 입력하세요.")
    private String loginId;

    @NotBlank(message = "이름를 입력하세요.")
    private String password;

    @NotBlank(message = "이름를 입력하세요.")
    private String userName;

    @NotBlank(message = "이메일을 입력하세요.")
    private String email;

    @NotBlank(message = "주소 입력해주세요.")
    private String address1;

    private String address2;

    @NotBlank(message = "핸드폰번호를 입력해주세요.")
    private String mobile;

    private Long failCount;

    @Builder
    public UserEdit(String loginId, String password, String userName, String email, String address1, String address2, String mobile, Long failCount) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
        this.failCount = failCount;
    }
}
