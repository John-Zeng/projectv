package com.xxsen.ordersbag;

public class Bag {
    public void setImg(String img) {
        this.img = img;
    }
    
    public void setProd(String prod) {
        this.prod = prod;
    }
    
    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public void setInitPrice(float initPrice) {
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
    
    public float getInitPrice() {
        return initPrice;
    }
    
    public int getQuan() {
        return quan;
    }
    
    private String img, prod, spec;
    private float initPrice;
    private int quan;
}
