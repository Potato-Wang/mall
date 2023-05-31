package com.example.my_mall.service.ums;

//用redis缓存一些数据

import com.example.my_mall.mbg.model.UmsMember;

public interface UmsMemberCacheService {

    //从缓存中删除用户
    void delMember(Long memberId);

    //从缓存中获取用户
    UmsMember getMember(String username);

    //将用户信息加入缓存
    void setMember(UmsMember member);

    //设置验证码
    void setAuthCode(String telephone, String authCode);

    //获取验证码
    String getAuthCode(String telephone);

}
