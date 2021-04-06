package com.young.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.blog.pojo.*;
import com.young.blog.service.serviceImpl.BlogServiceImpl;
import com.young.blog.service.serviceImpl.TagServiceImpl;
import com.young.blog.service.serviceImpl.TypeServiceImpl;
import com.young.blog.util.DealString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogServiceImpl blogServicel;

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    TagServiceImpl tagService;

    @RequestMapping("/blogs")
    public String blogs(Model model,
                        @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "4") int pageSize){
        List<Type> typeList = typeService.getAllType();
        model.addAttribute("types",typeList);
        PageHelper.startPage(pageNum,pageSize,"id");
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogServicel.getAllBlog());
        model.addAttribute("blogs",blogPageInfo);
        return "admin/blogs";
    }

    @RequestMapping("/blogs/search")
    public String search(BlogQuery blog,
                         Model model,
                         @RequestParam(value = "page",defaultValue = "0") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "4") int pageSize){
        PageHelper.startPage(pageNum,pageSize,"id");
        List<Blog> blogs = blogServicel.findTypeAndBlog(blog);
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs);
        model.addAttribute("blogs",blogPageInfo);
        return "admin/blogs :: blogList";
    }

    @RequestMapping("/blogs/input")
    public String input(Model model){
        List<Tag> tags = tagService.getAllTag();
        List<Type> types = typeService.getAllType();
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);

        return "admin/blogs-input";
    }

    @RequestMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes attributes, HttpSession session){
        if (blog.getId()!=0){
            blogServicel.deleteBlog(blog);
        }else {
            List<Blog> list = blogServicel.getAllBlog();
            if (list==null){
                blog.setId(1);
            }
            else{
                int userforid = 1;
                ListIterator<Blog> listIterator = list.listIterator();
                while(listIterator.hasNext()){
                    if (listIterator.next().getId() != userforid){
                        blog.setId(userforid);
                        break;
                    }
                    else {
                        userforid++;
                    }
                }
                if (blog.getId() == 0){
                    blog.setId(userforid);
                }
            }
            blog.setViews(0);
        }
        Date date = new Date();
        blog.setUpdateTime(new java.sql.Date(date.getTime()));
        DealString dealString = new DealString();
        blog.setTags(dealString.toList(blog.getTagIds()));
        blog.setUser((User) session.getAttribute("user"));
        /*保存*/
        blogServicel.saveBlog(blog);
        return "redirect:/admin/blogs";
    }

    @RequestMapping("/blogs/delete")
    public String delete(Model model,
                         @RequestParam(value = "id",defaultValue = "0") int id){
        Blog blog = new Blog();
        blog.setId(id);
        blogServicel.deleteBlog(blog);
        return "redirect:/admin/blogs";
    }

    @RequestMapping("/blogs/inputedit")
    public String inputedit(Model model,
                            @RequestParam(value = "id",defaultValue = "0") int id){
        Blog blog = new Blog();
        blog.setId(id);
        List<Tag> tags = tagService.getAllTag();
        List<Type> types = typeService.getAllType();
        System.out.println("-----------------------------");
        System.out.println(blogServicel.getBlogByid(blog));
        model.addAttribute("blog",blogServicel.getBlogByid(blog));
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        return "admin/blogs-input";
    }
}
