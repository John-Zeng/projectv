package com.v.dao;

import com.v.bean.Cart;
import com.v.bean.CartKey;

public interface CartMapper {
    int deleteByPrimaryKey(CartKey key);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(CartKey key);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}