package com.v.bean;

public class Item {
    private Integer id;

    private Integer saleInfoId;

    private Integer orderId;

    private Integer count;

    private String notes;

    private Byte state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleInfoId() {
        return saleInfoId;
    }

    public void setSaleInfoId(Integer saleInfoId) {
        this.saleInfoId = saleInfoId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}