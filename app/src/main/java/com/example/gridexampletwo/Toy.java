package com.example.gridexampletwo;

public class Toy {
    private int image;
    private String title;
    private double price;
    private boolean isSelect;

    public Toy(int image, String name, double price, boolean isSelect) {
        this.image = image;
        this.title = name;
        this.price = price;
        this.isSelect = isSelect;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image =  image;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
    public boolean isSelected(){
        return isSelect;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }
}
