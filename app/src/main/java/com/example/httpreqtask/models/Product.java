package com.example.httpreqtask.models;

public class Product {
    public int id;
    public String name;
    public String img;
    public String soluong;

    public Product(int id, String name, String img, String soluong) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
