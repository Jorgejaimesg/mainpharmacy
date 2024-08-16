package com.mainpharmacy.pharmacy.domain.entity;

public class Pharmacy {
    private int idpharmacy;
    private String namepharmacy;
    private String addrespharmacy;
    private String latpharmacy;
    private String longfarmacy;
    private String logopharmacy;
    private String codecity;
    public Pharmacy() {
    }
    public Pharmacy(int idpharmacy, String namepharmacy, String addrespharmacy, String latpharmacy, String longfarmacy,
            String codecity, String logopharmacy) {
        this.idpharmacy = idpharmacy;
        this.namepharmacy = namepharmacy;
        this.addrespharmacy = addrespharmacy;
        this.latpharmacy = latpharmacy;
        this.longfarmacy = longfarmacy;
        this.codecity = codecity;
        this.logopharmacy = logopharmacy;
    }
    public int getIdpharmacy() {
        return idpharmacy;
    }
    public void setIdpharmacy(int idpharmacy) {
        this.idpharmacy = idpharmacy;
    }
    public String getNamepharmacy() {
        return namepharmacy;
    }
    public void setNamepharmacy(String namepharmacy) {
        this.namepharmacy = namepharmacy;
    }
    public String getAddrespharmacy() {
        return addrespharmacy;
    }
    public void setAddrespharmacy(String addrespharmacy) {
        this.addrespharmacy = addrespharmacy;
    }
    public String getLatpharmacy() {
        return latpharmacy;
    }
    public void setLatpharmacy(String latpharmacy) {
        this.latpharmacy = latpharmacy;
    }
    public String getLongfarmacy() {
        return longfarmacy;
    }
    public void setLongfarmacy(String longfarmacy) {
        this.longfarmacy = longfarmacy;
    }
    public String getCodecity() {
        return codecity;
    }
    public void setCodecity(String codecity) {
        this.codecity = codecity;
    }
    public String getLogopharmacy() {
        return logopharmacy;
    }
    public void setLogopharmacy(String logopharmacy) {
        this.logopharmacy = logopharmacy;
    }


    
}
