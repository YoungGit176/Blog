package com.young.blog.dao;

import com.young.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDao {
    User LoginUser(String username);
}
