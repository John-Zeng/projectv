package com.v.dao;

import java.util.List;

import com.v.bean.Record;
import com.v.bean.RecordWithBLOBs;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordWithBLOBs record);

    int insertSelective(RecordWithBLOBs record);

    RecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

    int updateByPrimaryKey(Record record);
    
    int insertSelective(Record record);
    
    List<RecordWithBLOBs> getInBag(String username);
    
    RecordWithBLOBs getRecordById(String rId);

}