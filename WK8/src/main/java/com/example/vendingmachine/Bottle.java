package com.example.vendingmachine;

public class Bottle {
    private String name;
    private double size;
    private double price;
    private int quantity;


    public Bottle(String name, double size, double price, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return this.name;
    }


    public double getPrice() {
        return this.price;
    }


    public double getSize() {
        return this.size;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity -= 1;
        }
    }
}

