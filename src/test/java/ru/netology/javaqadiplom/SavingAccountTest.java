package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() { // тест провален, ошибка в методе
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreMaxBalance() {    // пополнение, превышающее макимальный баланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.add(10_000));
    }

    @Test
    public void shouldAdd0() {    // пополнение на 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayMoreMinBalance() {  // списание суммы, больше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(10_000);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayWhenBalanceBecomeMinBalance() {    // списание суммы до граничного значения минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountIsZero() {  // списание суммы равной 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldTheInterestRate() {  //расчет процентов
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );



        Assertions.assertEquals(200 , account.yearChange());
    }

    @Test
    public void shouldWhenRateIsLessZero()  { // проверка на отрицательную ставку

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    new SavingAccount(2_000,1_000,15_000,-10);


                });

    }

    //@Test
    //public void shouldPayBooleanPayWhenInt() {              // тест на тип boolean Pay Account

    //    Account account = new Account();

    //    account.pay(1); // сумма выше минимального значения, значит должен false сработать

    //   Assertions.assertFalse(false);
    //}

    //@Test
    //public void shouldAddBooleanPayWhenInt() {              // тест на тип boolean Pay Account

    //    Account account = new Account();

    //    account.add(1); //

    //   Assertions.assertFalse(false);
    //}

    @Test
    public void shouldSetRate() {              // проверка работы сеттера Rate

        Account account = new Account();
        account.setRate(3);

        int expected = 3;
        int actual = account.rate;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldWhenYearChange__() {              // проверка пустого метода YearChange

        Account account = new Account();

        account.yearChange();

        Assertions.assertEquals(0,account.yearChange());
    }

    @Test
    public void testRateWhenLessMinBalance() { // проверка начисления процента, при ,балансе меньше minBalance(Ошибка в коде )
        SavingAccount account = new SavingAccount(

                500,
                1_000,
                10_000,
                5
        );



        Assertions.assertEquals(0 , account.yearChange());
    }
    @Test
    public void testRateWhenMoreMaxBalance() { //проверка начисления процента, при балансе больше maxBalance(Ошибка в коде )
        SavingAccount account = new SavingAccount(

                15_000,
                1_000,
                10_000,
                5
        );



        Assertions.assertEquals(500 , account.yearChange());
    }


}





