package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

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
    @Test
    public void vendingMachingShouldDisplayInsertCoinByDefault(){
        VendingMachine underTest = new VendingMachine();
        String message = underTest.vmDisplay(0);
        assertThat(message).isEqualTo("INSERT COIN $0.00");
    }
    @Test
    public void vendingMachineShouldDisplayValueOfCoinInserted(){
        VendingMachine underTest = new VendingMachine();
        int amount = underTest.insert("nickel");
        int coinReturn = underTest.checkCoin("nickel");
        String message = underTest.vmDisplay(amount);
        assertThat(amount).isEqualTo(5);
        assertThat(coinReturn).isEqualTo(0);
        assertThat(message).isEqualTo("$0.05");
    }
    @Test
    public void userCanBuyCola(){
        VendingMachine underTest = new VendingMachine();
        int money = 100;
        String message = underTest.buyProduct(money, "cola");
        assertThat(message).isEqualTo("THANK YOU");
    }
    @Test
    public void userCanBuyChips(){
        VendingMachine underTest = new VendingMachine();
        int money = 50;
        String message = underTest.buyProduct(money, "chips");
        assertThat(message).isEqualTo("THANK YOU");
    }
    @Test
    public void userCanBuyCandy(){
        VendingMachine underTest = new VendingMachine();
        int money = 65;
        String message = underTest.buyProduct(money, "candy");
        assertThat(message).isEqualTo("THANK YOU");
    }
    @Test
    public void ifUserDidNotDepositEnoughMoneyVMDisplaysPRICE(){
        VendingMachine underTest = new VendingMachine();
        int money = 40;
        String message = underTest.buyProduct(money, "cola");
        assertThat(message).isEqualTo("PRICE: $1.00");
        String message2 = underTest.buyProduct(money, "chips");
        assertThat(message2).isEqualTo("PRICE: $0.50");
        String message3 = underTest.buyProduct(money, "candy");
        assertThat(message3).isEqualTo("PRICE: $0.65");
    }
    @Test
    public void afterProductIsPurchasedAndMachineSaysThankYouDisplayReadsInsertCoinAndAmountIs0(){
        VendingMachine underTest = new VendingMachine();
        int money = 50;
        String message = underTest.buyProduct(money, "chips");
        assertThat(message).isEqualTo("THANK YOU");
        int amount = underTest.getAmount();
        String message2 = underTest.vmDisplay((amount));
        assertThat(message2).isEqualTo("INSERT COIN $0.00");
    }
    @Test
    public void afterPurchaseCandyWith75CentsGet10CentsInCoinReturn(){
        VendingMachine underTest = new VendingMachine();
        int money = 75;
        String message = underTest.buyProduct(money, "candy");
        assertThat(message).isEqualTo("THANK YOU");
        int amount = underTest.getAmount();
        assertThat(amount).isEqualTo(0);
        int coinReturn = underTest.getCoinReturn();
        assertThat(coinReturn).isEqualTo(10);
        String message2 = underTest.vmDisplay((amount));
        assertThat(message2).isEqualTo("INSERT COIN $0.00");
    }
    @Test
    public void userGetsAllCoinsInCoinReturnWhenPressed(){
        VendingMachine underTest = new VendingMachine();
        int display = underTest.insert("quarter");
        assertThat(display).isEqualTo(25);
        int amount = underTest.getAmount();
        assertThat(amount).isEqualTo(25);
        String coinReturnAmount = underTest.pressCoinReturn(amount);
        assertThat(coinReturnAmount).isEqualTo("$0.25");
        int coinReturn = underTest.getCoinReturn();
        assertThat(coinReturn).isEqualTo(0);
    }
    @Test
    public void userGetsAllMoneyBackWhenCoinReturnPressed(){
        VendingMachine underTest = new VendingMachine();
        underTest.insert("quarter");
        underTest.insert("quarter");
        underTest.insert("quarter");
        int display = underTest.insert("dime");
        assertThat(display).isEqualTo(85);
        int amount = underTest.getAmount();
        String message = underTest.buyProduct(amount, "cola");
        assertThat(message).isEqualTo("PRICE: $1.00");
        String coinReturnAmount = underTest.pressCoinReturn(amount);
        assertThat(coinReturnAmount).isEqualTo("$0.85");
        amount = underTest.getAmount();
        String message2 = underTest.vmDisplay((amount));
        assertThat(message2).isEqualTo("INSERT COIN $0.00");
    }
    @Test
    public void vendingMachineKnowsHowManyOfEachCoinItHas(){
        VendingMachine underTest = new VendingMachine();
        underTest.insert("quarter");
        underTest.insert("quarter");
        underTest.insert("quarter");
        underTest.insert("nickel");
        underTest.insert("nickel");
        int amount = underTest.getAmount();
        assertThat(amount).isEqualTo(85);
        int nickels = underTest.getNickels();
        assertThat(nickels).isEqualTo(2);
        int dimes = underTest.getDimes();
        assertThat(dimes).isEqualTo(0);
        int quarters = underTest.getQuarters();
        assertThat(quarters).isEqualTo(3);
    }
    @Test
    public void vendingMachineKnowsItCantMakeChangeIfNoNickels(){
        VendingMachine underTest = new VendingMachine();
        int nickels = underTest.getNickels();
        int dimes = underTest.stashDimesForTesting();
        int quarters = underTest.getQuarters();
        boolean change = underTest.makeChange(nickels, dimes, quarters);
        assertThat(change).isEqualTo(false);
    }
    @Test
    public void vendingMachineKnowsItCantMakeChangeIfNoDimes(){
        VendingMachine underTest = new VendingMachine();
        int nickels = underTest.stashNickelsForTesting();
        int dimes = underTest.getDimes();
        int quarters = underTest.getQuarters();
        boolean change = underTest.makeChange(nickels, dimes, quarters);
        assertThat(change).isEqualTo(false);
    }
    @Test
    public void vendingMachineDisplaysExactChangeOnlyInsteadofInsertCoinWhenCantMakeChange(){
        VendingMachine underTest = new VendingMachine();
        int dimes = underTest.stashDimesForTesting();
        int amount = underTest.getAmount();
        String message = underTest.vmDisplay(amount);
        assertThat(message).isEqualTo("EXACT CHANGE ONLY");
    }
}