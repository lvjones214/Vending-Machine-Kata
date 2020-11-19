package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    String coin = "";
    public boolean insert(String coin){
        if(coin == "nickel" || coin == "quarter"){
            return true;
        }
        return false;
    }
}
