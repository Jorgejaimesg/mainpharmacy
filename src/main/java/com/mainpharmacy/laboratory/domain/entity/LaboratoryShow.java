package com.mainpharmacy.laboratory.domain.entity;

public class LaboratoryShow {
    private int id;
    private String namelab;
    private String namecity;
    private String namereg;
    private String nameCountry;
    public LaboratoryShow() {
    }
    public LaboratoryShow(int id, String namelab, String namecity, String namereg, String nameCountry) {
        this.id = id;
        this.namelab = namelab;
        this.namecity = namecity;
        this.namereg = namereg;
        this.nameCountry = nameCountry;
    }
    public int getId() {
        return id;
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
    public String getNamecity() {
        return namecity;
    }
    public void setNamecity(String namecity) {
        this.namecity = namecity;
    }
    public String getNamereg() {
        return namereg;
    }
    public void setNamereg(String namereg) {
        this.namereg = namereg;
    }
    public String getNameCountry() {
        return nameCountry;
    }
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

}
