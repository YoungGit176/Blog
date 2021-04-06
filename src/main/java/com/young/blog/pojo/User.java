package com.young.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String role;
    private Date createTime;
    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();

}
