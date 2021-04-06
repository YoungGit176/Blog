package com.young.blog.service.serviceImpl;

import com.young.blog.dao.TagDao;
import com.young.blog.pojo.Tag;
import com.young.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao tagDao;
    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public int deleteTag(Tag tag) {
        return tagDao.deleteTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    public Tag getTagByName(Tag tag) {
        return tagDao.getTagByName(tag);
    }
}
