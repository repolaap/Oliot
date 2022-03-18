package com.example.vendingmachine;

import java.util.ArrayList;

public class BottleDispenser {
    private ArrayList<Bottle> list;
    private double money;
    private static BottleDispenser bd = null;

    private BottleDispenser() {
        money = 0;
        list = new ArrayList<Bottle>();
        list.add(new Bottle("Pepsi Max", 0.5, 1.8, 2));
        list.add(new Bottle("Pepsi Max", 1.5, 2.2, 2));
        list.add(new Bottle("Coca-Cola Zero", 0.5, 2.0, 2));
        list.add(new Bottle("Coca-Cola Zero", 1.5, 2.5, 2));
        list.add(new Bottle("Fanta Zero", 0.5, 1.95, 2));
    }

    public static BottleDispenser getInstance() {
        if (bd == null) {
            bd = new BottleDispenser();
        }
        return bd;
    }



    public String addMoney(int value) {
        money += value;
        return "Klink! Added more money!  Balance: " + String.format("%.2f",money);
    }

    public String buyBottle(int number) {
        int index = number-1;
        Bottle b = list.get(index);
        if (b.getQuantity() <= 0) {
            return "No more bottles left";
        }
        if (money < b.getPrice()) {
            return "Add money first!";

        } else {
            money -= b.getPrice();
            b.decreaseQuantity();
            return "KACHUNK! " + b.getName() + " came out of the dispenser!";

        }
    }

    public String returnMoney() {
        if (money > 0) {
            String s = "Klink klink. Money came out! " + "You got " + String.format("%.2f",money) + "€ back";
            money = 0;
            return s;
        } else {
            return "No money left";
        }
    }

    public void printList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". Name: " + list.get(i).getName()+ "\n"+"\tSize: " + list.get(i).getSize() + "\tPrice: " + list.get(i).getPrice());
        }
    }

}