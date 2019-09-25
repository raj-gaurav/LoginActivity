package com.example.project_demo;

import com.google.firebase.database.DataSnapshot;

public class Data {

    String username;
    String password;
    String latitude;
    String longitude;
    String name;
    String id;

    public Data(String id, DataSnapshot child){


    }

    public Data(String username, String password, String latitude, String longitude, String name,String id) {
        this.username=username;
        this.password=password;
        this.latitude=latitude;
        this.longitude=longitude;
        this.name=name;
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
