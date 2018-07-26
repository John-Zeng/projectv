package com.v.bean;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer orderId;

    private Integer consumerId;

    private Integer receiverDeliveryInfoId;

    private Date creationTime;

    private Integer total;

    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getReceiverDeliveryInfoId() {
        return receiverDeliveryInfoId;
    }

    public void setReceiverDeliveryInfoId(Integer receiverDeliveryInfoId) {
        this.receiverDeliveryInfoId = receiverDeliveryInfoId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
}