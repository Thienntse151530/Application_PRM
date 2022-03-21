package com.example.projecttimtro.models.address;

import java.util.List;

public class Province {

    private String name;
    private String code;
    private String codeName;
    private String divisionType;
    private String phoneCode;
    private List<Districts> districtsList;

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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public List<Districts> getDistrictsList() {
        return districtsList;
    }

    public void setDistrictsList(List<Districts> districtsList) {
        this.districtsList = districtsList;
    }
}
