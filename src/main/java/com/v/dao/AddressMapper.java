package com.v.dao;

import java.util.List;

import com.v.bean.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> getAllAddress(String username);
    
    Address getAddressById(String addrId);
}