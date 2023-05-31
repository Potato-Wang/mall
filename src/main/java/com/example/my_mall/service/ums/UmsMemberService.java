package com.example.my_mall.service.ums;

import com.example.my_mall.mbg.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

public interface UmsMemberService {

    //
    UmsMember getUserByName(String username);

    //
    UmsMember getUserById(Long id);

    //
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    //
    String generateAuthCode(String telephone);

    //
    @Transactional
    void updatePassword(String telephone, String paswword, String authCode);

    //
    UmsMember getCurrentMember();

    //todo
    //UserDetails loadUserByUsername(String username);

    //
    String login(String username, String password);

    //
    String refreshToken(String token);
}
