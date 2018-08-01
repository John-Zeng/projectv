package com.v.service;

import java.util.List;

import com.v.bean.Address;
import com.v.bean.Bag;
import com.v.bean.Consumer;
import com.v.bean.Item;
import com.v.bean.Orders;
import com.v.bean.Product;
import com.v.bean.RecordIns;
import com.v.bean.RecordWithBLOBs;

public interface VService {

    public int insertRecord(RecordWithBLOBs r);

    public List<RecordWithBLOBs> getInBag(String username);

    public List<Consumer> getAllConsumer();

    public List<Address> getAllAddrss(String username);

    public int insertBag(Bag bag);

    public List<Product> getAllProduct();

    public List<RecordIns> getAllRecordIns();

    public Product getByName(String name);

    public Product getSpec(String name);
    
    public int deleteBag(String username);
    
    public Address getAddressById(String addrId);
    
    public int insertOrders(Orders orders);
    
    public int insertItem(Item item);
    
    public List<Orders> getUserOrders(String username);
    
    public String genSalt();
    
    public String hashPwd(Consumer c);
    
    public RecordWithBLOBs getRecordById(String rId);
    
    public int insertUser(Consumer c);
    
    public Consumer getUserByName(String username);
    
    public int deleteById(String rid);
    
    public int insertAddr(Address addr);
    
    public int deleteProductByName(String name);
    
    public int insertProduct(Product pro);
    
    public int updateProductByName(Product pro);
    
    public int deleteConsumerByName(String username);
    
    public int insertConsumer(Consumer consumer);
    
    public int updateConsumerByUsername(Consumer consumer);
    
    public Product getProductById(Integer id);
    
    public int updateProductById(Product id);
    
    public Product getProductByName(String pdt);
}
