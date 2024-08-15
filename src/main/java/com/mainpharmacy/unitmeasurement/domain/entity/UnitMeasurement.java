package com.mainpharmacy.unitmeasurement.domain.entity;

public class UnitMeasurement {
    private int id;
    private String descriptionmode;
    public UnitMeasurement() {
    }
    public UnitMeasurement(int id, String descriptionmode) {
        this.id = id;
        this.descriptionmode = descriptionmode;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescriptionmode() {
        return descriptionmode;
    }
    public void setDescriptionmode(String descriptionmode) {
        this.descriptionmode = descriptionmode;
    }
    
}
