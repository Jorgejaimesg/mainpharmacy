package com.mainpharmacy.city.domain.entity;

public class Laboratory {
    private String codecity;
    private String namecity;
    private String codereg;
    public Laboratory() {
    }
    public Laboratory(String codecity, String namecity, String codereg) {
        this.codecity = codecity;
        this.namecity = namecity;
        this.codereg = codereg;
    }
    public String getCodecity() {
        return codecity;
    }
    public void setCodecity(String codecity) {
        this.codecity = codecity;
    }
    public String getNamecity() {
        return namecity;
    }
    public void setNamecity(String namecity) {
        this.namecity = namecity;
    }
    public String getCodereg() {
        return codereg;
    }
    public void setCodereg(String codereg) {
        this.codereg = codereg;
    }

    
}
