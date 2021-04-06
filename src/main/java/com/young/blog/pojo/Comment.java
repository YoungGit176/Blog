package com.young.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private long id;
    private String nikename;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;

    private Blog blog;

    private List<Comment> reolyComments = new ArrayList<>();
    private  Comment parentComment;
}
