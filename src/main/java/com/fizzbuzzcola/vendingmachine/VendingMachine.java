package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    String coin = "";
    int display = 0;
    public int insert(String coin) {
        if(coin == "nickel"){
            display = 5;
        }
        return display;
    }
}
