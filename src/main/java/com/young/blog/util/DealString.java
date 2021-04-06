package com.young.blog.util;

import com.young.blog.pojo.Tag;

import java.util.ArrayList;
import java.util.List;

public class DealString {

    public List<Tag> toList(String tagIds){
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < tagIds.length(); i++) {
            if (tagIds.charAt(i) != ',') {
                tags.add(new Tag(tagIds.charAt(i)-'0',null,null));
            }
        }
        return tags;
    }
}
