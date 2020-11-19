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
    @Test
    public void vendingMachineShouldAcceptQuarterAndDisplay25() {
        VendingMachine underTest = new VendingMachine();
        int display = underTest.insert("quarter");
        assertThat(display).isEqualTo(25);
    }
    @Test
    public void vendingMachineShouldAcceptDimeAndDisplay10() {
        VendingMachine underTest = new VendingMachine();
        int display = underTest.insert("dime");
        assertThat(display).isEqualTo(10);
    }
    @Test
    public void vendingMachineShouldRejectPennyAndPutInCoinReturn() {
        VendingMachine underTest = new VendingMachine();
        int coinReturn2 = underTest.checkCoin("nickel");
        assertThat(coinReturn2).isEqualTo(0);
        int coinReturn3 = underTest.checkCoin("quarter");
        assertThat(coinReturn3).isEqualTo(0);
        int coinReturn4 = underTest.checkCoin("dime");
        assertThat(coinReturn4).isEqualTo(0);
        int display = underTest.insert("penny");
        assertThat(display).isEqualTo(0);
        int coinReturn1 = underTest.checkCoin("penny");
        assertThat(coinReturn1).isEqualTo(1);
    }
    @Test
    public void vendingMachineDisplaysValueOfCoinsAdded() {
        VendingMachine underTest = new VendingMachine();
        int display = underTest.insert("nickel");
        int coinReturn = underTest.checkCoin("nickel");
        assertThat(display).isEqualTo(5);
        assertThat(coinReturn).isEqualTo(0);
        display = underTest.insert("quarter");
        coinReturn = underTest.checkCoin("quarter");
        assertThat(display).isEqualTo(30);
        assertThat(coinReturn).isEqualTo(0);
        display = underTest.insert("dime");
        coinReturn = underTest.checkCoin("dime");
        assertThat(display).isEqualTo(40);
        assertThat(coinReturn).isEqualTo(0);
        display = underTest.insert("penny");
        coinReturn = underTest.checkCoin("penny");
        assertThat(display).isEqualTo(40);
        assertThat(coinReturn).isEqualTo(1);
    }
}
