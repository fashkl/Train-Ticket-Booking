package com.example.fashkl.project.DataWareHouse;

import android.text.Editable;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by fashkl on 13/05/16.
 */
public class Registeration implements Serializable {


    //    private UUID uuid;
    private int uuid;
    private String userName;
    private String password;
    private String address;
    private int age;
    private int mobileNo;
    private int cardNo;

    public Registeration() {
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }


}
