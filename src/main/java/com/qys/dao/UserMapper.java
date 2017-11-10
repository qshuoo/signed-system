package com.qys.dao;

import org.springframework.stereotype.Repository;

import com.qys.pojo.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User getUserByNameAndPwd(User user);
}