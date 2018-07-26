package com.v.bean;

public class Delivery {
    private Integer id;

    private Integer userId;

    private String name;

    private String address;

    private String phone;

    private Integer phostcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getPhostcode() {
        return phostcode;
    }

    public void setPhostcode(Integer phostcode) {
        this.phostcode = phostcode;
    }
}