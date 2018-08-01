package com.v.dao;

import com.v.bean.Bag;
import com.v.bean.BagKey;

public interface BagMapper {
    int deleteByPrimaryKey(BagKey key);

    int insert(Bag record);

    int insertSelective(Bag record);

    Bag selectByPrimaryKey(BagKey key);

    int updateByPrimaryKeySelective(Bag record);

    int updateByPrimaryKey(Bag record);
    
    int deleteBag(String username);
    
    int deleteById(String id);
}