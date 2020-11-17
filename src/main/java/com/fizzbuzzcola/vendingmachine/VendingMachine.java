package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    public boolean insert(Coin coin){
        if(coin.getSize() > 1){
            return true;
        }
        return false;
    }
}
