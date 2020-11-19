package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    int display = 0;
    int coinReturn = 0;
    private Object money;

    public int insert(String coin) {
        if(coin == "nickel"){
            display = display + 5;
        } else if(coin == "quarter"){
            display = display + 25;
        } else if(coin == "dime"){
            display = display + 10;
        } else if (coin == "penny"){
            display = display + 0;
        }
        return display;
    }
    public int checkCoin(String coin){
        if(coin == "penny"){
            coinReturn = coinReturn + 1;
        } else {
            coinReturn = coinReturn + 0;
        }
        return coinReturn;
    }
}
