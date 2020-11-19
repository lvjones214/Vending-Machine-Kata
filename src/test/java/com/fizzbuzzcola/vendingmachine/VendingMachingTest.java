package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachingTest {

    @Test
    public void vendingMachineShouldAcceptNickelAndDisplayAmount() {
        VendingMachine underTest = new VendingMachine();
        int display = underTest.insert("nickel");
        assertThat(display).isEqualTo(5);
    }
//    @Test
//    public void vendingMachineShouldAcceptQuarter() {
//        VendingMachine underTest = new VendingMachine();
//        String coin = "quarter";
//        boolean money = underTest.insert("quarter");
//        assertThat(money).isTrue();
//    }
//    @Test
//    public void vendingMachineShouldAcceptDime() {
//        VendingMachine underTest = new VendingMachine();
//        boolean money = underTest.insert("dime");
//        assertThat(money).isTrue();
//    }
//    @Test
//    public void vendingMachineShouldRejectPenny() {
//        VendingMachine underTest = new VendingMachine();
//        boolean money = underTest.insert("penny");
//        assertThat(money).isFalse();
//    }
//    @Test
//    public void vendingMachineDisplaysValueOfCoinsAdded(){
//        VendingMachine underTest = new VendingMachine();
//        boolean coin1 = underTest.insert("quarter");
//        boolean money = underTest.insert("nickel");
//        assertThat
}
