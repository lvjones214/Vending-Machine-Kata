package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachingTest {

    @Test
    public void vendingMachineShouldAcceptNickel() {
        VendingMachine underTest = new VendingMachine();
        Coin nickel = new Coin("nickel", 5);
        boolean money = underTest.insert(nickel);
        assertThat(money).isTrue();
    }
}
