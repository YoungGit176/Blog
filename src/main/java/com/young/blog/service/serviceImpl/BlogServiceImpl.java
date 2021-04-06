package com.young.blog.service.serviceImpl;

import com.young.blog.dao.BlogAndTagDao;
import com.young.blog.dao.BlogDao;
import com.young.blog.pojo.Blog;
import com.young.blog.pojo.BlogAndTag;
import com.young.blog.pojo.BlogQuery;
import com.young.blog.pojo.Tag;
import com.young.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    BlogAndTagDao blogAndTagDao;

    @Override
    public int saveBlog(Blog blog) {
        int count=0;
        if (blog.getRecommend()==null){
            blog.setRecommend("false");
        }
        else{
            blog.setRecommend("true");
        }if (blog.getAppreciation()==null){
            blog.setAppreciation("false");
        }
        else{
            blog.setAppreciation("true");
        }if (blog.getCommentable()==null){
            blog.setCommentable("false");
        }
        else{
            blog.setCommentable("true");
        }if (blog.getShareStatement()==null){
            blog.setShareStatement("false");
        }
        else{
            blog.setShareStatement("true");
        }if (blog.getPublished()==null){
            blog.setPublished("false");
        }
        else{
            blog.setPublished("true");
        }
        int flag=blogDao.saveBlog(blog);
        List<Tag> tags = blog.getTags();
        List<BlogAndTag> blogAndTags = new ArrayList<>();
        blogAndTags = blogAndTagDao.getAllBlogAndTag(blog);
        int j=0;
        int m=0;
        while (m<tags.size()){
            for (int i=0;i<blogAndTags.size();i++){
                if (blogAndTags.get(i).getId()==count+1){
                    j=1;
                    break;
                }
            }
            if(j==0){
                blogAndTagDao.saveBlogAndTag(new BlogAndTag(count+1,blog.getId(),tags.get(m).getId()));
                m++;
            }
            j=0;
            count++;
        }
        return flag;
    }


    @Override
    public int deleteBlog(Blog blog) {
        blogAndTagDao.deleteBlogAndTag(blog);
        return blogDao.deleteBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public Blog getBlogByName(Blog blog) {
        return blogDao.getBlogByName(blog);
    }

    @Override
    public Blog getBlogByid(Blog blog) {
        return blogDao.getBlogByid(blog);
    }

    @Override
    public List<Blog> findTypeAndBlog(BlogQuery blogQuery) {
        return blogDao.findTypeAndBlog(blogQuery);
    }

    @Override
    public List<Blog> getBlogByTitle(Blog blog) {
        return blogDao.getBlogByTitle(blog);
    }


}
