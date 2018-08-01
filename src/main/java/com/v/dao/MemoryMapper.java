package com.v.dao;

import com.v.bean.Memory;

public interface MemoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Memory record);

    int insertSelective(Memory record);

    Memory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Memory record);

    int updateByPrimaryKeyWithBLOBs(Memory record);

    int updateByPrimaryKey(Memory record);
}