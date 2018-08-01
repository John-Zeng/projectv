package com.v.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.v.bean.Address;
import com.v.bean.Consumer;
import com.v.bean.Memory;
import com.v.bean.Orders;
import com.v.bean.Processor;
import com.v.bean.Product;
import com.v.bean.Record;
import com.v.bean.RecordIns;
import com.v.bean.RecordWithBLOBs;
import com.v.service.VService;

public class MyTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

    private ClassPathXmlApplicationContext getContext() {
        return (ClassPathXmlApplicationContext) ac;
    }

  
    @Test
    public void testVService() {
        
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        VService vservice = (VService) ac.getBean("vservice");
        
        System.out.println(vservice.getProductById(13));
        List<Product> p = vservice.getAllProduct();
        for(Product pd :p) {
            System.out.println(pd);
        }
//        Product p = new Product();
//        p.setName("Cmac");
//        System.out.println(vservice.insertProduct(p));
//        p.setImage("cmac.jpg");
//        System.out.println(vservice.updateProductByName(p));
//        List<Product> items = vservice.getAllProduct();
//        for(Product pro : items) {
//            System.out.println(pro);
//        }
         
//        List<RecordWithBLOBs> recordlist = vservice.getInBag("kenny");
//        for(Record re : recordlist) {
//            System.out.println(re);
//        }
        
//        List<Address> l = vservice.getAllAddrss("kenny");
//        System.out.println(l);
        
//        Address address  = new Address();
//        address.setAddrId("123");
//        address.setName("na");
//        address.setPhone("123456788");
//        address.setPostcode("321");
//        address.setUsername("kenny");
//        
//        vservice.insertAddr(address);
        
        
//        System.out.println(vservice.deleteById("1ffdbe54bc"));
//        
//        
//        List<RecordWithBLOBs> inBag = vservice.getInBag("kenny");
//        for(RecordWithBLOBs record:inBag) {
//            System.out.println(record.getPd() +"=" +record.getrId()+"="+record.getPrice());
//            System.out.println(record);
//        }
        
//        Product p = vservice.getSpec("Macbook");
//        List<Memory> mmry = p.getMemories();
//        List<Processor> proc = p.getProcessors();
//        System.out.println(p);
//        for(int i= 0; i<2;i++) {
//            
//            System.out.println(mmry.get(i).toString());
//            System.out.println(proc.get(i).toString());
//        }
        
//        System.out.println(vservice.genSalt());
//        Consumer c = new Consumer();
//        c.setPassword("123");
//        c.setSalt(vservice.genSalt());
//        System.out.println(vservice.hashPwd(c));
//        List<RecordWithBLOBs> relist = vservice.getInBag("Mary");
//        for (RecordWithBLOBs rewb : relist) {
//            System.out.println(rewb);
//        }
//
//        List<Consumer> allConsumer = vservice.getAllConsumer();
//        for (Consumer con : allConsumer) {
//            System.out.println(con);
//        }
//
//        List<Address> allAddrss = vservice.getAllAddrss("Mary");
//        for (Address addr : allAddrss) {
//            System.out.println(addr);
//        }
//
//        List<Product> allProduct = vservice.getAllProduct();
//        for (Product pd : allProduct) {
//            System.out.println(pd);
//        }
//
//        List<RecordIns> allRecordIns = vservice.getAllRecordIns();
//        for (RecordIns ri : allRecordIns) {
//            System.out.println(ri);
//        }
//
//        Product pdByname = vservice.getByName("iMac");
//        System.out.println(pdByname);
//
//        List<RecordWithBLOBs> recordInBag = vservice.getInBag("Mary");
//        for (RecordWithBLOBs rwb : recordInBag) {
//            System.out.println(rwb);
//        }
//
//        Product spec = vservice.getSpec("iMac");
//        List<Memory> memories = spec.getMemories();
//        List<Processor> processors = spec.getProcessors();
//        System.out.println(spec);
//        for (int i = 0; i < memories.size(); i++) {
//            System.out.println(memories.get(i));
//            System.out.println(processors.get(i));
//        }
//
//        // RecordWithBLOBs rec = new RecordWithBLOBs();
//        // rec.setrId("98764");
//        // rec.setMmry("8GB 2400MHz DDR4 memory");
//        // rec.setPrcs("3.8GHz quad-core 7th-generation#Intel Core i5 processor,#Turbo
//        // Boost up to 4.2GHz");
//        // rec.setPd("iMac");
//        // rec.setPrice((double) 2299);
//        // int r1 = vservice.insertRecord(rec);
//        // Bag bag = new Bag();
//        // bag.setUsername("Mary");
//        // bag.setrId("98764");
//        // bag.setCount(2);
//        // int r2 = vservice.insertBag(bag);
//
//        int dlb = vservice.deleteBag("Mary");
//        System.out.println(dlb);
//
//        Address addressById = vservice.getAddressById("321");
//        System.out.println(addressById);

//        Orders od = new Orders();
//        od.setAddrId("398");
//        od.setoId("456");
//        od.setTotal((double) 12345);
//        od.setUsername("May");
//        int iod = vservice.insertOrders(od);
//        System.out.println("insert into orders?:" +iod);
//        
//        Item item = new Item();
//        item.setoId("456");
//        item.setrId("123");
//        item.setQuantity(3);
//        int iim = vservice.insertItem(item);
//        System.out.println(iim);
        
        List<Orders> orderList = vservice.getUserOrders("May");
        for(Orders o:orderList) {
            
            System.out.println("order is:"+o);
            System.out.println("address is:"+o.getAddress());
            List<Record> o_r = o.getRecords();
            System.out.println("Items:");
            for(Record rec : o_r) {
                System.out.println("item is:"+rec);
            }
        }
    }
}
