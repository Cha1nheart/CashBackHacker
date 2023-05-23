package ru.netology.tests;

import ru.netology.service.CashbackHackService;

public class CashbackHackServiceTest {

    @org.testng.annotations.Test
    public void shouldCalcAverage() { /* Позитивный тест для среднего значения */
        CashbackHackService service = new CashbackHackService();
        int amount = 500;
        int expected = 500;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldNotCalcThreshold() { /* При покупке на сумму граничного значения кешбэк уже начислен: */
        CashbackHackService service = new CashbackHackService(); /* сервис не должен советовать докупать */
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldCalcBellowThreshold() { /* Позитивная проверка граничного значения суммы покупки */
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int expected = 1;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void shouldNotCalcAboveThreshold() { /* При покупке на сумму выше граничного значения кешбэк уже начислен: */
        CashbackHackService service = new CashbackHackService(); /* сервис не должен советовать докупать */
        int amount = 1001;
        int expected = 0;
        int actual = service.remain(amount);

        org.testng.Assert.assertEquals(actual, expected);
    }

//    Тесты для проверки суммы покупки

    @org.testng.annotations.Test
    public void shouldNotAcceptZeroForAmount() { /* Сумма покупки не должна быть равна нулю */
        CashbackHackService service = new CashbackHackService(); /* Тест упадет: нет условий для переменной "amount" */
        int amount = 0;

        org.testng.Assert.assertEquals(service.remain(amount), false);
    }

    @org.testng.annotations.Test
    public void shouldNotAcceptNegativeNumbersForAmount() { /* Сумма покупки не должна быть отрицательной */
        CashbackHackService service = new CashbackHackService(); /* Тест упадет: нет условий для переменной "amount" */
        int amount = -1;

        org.testng.Assert.assertEquals(service.remain(amount), false);
    }

}