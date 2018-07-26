package com.v.bean;

public class Item {
    private Integer id;

    private Integer count;

    private Integer orderId;

    private Integer saleInfoId;

    private Byte state;

    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSaleInfoId() {
        return saleInfoId;
    }

    public void setSaleInfoId(Integer saleInfoId) {
        this.saleInfoId = saleInfoId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
}