package com.young.blog.service.serviceImpl;

import com.young.blog.dao.UserDao;
import com.young.blog.pojo.User;
import com.young.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username) {
        System.out.println(username);
        User user = userDao.LoginUser(username);
        return user;
    }
}
