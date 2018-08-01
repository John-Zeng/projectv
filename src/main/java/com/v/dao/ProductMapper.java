package com.v.dao;

import java.util.List;

import com.v.bean.Product;
import com.v.bean.RecordIns;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> getAllProduct();
    
    List<RecordIns> getAll();
    
    Product getSpec(String name);
    
    Product getByName(String name);
    
    int deleteProductByName(String name);
    
    int updateProductByName(Product pro);
    
    Product getProductById(Integer id);
    
    Product getProductByName(String name);
}