package com.v.views.ordersbag;

import java.util.Date;

public class Order {
    public String getSeller() {
        return seller;
    }
    
    public String getId() {
        return id;
    }
    
    public String getItem() {
        return item;
    }
    
    public Date getDate() {
        return date;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public void setSeller(String seller) {
        this.seller = seller;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setItem(String item) {
        this.item = item;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    private String seller, item, id, detail;
    private Date date;
}
