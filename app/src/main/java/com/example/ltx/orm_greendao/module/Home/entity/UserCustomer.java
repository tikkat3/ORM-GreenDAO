package com.example.ltx.orm_greendao.module.Home.entity;

import com.example.ltx.orm_greendao.db.entity.User;

/**
 * Created by ltx on 2017/12/20.
 */

public class UserCustomer extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
