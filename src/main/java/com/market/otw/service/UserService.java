package com.market.otw.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.market.otw.domain.User;
import com.market.otw.domain.UserEditor;
import com.market.otw.exception.InvalidMessageException;
import com.market.otw.repository.UserRepository;
import com.market.otw.request.user.Login;
import com.market.otw.request.user.UserCreate;
import com.market.otw.request.user.UserEdit;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void duplicateLoginId( String loginId) {
        if( userRepository.existsByLoginId( loginId)) {
            throw new InvalidMessageException( "중복된 아이디가 존재합니다.");
        }
    }

    /**
     *
     * @param userCreate
     * 유저 생성
     */
    public void create(UserCreate userCreate) {
        String loginId = userCreate.getLoginId();
        duplicateLoginId( loginId);
        User user = User.builder()
            .loginId( loginId)
            .password( userCreate.getPassword())
            .build();
        userRepository.save( user);
    }

    /**
     *
     * @param login
     * 유저 로그인 -> 추후 security 부분에서 추가적으로 작업
     */
    public void login(Login login) {
        String loginId = login.getLoginId();
        String password = login.getPassword();
        User user = userRepository.findByLoginId( loginId).orElse( null);
        if( user == null || ! userRepository.existsByLoginIdAndPassword( loginId, password)) {
            if( userRepository.existsByLoginId( loginId)) {
                if( user.getFailCount() > 5) {
                    throw new InvalidMessageException( "비밀번호가 5회이상 틀려 계정이 잠겼습니다..");
                }
                editFailCount( user, user.getFailCount()+1);
                throw new InvalidMessageException( "아이디/비밀번호가 틀렸습니다.");
            }else {
                throw new InvalidMessageException( "아이디가 존재하지 않습니다.");
            }
        }
        editFailCount( user, 0L);
        userRepository.findByLoginIdAndPassword( loginId, password);
    }

    /**
     *
     * 비밀번호 틀린 횟수 증가 및 초기화
     */
    public void editFailCount( User user, Long failCount) {
        UserEditor.UserEditorBuilder userEditBuilder = user.toEditor();
        UserEditor userEditor = userEditBuilder.failCount( failCount).build();
        user.edit( userEditor);
    }

    /**
     *
     * @param userEdit
     * 유저 수정
     */
    public void edit( UserEdit userEdit) {
        String loginId = userEdit.getLoginId();
        User user = userRepository.findByLoginId( loginId).orElse( null);
        String password = userEdit.getPassword();
        isValidUser(user, loginId, password, "비밀번호를 확인해주세요.");
        UserEditor.UserEditorBuilder userEditBuilder = user.toEditor();
        UserEditor userEditor = userEditBuilder
            .userName(userEdit.getUserName())
            .email(userEdit.getEmail())
            .address1(userEdit.getAddress1())
            .address2(userEdit.getAddress2())
            .mobile(userEdit.getMobile())
            .build();
        // String password, String userName, String email, String address1, String address2, String mobile, Long failCount, String regisnDate
        user.edit( userEditor);
    }

    /**
     *
     * 유저 탈퇴
     */
    public void resign(UserEdit userEdit) {
        String loginId = userEdit.getLoginId();
        User user = userRepository.findByLoginId( loginId).orElse( null);
        String password = userEdit.getPassword();
        isValidUser(user, loginId, password, "아이디/비밀번호가 틀렸습니다.");
        UserEditor.UserEditorBuilder userEditBuilder = user.toEditor();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatedNow = now.format(formatter);
        UserEditor userEditor = userEditBuilder
            .regisnDate( formatedNow)
            .build();
        user.edit( userEditor);
    }

    /**
     *
     * 유저 탈퇴 취소
     */
    public void resetResignDate(UserEdit userEdit) {
        String loginId = userEdit.getLoginId();
        User user = userRepository.findByLoginId( loginId).orElse( null);
        UserEditor.UserEditorBuilder userEditBuilder = user.toEditor();
        UserEditor userEditor = userEditBuilder
            .regisnDate( null)
            .build();
        user.edit( userEditor);
    }

    /**
     *
     * 존재하는 유저인지 체크
     */
    private void isValidUser( User user, String loginId, String password, String errMsg) {
        if( user != null && ! userRepository.existsByLoginIdAndPassword( loginId, password)) {
            if( userRepository.existsByLoginId( loginId)) {
                throw new InvalidMessageException( errMsg);
            }
        }
    }

    /**
     *
     * 유효기간 지난 유저 삭제
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void delete() {
        LocalDate now = LocalDate.now().minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String oneMonthAgo = now.format(formatter);
        userRepository.deleteByResignDateBefore( oneMonthAgo);
    }
}
