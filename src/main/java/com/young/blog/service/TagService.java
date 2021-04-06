package com.young.blog.service;

import com.young.blog.pojo.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);
    int deleteTag(Tag tag);
    int updateTag(Tag tag);
    List<Tag> getAllTag();
    Tag getTagByName(Tag tag);
}
