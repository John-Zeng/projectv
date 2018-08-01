package com.v.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RecordIns implements Serializable, Cloneable {
    private Integer id;
    private String name;
    private String image;
    private String process;
    private String memory;
    private String moreDesc;
    private String price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMoreDesc() {
        return moreDesc;
    }

    public void setMoreDesc(String moreDesc) {
        this.moreDesc = moreDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isPersisted() {
        return id != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.id == null) {
            return false;
        }

        if (obj instanceof RecordIns && obj.getClass().equals(getClass())) {
            return this.id.equals(((RecordIns) obj).id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (id == null ? 0 : id.hashCode());
        return hash;
    }

    @Override
    public RecordIns clone() throws CloneNotSupportedException {
        return (RecordIns) super.clone();
    }

    @Override
    public String toString() {
        return "RecordIns [id=" + id + ", name=" + name + ", image=" + image + ", process=" + process + ", memory="
                + memory + ", moreDesc=" + moreDesc + ", price=" + price + "]";
    }

}