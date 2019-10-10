package com.example.pickrecipes;

public class CardList {
    private String category;
    private String title;
    //private String description;
    private int listThumbnail;

    public CardList(String category, String title, int listThumbnail) {
        this.category = category;
        this.title = title;
        this.listThumbnail = listThumbnail;
        //this.description = description;
    }


//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        description = description;
//    }


    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getListThumbnail() {
        return listThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setListThumbnail(int listThumbnail) {
        this.listThumbnail = listThumbnail;
    }
}
