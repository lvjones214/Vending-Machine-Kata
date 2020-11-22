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
    private boolean makeChange = false;
    boolean chipsSoldOut = false;
    boolean colaSoldOut = false;
    boolean candySoldOut = false;



   //Testing features
    public int stashNickelsForTesting(){
        nickels = 3;
        return nickels;
    }
    public int stashDimesForTesting(){
        dimes = 3;
        return dimes;
    }

    //Coin features
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
    public int getAmount() {return amount;}
    public int getCoinReturn() {return coinReturn;}
    public int getNickels() {return nickels;}
    public int getDimes() {return dimes;}
    public int getQuarters() {return quarters;}

    public String pressCoinReturn(int coinReturn) {
        dollars = coinReturn / 100.00;
        amount = 0;
        return "$"+dollars;
    }
    public boolean makeChange(int nickels, int dimes) {
        if(nickels < 1 || dimes < 1){
            makeChange = false;
        } else {
            makeChange = true;
        }
        return makeChange;
    }

   //Display feature
    public String vmDisplay(int amount){
        if(makeChange == false) {
            message = "EXACT CHANGE ONLY";
        }else if(amount > 0){
            dollars = amount/100.00;
            System.out.println(dollars);
            message = "$"+ dollars;
        } else {
            message = "INSERT COIN $0.00";
        }
        return message;
    }

  //Products in VM
    public String buyProduct(int amount, String productName){
        if(productName == "cola"){
            if(colaSoldOut == false){
                System.out.println(colaSoldOut);
                if(amount >= 100){
                    thankYou = "THANK YOU";
                    amount = amount - 100;
                } else {
                    thankYou = "PRICE: $1.00";
                }
            } else if(colaSoldOut == true) {
                thankYou = "SOLD OUT";
            }
        }
        if(productName == "chips"){
            if(chipsSoldOut == true){
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
            if(candySoldOut == true){
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

    public boolean isChipsSoldOut() {
        return chipsSoldOut;
    }

    public boolean isColaSoldOut() {
        return colaSoldOut;
    }

    public boolean isCandySoldOut() {
        return candySoldOut;
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
            colaSoldOut = false;
            chipsSoldOut = false;
            candySoldOut = false;
        }
        return productSoldOut;
    }
}
