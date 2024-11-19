package com.market.otw.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserCreate {
    @NotBlank(message = "이름를 입력하세요.")
    private Long id;

    @NotBlank(message = "이름를 입력하세요.")
    private String userName;

    @NotBlank(message = "이메일을 입력하세요.")
    private String email;

    @NotBlank(message = "주소 입력해주세요.")
    private String address1;

    private String address2;

    @NotBlank(message = "핸드폰번호를 입력해주세요.")
    private String mobile;

    @Builder
    public UserCreate(Long id, String userName, String email, String address1, String address2, String mobile) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
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
