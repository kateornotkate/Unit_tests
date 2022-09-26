package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SavingsAccountTest {

    SavingsAccount account;

    @DisplayName("Создание объекта для тестов класса SavingsAccount.")
    @BeforeEach
    void prepareData() {
        account = new SavingsAccount("Тони Старк", 100_000, 30_000);
    }

    @DisplayName("Проверка метода add().")
    @Test
    void add() {
        assertTrue(account.add(50_000));
    }

    @DisplayName("Проверка метода pay(), не превышающая лимиты на снятие.")
    @Test
    void payBeforeLimit() {
        assertTrue(account.pay(70_000));
    }

    @DisplayName("Проверка метода pay(), превышающая лимиты на снятие.")
    @Test
    void payOverLimit() {
        assertFalse(account.pay(75_000));
    }
}