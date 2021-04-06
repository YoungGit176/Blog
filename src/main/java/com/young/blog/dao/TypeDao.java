package com.young.blog.dao;

import com.young.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {
    int saveType(Type type);
    int deleteType(Type type);
    int updateType(Type type);
    List<Type> getAllType();
    Type getTypeByName(Type type);
}
