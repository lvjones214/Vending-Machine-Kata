package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachingTest {

    @Test
    public void vendingMachineShouldAcceptNickel() {
        VendingMachine underTest = new VendingMachine();
        String coin = "nickel";
        boolean money = underTest.insert("nickel");
        assertThat(money).isTrue();
    }
//    @Test
//    public void vendingMachineShouldAcceptQuarter() {
//        VendingMachine underTest = new VendingMachine();
//        Coin quarter = new Coin("quarter", 25);
//        boolean money = underTest.insert(quarter);
//        assertThat(money).isTrue();
//    }
//    @Test
//    public void vendingMachineShouldAcceptDime() {
//        VendingMachine underTest = new VendingMachine();
//        Coin dime = new Coin("dime", 10);
//        boolean money = underTest.insert(dime);
//        assertThat(money).isTrue();
//    }
//    @Test
//    public void vendingMachineShouldRejectPenny() {
//        VendingMachine underTest = new VendingMachine();
//        Coin penny = new Coin("penny", 1);
//        boolean money = underTest.insert(penny);
//        assertThat(money).isFalse();
//    }
}
