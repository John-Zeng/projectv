package com.v.dao;

import java.util.List;

import com.v.bean.Consumer;

public interface ConsumerMapper {
    int deleteByPrimaryKey(String username);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    Consumer selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);
    
    List<Consumer> getAllComsumer();
    
    String genSalt();
    
    String genSaltedPwd(Consumer c);
    
    Consumer getUserByName(String username);
    
    int deleteConsumerByName(String username);
    
    int insertConsumer(Consumer cons);
    
    int updateConsumer(Consumer cons);
}