package com.mainpharmacy.laboratory.domain.entity;

public class Laboratory {
    private int id;
    private String namelab;
    private String codecity;
    public Laboratory() {
    }
    public int getId() {
        return id;
    }
    public Laboratory(int id, String namelab, String codecity) {
        this.id = id;
        this.namelab = namelab;
        this.codecity = codecity;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNamelab() {
        return namelab;
    }
    public void setNamelab(String namelab) {
        this.namelab = namelab;
    }
    public String getCodecity() {
        return codecity;
    }
    public void setCodecity(String codecity) {
        this.codecity = codecity;
    }

    
}
