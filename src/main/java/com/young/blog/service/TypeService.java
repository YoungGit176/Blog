package com.young.blog.service;

import com.young.blog.pojo.Type;

import java.util.List;

public interface TypeService {
    int saveType(Type type);
    int deleteType(Type type);
    int updateType(Type type);
    List<Type>getAllType();
    Type getTypeByName(Type type);
}
