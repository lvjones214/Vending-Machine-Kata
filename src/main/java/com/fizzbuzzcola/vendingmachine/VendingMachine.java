package com.fizzbuzzcola.vendingmachine;

public class VendingMachine {
    private int amount = 0;
    private int coinReturn = 0;
    private String message = "";
    private String thankYou = "";
    private int money = 0;
    private double dollars = 0.00;
    boolean chipsSoldOut = false;
    boolean colaSoldOut = false;
    boolean candySoldOut = false;

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
            if(colaSoldOut = true){
                thankYou = "SOLD OUT";
            } else {
                if(amount >= 100){
                    thankYou = "THANK YOU";
                    amount = amount - 100;
                } else {
                    thankYou = "PRICE: $1.00";
                }
            }
        }
        if(productName == "chips"){
            if(chipsSoldOut = true){
                thankYou = "SOLD OUT";
            } else {
                if(amount >= 50){
                    thankYou = "THANK YOU";
                    amount = amount - 50;
                } else {
                    thankYou = "PRICE: $0.50";
                }
            }
        }
        if(productName == "candy"){
            if(candySoldOut = true){
                thankYou = "SOLD OUT";
            } else {
                if(amount >= 65){
                    thankYou = "THANK YOU";
                    amount = amount -65;
                } else {
                    thankYou = "PRICE: $0.65";
                }
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

    public String pressCoinReturn(int coinReturn) {
        dollars = coinReturn / 100.00;
        amount = 0;
        return "$"+dollars;
    }

    public boolean soldOutProduct(String product) {
        boolean productSoldOut = false;
        if(product == "cola"){
            colaSoldOut = true;
            productSoldOut = true;
        } else if(product == "chips") {
            chipsSoldOut = true;
            productSoldOut = true;
        }else if(product == "candy"){
            candySoldOut = true;
            productSoldOut = true;
        }else{
            productSoldOut = false;
        }
        return productSoldOut;
    }
}
