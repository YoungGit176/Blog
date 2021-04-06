package com.young.blog;

import com.young.blog.pojo.Blog;
import com.young.blog.pojo.Tag;
import com.young.blog.pojo.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class testU {
    public static void main(String[] args) {
        List<Tag> tags= new ArrayList<>();
        tags.add(new Tag(1,null,null));
        tags.add(new Tag(2,null,null));
        tags.add(new Tag(3,null,null));
        System.out.println(tags.get(0));
        System.out.println(tags.get(1));
        System.out.println(tags.get(2));
        System.out.println(tags.size());
    }
}
