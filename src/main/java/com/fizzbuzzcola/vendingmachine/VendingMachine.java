package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    String coin = "";
    public boolean insert(String coin){
        if(coin == "nickel"){
            return true;
        }
        return false;
    }
}
