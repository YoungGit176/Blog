package com.young.blog.dao;

import com.young.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDao {
    int saveTag(Tag tag);
    int deleteTag(Tag tag);
    int updateTag(Tag tag);
    List<Tag> getAllTag();
    Tag getTagByName(Tag tag);
}
