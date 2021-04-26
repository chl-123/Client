package com.chl.client.dao;

import com.chl.client.entity.Log;

import java.util.List;
import java.util.Map;



public interface LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);
    Log findSingle();
    Log selectByPrimaryKey(Integer id);
    Log select(String id);
    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
    List show(Map map);
	int getTotal();
	List like(Map map);
	int getlikeTotal(Map map);
}