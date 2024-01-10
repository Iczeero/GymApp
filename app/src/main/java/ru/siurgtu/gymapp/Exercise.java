package ru.siurgtu.gymapp;

public class Exercise {
    private String name;
    private String discription;
    private int imgResource;
    private String videoResource;



    public Exercise(String name, String discription, int img, String video){

        this.name=name;
        this.discription=discription;
        this.imgResource=img;
        this.videoResource=video;
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
    public String getVideoResource(){return this.videoResource;}

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

}
