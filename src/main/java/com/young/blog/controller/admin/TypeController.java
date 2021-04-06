package com.young.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.young.blog.pojo.Type;
import com.young.blog.service.serviceImpl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeServiceImpl typeService;

    @RequestMapping("/types")
    public String types(Model model,
                        @RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize,"id");
        PageInfo<Type> pageInfo = new PageInfo<Type>(typeService.getAllType());
        if (pageInfo.getPageNum()==0){
            model.addAttribute("message","种类为0");
        }
        model.addAttribute("page",pageInfo);
        return "admin/types";
    }

    @RequestMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }


    @RequestMapping("/types/inputTypes")
    public String inputTypes(Type type, Model model){
        Type type1=typeService.getTypeByName(type);
        if (type1 == null){
            List<Type> list = typeService.getAllType();
            if (list==null){
                type.setId(1);
                list.add(type);
            }
            else{
                int userforid = 1;
                ListIterator<Type> listIterator = list.listIterator();
                while(listIterator.hasNext()){
                    if (listIterator.next().getId() != userforid){
                        type.setId(userforid);
                        break;
                    }
                    else {
                        userforid++;
                    }
                }
                if (type.getId() == 0){
                    type.setId(userforid);
                }
            }
            typeService.saveType(type);
        } else{
            model.addAttribute("message","此类型已经存在");
            return "admin/types-input";
        }
        return "redirect:/admin/types";
    }

    @RequestMapping("/types/editType")
    public String editType(Model model,
                           @RequestParam(value = "id",defaultValue = "0") int id){
        Type type = new Type();
        type.setId(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    @RequestMapping("/types/editTypesByid")
    public String editTypesByid(Type type,Model model){
        if (typeService.getTypeByName(type) != null){
            model.addAttribute("type",type);
            model.addAttribute("message","此类型已存在");
            return "admin/types-input";
        }else {
            typeService.updateType(type);
            return "redirect:/admin/types";
        }
    }

    @RequestMapping("/types/deleteType")
    public String deleteType(Model model,
                           @RequestParam(value = "id",defaultValue = "0") int id){
        Type type = new Type();
        type.setId(id);
        typeService.deleteType(type);
        return "redirect:/admin/types";
    }
}
