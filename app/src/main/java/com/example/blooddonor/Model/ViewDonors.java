package com.example.blooddonor.Model;

public class ViewDonors {
    String name, address, phone, bloodgroup;

    public ViewDonors(String name, String address, String phone, String bloodgroup) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bloodgroup = bloodgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
