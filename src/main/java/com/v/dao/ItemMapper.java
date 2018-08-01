package com.v.dao;

import com.v.bean.Item;
import com.v.bean.ItemKey;

public interface ItemMapper {
    int deleteByPrimaryKey(ItemKey key);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(ItemKey key);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}