package com.info.mustapha.moststarredgithubrepos.models;


public class Repository {


    private String name;
    private String owner;
    private String description;
    private String imgUrl;

    private int starCount;

    public Repository(String name, String owner, String description, String imgUrl, int starCount){
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.imgUrl = imgUrl;
        this.starCount = starCount;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getStarCount() {
        return starCount;
    }

}
