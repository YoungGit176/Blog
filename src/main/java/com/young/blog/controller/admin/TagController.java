package com.young.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.blog.pojo.Tag;
import com.young.blog.service.serviceImpl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagServiceImpl tagService;


    @RequestMapping("/tags")
    public String tags(Model model,
                        @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize,"id");
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tagService.getAllTag());
        if (pageInfo.getPageNum()==0){
            model.addAttribute("message","标签为0");
        }
        model.addAttribute("page",pageInfo);
        return "admin/tags";
    }

    @RequestMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }


    @RequestMapping("/tags/inputTags")
    public String inputTags(Tag tag, Model model){
        Tag tag1=tagService.getTagByName(tag);
        if (tag1 == null){
            List<Tag> list = tagService.getAllTag();
            if (list==null){
                tag.setId(1);
                list.add(tag);
            }
            else{
                int userforid = 1;
                ListIterator<Tag> listIterator = list.listIterator();
                while(listIterator.hasNext()){
                    if (listIterator.next().getId() != userforid){
                        tag.setId(userforid);
                        break;
                    }
                    else {
                        userforid++;
                    }
                }
                if (tag.getId() == 0){
                    tag.setId(userforid);
                }
            }
            tagService.saveTag(tag);
        } else{
            model.addAttribute("message","此类型已经存在");
            return "admin/tags-input";
        }
        return "redirect:/admin/tags";
    }

    @RequestMapping("/tags/editTag")
    public String editTag(Model model,
                           @RequestParam(value = "id",defaultValue = "0") int id){
        Tag tag = new Tag();
        tag.setId(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    @RequestMapping("/tags/editTagsByid")
    public String editTagsByid(Tag tag,Model model){
        if (tagService.getTagByName(tag) != null){
            model.addAttribute("tag",tag);
            model.addAttribute("message","此类型已存在");
            return "admin/tags-input";
        }else {
            tagService.updateTag(tag);
            return "redirect:/admin/tags";
        }
    }

    @RequestMapping("/tags/deleteTag")
    public String deleteTag(Model model,
                             @RequestParam(value = "id",defaultValue = "0") int id){
        Tag tag = new Tag();
        tag.setId(id);
        tagService.deleteTag(tag);
        return "redirect:/admin/tags";
    }
}
