package com.fizzbuzzcola.vendingmachine;public class Coin {

    private String coinType;
    private int size;

    public Coin(String coinType, int size) {
        this.coinType = coinType;
        this.size = size;
    }

    public String getCoinType() {
        return coinType;
    }

    public int getSize() {
        return size;
    }
}

