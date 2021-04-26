package com.chl.client.dao;

import com.chl.client.entity.YhRole;

import java.util.List;


public interface YhRoleMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(YhRole record);

    int insertSelective(YhRole record);

    YhRole selectByPrimaryKey(Integer id);
    int findSingle();
    int updateByPrimaryKeySelective(YhRole record);

    int updateByPrimaryKey(YhRole record);
    List show();
}