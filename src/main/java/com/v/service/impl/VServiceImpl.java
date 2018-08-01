package com.v.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v.bean.Address;
import com.v.bean.Bag;
import com.v.bean.Consumer;
import com.v.bean.Item;
import com.v.bean.Orders;
import com.v.bean.Product;
import com.v.bean.RecordIns;
import com.v.bean.RecordWithBLOBs;
import com.v.dao.AddressMapper;
import com.v.dao.BagMapper;
import com.v.dao.ConsumerMapper;
import com.v.dao.ItemMapper;
import com.v.dao.OrdersMapper;
import com.v.dao.ProductMapper;
import com.v.dao.RecordMapper;
import com.v.service.VService;

@Service("vservice")
public class VServiceImpl implements VService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private BagMapper bagMapper;
    @Autowired
    private ConsumerMapper consumerMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Consumer> getAllConsumer() {
        return consumerMapper.getAllComsumer();
    }

    @Override
    public List<RecordWithBLOBs> getInBag(String username) {
        return recordMapper.getInBag(username);
    }

    @Override
    public int insertRecord(RecordWithBLOBs r) {
        return recordMapper.insert(r);
    }

    @Override
    public List<Address> getAllAddrss(String username) {
        return addressMapper.getAllAddress(username);
    }

    @Override
    public int insertBag(Bag bag) {
        return bagMapper.insert(bag);
    }

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public List<RecordIns> getAllRecordIns() {
        return productMapper.getAll();
    }

    @Override
    public Product getByName(String name) {
        return productMapper.getByName(name);
    }

    @Override
    public Product getSpec(String name) {
        return productMapper.getSpec(name);
    }

    @Override
    public int deleteBag(String username) {
        return bagMapper.deleteBag(username);
    }

    @Override
    public Address getAddressById(String addrId) {
        return addressMapper.getAddressById(addrId);
    }

    @Override
    public int insertOrders(Orders orders) {
        return ordersMapper.insertSelective(orders);
    }

    @Override
    public int insertItem(Item item) {
        return itemMapper.insertSelective(item);
    }

    @Override
    public List<Orders> getUserOrders(String username) {
        return ordersMapper.getUserOrders(username);
    }

    @Override
    public String genSalt() {
        return consumerMapper.genSalt();
    }

    @Override
    public String hashPwd(Consumer c) {
        return consumerMapper.genSaltedPwd(c);
    }

    @Override
    public RecordWithBLOBs getRecordById(String rId) {
        return recordMapper.getRecordById(rId);
    }

    @Override
    public int insertUser(Consumer c) {
        return consumerMapper.insertSelective(c);
    }

    @Override
    public Consumer getUserByName(String username) {
        return consumerMapper.getUserByName(username);
    }

    @Override
    public int deleteById(String rid) {
        return bagMapper.deleteById(rid);
    }

    @Override
    public int insertAddr(Address addr) {
        return addressMapper.insertSelective(addr);
    }

    @Override
    public int deleteProductByName(String name) {
        return productMapper.deleteProductByName(name);
    }

    @Override
    public int insertProduct(Product pro) {
        return productMapper.insertSelective(pro);
    }

    @Override
    public int updateProductByName(Product pro) {
        return productMapper.updateProductByName(pro);
    }

    @Override
    public int deleteConsumerByName(String username) {
        return consumerMapper.deleteConsumerByName(username);
    }

    @Override
    public int insertConsumer(Consumer consumer) {
        return consumerMapper.insertSelective(consumer);
    }

    @Override
    public int updateConsumerByUsername(Consumer consumer) {
        return consumerMapper.updateByPrimaryKeySelective(consumer);
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    @Override
    public int updateProductById(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Product getProductByName(String pdt) {
        return productMapper.getProductByName(pdt);
    }
    
    
    
}
