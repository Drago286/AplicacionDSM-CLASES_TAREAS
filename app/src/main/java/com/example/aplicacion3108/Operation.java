package com.example.aplicacion3108;

import java.io.Serializable;

public class Operation implements Serializable {

    private String name;
    private int image;

    public operation(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
