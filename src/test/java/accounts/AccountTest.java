package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @DisplayName("Создание объекта для тестов класса Account.")
    @BeforeEach
    void prepareData() {
        account = new Account("Тони Старк", 100_000);
    }

    @DisplayName("Проверка геттера имени.")
    @Test
    void getName() {
        assertEquals("Тони Старк", account.getName());
    }

    @DisplayName("Проверка геттера баланса.")
    @Test
    void getBalance() {
        assertEquals(100_000, account.getBalance());
    }

    @DisplayName("Проверка метода add() при положительной балансе.")
    @Test
    void add() {
        assertTrue(account.add(50_000));
    }

    @DisplayName("Проверка метода add() при отрицательном балансе.")
    @Test
    void addWithNegativeBalance() {
        Account account1 = new Account("Тони Старк", -100_00);
        assertTrue(account1.add(150_000));
    }

    @DisplayName("Проверка метода pay() на сумму, не превышающую баланс.")
    @Test
    void payLessThanBalance() {
        assertTrue(account.pay(50_000));
    }

    @DisplayName("Проверка метода pay() на сумму превышающую баланс.")
    @Test
    void payMoreThanBalance() {
        assertFalse(account.pay(150_000));
    }
}