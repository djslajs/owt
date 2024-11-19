package com.market.otw.request;

import com.market.otw.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginCreate {

    @NotBlank(message = "아이디를 입력하세요.")
    private String loginId;

    @NotBlank(message = "패스워드를 입력해주세요.")
    private String password;

    private Long failCount;

    @Builder
    public LoginCreate(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    // public void validate() {
    //     if (failCount > 5) {
    //         throw new InvalidRequest("title", "아이디/패스워드를 5회 이상 잘못 입력하였습니다..");
    //     }
    //     if ( loginId.contains( "")) {
    //         throw new InvalidRequest("loginId", "이미 존재하는 로그인 아이디입니다.");
    //     }
    // }
}
