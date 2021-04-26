package com.chl.client.dao;


import com.chl.client.entity.YhRoleroot;

public interface YhRolerootMapper {
    int insert(YhRoleroot record);

	int insertSelective(YhRoleroot record);
	int del(Integer id);
}