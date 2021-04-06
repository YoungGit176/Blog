package com.young.blog.dao;

import com.young.blog.pojo.Blog;
import com.young.blog.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogAndTagDao {
    List<BlogAndTag> getAllBlogAndTag(Blog blog);
    int saveBlogAndTag(BlogAndTag blogAndTag);
    int deleteBlogAndTag(Blog blog);
    List<BlogAndTag> findBlogAndTag(Blog blog);
}
