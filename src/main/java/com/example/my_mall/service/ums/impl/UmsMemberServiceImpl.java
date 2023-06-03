package com.example.my_mall.service.ums.impl;

import com.example.my_mall.mbg.mapper.UmsMemberMapper;
import com.example.my_mall.mbg.model.UmsMember;
import com.example.my_mall.mbg.model.UmsMemberExample;
import com.example.my_mall.service.ums.UmsMemberCacheService;
import com.example.my_mall.service.ums.UmsMemberService;
import com.example.my_mall.utils.exception.ApiAssert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class UmsMemberServiceImpl implements UmsMemberService {
    //todo
    //security

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private UmsMemberCacheService umsMemberCacheService;



    @Override
    public UmsMember getUserByName(String username) {
        UmsMember umsMember = umsMemberCacheService.getMember(username);
        //存在缓存中
        if(umsMember!=null){
            return umsMember;
        }
        UmsMemberExample umsMemberExample = new UmsMemberExample();
        umsMemberExample.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = umsMemberMapper.selectByExample(umsMemberExample);
        if(!memberList.isEmpty()){
            UmsMember member =  memberList.get(0);
            umsMemberCacheService.setMember(member);
            return member;
        }
        return null;
    }

    @Override
    public UmsMember getUserById(Long id) {
        UmsMember umsMember = umsMemberMapper.selectByPrimaryKey(id);
        return umsMember;
    }

    @Override
    //加密
    public void register(String username, String password, String telephone, String authCode) {

    }

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; ++i ){
            sb.append(random.nextInt(10));
        }
        umsMemberCacheService.setAuthCode(telephone, sb.toString());
        return sb.toString();
    }

    @Override
    public void updatePassword(String telephone, String paswword, String authCode) {
        if(!verifyAuthCode(telephone, authCode)){
            ApiAssert.fail("验证码错误");
        }
        UmsMemberExample umsMemberExample = new UmsMemberExample();
        umsMemberExample.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = umsMemberMapper.selectByExample(umsMemberExample);
        if(memberList.isEmpty()){
            ApiAssert.fail("用户不存在");
        }
        UmsMember umsMember = memberList.get(0);
        //todo
        //加密
        umsMember.setPassword(paswword);
        umsMemberMapper.updateByPrimaryKeySelective(umsMember);
        umsMemberCacheService.delMember(umsMember.getId());

    }

    @Override
    //加密
    public UmsMember getCurrentMember() {
        return null;
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        umsMember.setIntegration(integration);
        umsMemberMapper.updateByPrimaryKeySelective(umsMember);
        //删除缓存中的数据
        umsMemberCacheService.delMember(id);
    }

    @Override
    //加密
    public String login(String username, String password) {

        return null;
    }

    @Override
    //加密
    public String refreshToken(String token) {
        return null;
    }

    private boolean verifyAuthCode(String telephone, String authCode){
        String code = umsMemberCacheService.getAuthCode(telephone);
        if(code==null || !authCode.equals(code)){
            return false;
        }
        return true;
    }
}
