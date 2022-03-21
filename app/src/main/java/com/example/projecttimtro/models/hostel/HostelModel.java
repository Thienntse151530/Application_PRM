package com.example.projecttimtro.models.hostel;

public class HostelModel {
    private Integer idHostel;
    private String nameHostel;
    private String addressHostel;
    private String managerHostel;
    private Integer totalTypeRoom;
    private Integer totalRoom;
    private String imgHostels;

    public HostelModel() {
    }

    public HostelModel(Integer idHostel, String nameHostel, String addressHostel, String managerHostel, Integer totalTypeRoom, Integer totalRoom, String imgHostels) {
        this.idHostel = idHostel;
        this.nameHostel = nameHostel;
        this.addressHostel = addressHostel;
        this.managerHostel = managerHostel;
        this.totalTypeRoom = totalTypeRoom;
        this.totalRoom = totalRoom;
        this.imgHostels = imgHostels;
    }

    public String getImgHostels() {
        return imgHostels;
    }

    public void setImgHostels(String imgHostels) {
        this.imgHostels = imgHostels;
    }

    public Integer getIdHostel() {
        return idHostel;
    }
    public void setIdHostel(Integer idHostel) {
        this.idHostel = idHostel;
    }
    public String getNameHostel() {
        return nameHostel;
    }
    public void setNameHostel(String nameHostel) {
        this.nameHostel = nameHostel;
    }
    public String getAddressHostel() {
        return addressHostel;
    }
    public void setAddressHostel(String addressHostel) {
        this.addressHostel = addressHostel;
    }
    public String getManagerHostel() {
        return managerHostel;
    }
    public void setManagerHostel(String managerHostel) {
        this.managerHostel = managerHostel;
    }
    public Integer getTotalTypeRoom() {
        return totalTypeRoom;
    }
    public void setTotalTypeRoom(Integer totalTypeRoom) {
        this.totalTypeRoom = totalTypeRoom;
    }
    public Integer getTotalRoom() {
        return totalRoom;
    }
    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }

}
