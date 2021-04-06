package com.young.blog.service.secrity;

import com.young.blog.dao.UserDao;
import com.young.blog.pojo.User;
import com.young.blog.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.LoginUser(s);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");

        }
        else {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
            System.out.println("管理员信息："+user1.getUsername()+"        "+user.getPassword()+"          "+user1.getAuthorities());
            return user1;
        }
    }
}
/*$2a$10$Eh2G5wDFO6YbJJlvoprtju9Fce6dGDtHbtGrZdir95w1XBbX8sOhm*/