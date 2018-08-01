package com.v.bean;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private String oId;

    private Date odTime;

    private String username;

    private String addrId;

    private Double total;
    
    private List<Record> records; 
    
    private Address address;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public Date getOdTime() {
        return odTime;
    }

    public void setOdTime(Date odTime) {
        this.odTime = odTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId == null ? null : addrId.trim();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", oId=" + oId + ", odTime=" + odTime + ", username=" + username + ", addrId="
                + addrId + ", total=" + total + ", address=" + address + "]";
    }
    
    
}