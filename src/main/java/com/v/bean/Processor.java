package com.v.bean;

public class Processor {
    private Integer id;

    private String pd;

    private Double plPrice;

    private String pdesc;

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

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    @Override
    public String toString() {
        return "Processor [id=" + id + ", pd=" + pd + ", plPrice=" + plPrice + ", pdesc=" + pdesc + "]";
    }
    
    
}