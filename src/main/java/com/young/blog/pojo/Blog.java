package com.young.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Blog  implements Serializable {

    private int id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private int views;
    private String appreciation;
    private String shareStatement;
    private String commentable;
    private String published;
    private String recommend;
    private Date updateTime;
    private String tagIds;
    private String description;

    private Type type;
    private List<Tag> tags = new ArrayList<>();
    private User user;
    private List<Comment> comments = new ArrayList<>();
}
