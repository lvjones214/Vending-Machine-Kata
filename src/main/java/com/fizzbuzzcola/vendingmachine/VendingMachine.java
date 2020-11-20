package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    private int amount = 0;
    private int coinReturn = 0;
    private String message = "";

    public int insert(String coin) {
        if(coin == "nickel"){
            amount = amount + 5;
        } else if(coin == "quarter"){
            amount = amount + 25;
        } else if(coin == "dime"){
            amount = amount + 10;
        } else if (coin == "penny"){
            amount = amount + 0;
        }
        return amount;
    }
    public int checkCoin(String coin){
        if(coin == "penny"){
            coinReturn = coinReturn + 1;
        } else {
            coinReturn = coinReturn + 0;
        }
        return coinReturn;
    }
    public String vmDisplay(int amount){
        if(amount > 0){
            System.out.println(amount);
            message = ""+ amount;
        }else {
            message = "INSERT COIN";
        }
        return message;
    }
}
