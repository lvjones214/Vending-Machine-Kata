package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    private int amount = 0;
    private int coinReturn = 0;
    private String message = "";
    private String thankYou = "";
    private int money = 0;
    private double dollars = 0.00;
    protected int nickels = 0;
    protected int dimes = 0;
    protected int quarters = 0;
    protected int pennies = 0;

    public int insert(String coin) {
        if(coin == "nickel"){
            amount = amount + 5;
            nickels = nickels+1;
        } else if(coin == "quarter"){
            amount = amount + 25;
            quarters = quarters+1;
        } else if(coin == "dime"){
            amount = amount + 10;
            dimes = dimes+1;
        } else if (coin == "penny"){
            amount = amount + 0;
        }
        return amount;
    }
    public int checkCoin(String coin){
        if(coin == "penny"){
            coinReturn = coinReturn + 1;
            pennies = pennies+1;
        } else {
            coinReturn = coinReturn + 0;
        }
        return coinReturn;
    }
    public String vmDisplay(int amount){
        if(amount > 0){
            dollars = amount/100.00;
            System.out.println(dollars);
            message = "$"+ dollars;
        }else {
            message = "INSERT COIN $0.00";
        }
        return message;
    }
    public String buyProduct(int amount, String productName){
        if(productName == "cola"){
            if(amount >= 100){
                thankYou = "THANK YOU";
                amount = amount - 100;
            } else {
                thankYou = "PRICE: $1.00";
            }
        }
        if(productName == "chips"){
            if(amount >= 50){
                thankYou = "THANK YOU";
                amount = amount - 50;
            } else {
                thankYou = "PRICE: $0.50";
            }
        }
        if(productName == "candy"){
            if(amount >= 65){
                thankYou = "THANK YOU";
                amount = amount -65;
            } else {
                thankYou = "PRICE: $0.65";
            }
        }
        coinReturn = coinReturn + amount;
        return thankYou;
    }

    public int getAmount() {
        return amount;
    }

    public int getCoinReturn() {
        return coinReturn;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public String pressCoinReturn(int coinReturn) {
        dollars = coinReturn / 100.00;
        amount = 0;
        return "$"+dollars;
    }

    public String makeChange(int nickels, int dimes, int quarters) {
        return "nickels="+nickels+", dimes="+dimes+", quarters="+quarters;
    }
}
