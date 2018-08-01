package com.v.bean;

public class RecordWithBLOBs extends Record {
    private String prcs;

    private String mmry;

    private String note;

    public String getPrcs() {
        return prcs;
    }

    public void setPrcs(String prcs) {
        this.prcs = prcs == null ? null : prcs.trim();
    }

    public String getMmry() {
        return mmry;
    }

    public void setMmry(String mmry) {
        this.mmry = mmry == null ? null : mmry.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "RecordWithBLOBs [prcs=" + prcs + ", mmry=" + mmry + ", note=" + note + "]";
    }
    
}