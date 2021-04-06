package com.young.blog.service;

import com.young.blog.pojo.Blog;
import com.young.blog.pojo.BlogQuery;

import java.util.List;

public interface BlogService {
    int saveBlog(Blog blog);
    int deleteBlog(Blog blog);
    int updateBlog(Blog blog);
    List<Blog> getAllBlog();
    Blog getBlogByName(Blog blog);
    Blog getBlogByid(Blog blog);
    List<Blog> findTypeAndBlog(BlogQuery blogQuery);
    List<Blog> getBlogByTitle(Blog blog);
}
