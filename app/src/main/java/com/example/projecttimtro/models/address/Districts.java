package com.example.projecttimtro.models.address;

import java.util.List;

public class Districts {
    private String name;
    private String code;
    private String codeName;
    private String divisionType;
    private String shortCodeName;
    private List<Wards> wardsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDivisionType() {
        return divisionType;
    }

    public void setDivisionType(String divisionType) {
        this.divisionType = divisionType;
    }

    public String getShortCodeName() {
        return shortCodeName;
    }

    public void setShortCodeName(String shortCodeName) {
        this.shortCodeName = shortCodeName;
    }

    public List<Wards> getWardsList() {
        return wardsList;
    }

    public void setWardsList(List<Wards> wardsList) {
        this.wardsList = wardsList;
    }
}
