package com.v.views.ordersbag;

public class Obag {
    public void setImg(String img) {
        this.img = img;
    }
    
    public void setProd(String prod) {
        this.prod = prod;
    }
    
    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public void setInitPrice(double initPrice) {
        this.initPrice = initPrice;
    }
    
    public void setQuan(int quan) {
        this.quan = quan;
    }
    
    public String getImg() {
        return img;
    }
    
    public String getProd() {
        return prod;
    }
    
    public String getSpec() {
        return spec;
    }
    
    public double getInitPrice() {
        return initPrice;
    }
    
    public int getQuan() {
        return quan;
    }
    
    
    
    
    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }


    @Override
    public String toString() {
        return "Obag [img=" + img + ", prod=" + prod + ", spec=" + spec + ", r_id=" + r_id + ", initPrice=" + initPrice
                + ", quan=" + quan + "]";
    }


    private String img, prod, spec, r_id;
    private double initPrice;
    private int quan;
}
