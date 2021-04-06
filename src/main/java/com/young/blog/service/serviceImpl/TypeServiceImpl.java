package com.young.blog.service.serviceImpl;

import com.young.blog.dao.TypeDao;
import com.young.blog.pojo.Type;
import com.young.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public int deleteType(Type type) {
        return typeDao.deleteType(type);
    }

    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public Type getTypeByName(Type type) {
        return typeDao.getTypeByName(type);
    }
}
