package ru.siurgtu.gymapp;

public class Exercise {
    private String name;
    private String discription;
    private int imgResource;

    public Exercise(String name, String discription, int img){

        this.name=name;
        this.discription=discription;
        this.imgResource=img;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return this.discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImgResource() {
        return this.imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

}
