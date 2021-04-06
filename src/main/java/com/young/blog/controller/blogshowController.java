package com.young.blog.controller;

import com.young.blog.pojo.Blog;
import com.young.blog.service.serviceImpl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class blogshowController {
    @Autowired
    BlogServiceImpl blogService;

    @RequestMapping("/blog")
    public String blog(Model model, Blog blog){
        blogService.updateBlog(blog);
        blog=blogService.getBlogByid(blog);
        model.addAttribute("blog",blog);
        System.out.println(blog);
        return "blog";
    }


}
