package com.chl.client.dao;

import com.chl.client.entity.YhRoot;

import java.util.List;



public interface YhRootMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(YhRoot record);

    int insertSelective(YhRoot record);

    YhRoot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YhRoot record);

    int updateByPrimaryKey(YhRoot record);
    List show();
}