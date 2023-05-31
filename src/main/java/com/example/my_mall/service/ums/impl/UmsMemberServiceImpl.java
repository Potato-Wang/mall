package com.example.my_mall.service.ums.impl;

import com.example.my_mall.mbg.mapper.UmsMemberMapper;
import com.example.my_mall.mbg.model.UmsMember;
import com.example.my_mall.service.ums.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class UmsMemberServiceImpl implements UmsMemberService {
    //todo
    //security

    @Autowired
    private UmsMemberMapper umsMemberMapper;



    @Override
    public UmsMember getUserByName(String username) {
        return null;
    }

    @Override
    public UmsMember getUserById(Long id) {
        return null;
    }

    @Override
    public void register(String username, String password, String telephone, String authCode) {

    }

    @Override
    public String generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public void updatePassword(String telephone, String paswword, String authCode) {

    }

    @Override
    public UmsMember getCurrentMember() {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }
}
