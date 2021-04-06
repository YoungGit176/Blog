package com.young.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.blog.NotFoundExeception;
import com.young.blog.pojo.Blog;
import com.young.blog.pojo.Type;
import com.young.blog.service.serviceImpl.BlogServiceImpl;
import com.young.blog.service.serviceImpl.TagServiceImpl;
import com.young.blog.service.serviceImpl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class indexController {

    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    TagServiceImpl tagService;

    @RequestMapping({"/index","","/"})
    public String index(Model model,
                        @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "4") int pageSize){
        PageHelper.startPage(pageNum,pageSize,"updateTime");
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogService.getAllBlog());
        model.addAttribute("page",blogPageInfo);
        return "index";
    }
    @RequestMapping("/search")
    public String search(Model model,Blog blog){
        if (blog.getTitle().isEmpty()){
            return "redirect:/blogs/index";
        }
        List<Blog> blogList = blogService.getBlogByTitle(blog);
        model.addAttribute("page",blogList);
        System.out.println(blog);
        return "search";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
