package ru.netology.tests;

import ru.netology.service.CashbackHackService;

public class CashbackHackServiceTest {

    @org.testng.annotations.Test
    public void shouldCalcAverage() {
        CashbackHackService service = new CashbackHackService();
        int amount = 500;
        int expected = 500;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcZero() {
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        int expected = 1000;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcNegativeNumbers() {
        CashbackHackService service = new CashbackHackService();
        int amount = -1;
        int expected = 1001;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcThreshold() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        int expected = 1000;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcBellowThreshold() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int expected = 1;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcAboveThreshold() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;
        int expected = 999;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

}