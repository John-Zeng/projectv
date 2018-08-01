package com.v.bean;

public class Memory {
    private Integer id;

    private String pd;

    private Double plPrice;

    private String mdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd == null ? null : pd.trim();
    }

    public Double getPlPrice() {
        return plPrice;
    }

    public void setPlPrice(Double plPrice) {
        this.plPrice = plPrice;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc == null ? null : mdesc.trim();
    }

    @Override
    public String toString() {
        return "Memory [id=" + id + ", pd=" + pd + ", plPrice=" + plPrice + ", mdesc=" + mdesc + "]";
    }
    
    
}