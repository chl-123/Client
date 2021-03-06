package com.chl.client.dao;

import com.chl.client.entity.Logs;

import java.util.List;
import java.util.Map;



public interface LogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
    List show(Map map);
	int getTotal();
}