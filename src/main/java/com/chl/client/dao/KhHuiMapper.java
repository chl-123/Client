package com.chl.client.dao;

import com.chl.client.entity.KhHui;

import java.util.List;
import java.util.Map;



public interface KhHuiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KhHui record);

    int insertSelective(KhHui record);

    KhHui selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KhHui record);

    int updateByPrimaryKey(KhHui record);
    List select(Integer id);
    List like(Map map);
    int getlikeTotal(Map map);
    List show(Map map);
    int getTotal();
    List xls(Map map);
}