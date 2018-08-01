package com.v.dao;

import com.v.bean.Processor;

public interface ProcessorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Processor record);

    int insertSelective(Processor record);

    Processor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Processor record);

    int updateByPrimaryKeyWithBLOBs(Processor record);

    int updateByPrimaryKey(Processor record);
}