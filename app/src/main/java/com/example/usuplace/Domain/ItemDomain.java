package com.example.usuplace.Domain;


import java.io.Serializable;

public class ItemDomain implements Serializable {
    private String lugar;
    private String direccion;
    private String descripcion;
    private int price;
    private String ofrece;
    private String img;

    public ItemDomain(){
    }

    public ItemDomain(String lugar, String direccion, String descripcion, int price, String ofrece, String img) {
        this.lugar = lugar;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.price = price;
        this.ofrece = ofrece;
        this.img = img;
    }

    public String getLugar() {return lugar;}

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOfrece() {
        return ofrece;
    }

    public void setOfrece(String ofrece) {
        this.ofrece = ofrece;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
