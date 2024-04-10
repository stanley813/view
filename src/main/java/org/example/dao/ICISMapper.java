package org.example.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ICISMapper {
    List<Map> query(Map m);
}
