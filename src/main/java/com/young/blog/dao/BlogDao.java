package com.young.blog.dao;

import com.young.blog.pojo.Blog;
import com.young.blog.pojo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDao {
    int saveBlog(Blog blog);
    int deleteBlog(Blog blog);
    int updateTag(Blog blog);
    List<Blog> getAllBlog();
    Blog getBlogByName(Blog blog);
    Blog getBlogByid(Blog blog);
    List<Blog> findTypeAndBlog(BlogQuery blogQuery);
    List<Blog> getBlogByTitle(Blog blog);
    int updateBlog(Blog blog);
}
