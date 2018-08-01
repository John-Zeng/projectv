package com.v.bean;

public class Record {
    private Integer id;

    private String r_id;

    private String pd;

    private Double price;

    private Byte state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrId() {
        return r_id;
    }

    public void setrId(String rId) {
        this.r_id = rId == null ? null : rId.trim();
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd == null ? null : pd.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Record [id=" + id + ", rId=" + r_id + ", pd=" + pd + ", price=" + price + ", state=" + state + "]";
    }
    
    
}