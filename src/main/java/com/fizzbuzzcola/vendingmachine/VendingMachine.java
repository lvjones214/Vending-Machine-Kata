package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    private int amount = 0;
    private int coinReturn = 0;
    private String message = "";
    private String thankYou = "";
    private int money = 0;

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
            message = ""+ amount;
        }else {
            message = "INSERT COIN";
        }
        return message;
    }
    public String buyProduct(int money, String productName){
        if(productName == "cola"){
            if(money >= 100){
                thankYou = "THANK YOU";
            } else {
                thankYou = "PRICE: $1.00";
            }
        }
        if(productName == "chips"){
            if(money >= 50){
                thankYou = "THANK YOU";
            } else {
                thankYou = "PRICE: $0.50";
            }
        }
        if(productName == "candy"){
            if(money >= 65){
                thankYou = "THANK YOU";
            } else {
                thankYou = "PRICE: $0.65";
            }
        }
        return thankYou;
    }
}
