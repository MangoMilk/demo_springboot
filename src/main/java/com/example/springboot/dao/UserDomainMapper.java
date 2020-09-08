package com.example.springboot.dao;

import com.example.springboot.domain.UserDomain;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Integer uid);

    UserDomain selectByPhone(String phone);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
}