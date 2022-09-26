package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckingAccountTest {

    CheckingAccount account;

    @DisplayName("Создание объекта для тестов класса CheckingAccount.")
    @BeforeEach
    void prepareData() {
        account = new CheckingAccount("Тони Старк", 100_000);
    }

    @DisplayName("Проверка метода pay(), не превышающая лимиты на снятие/оплату.")
    @Test
    void payWithPositiveBalance() {
        assertTrue(account.pay(90_000));
    }

    @DisplayName("Проверка метода pay(), превышающая лимиты на снятие/оплату.")
    @Test
    void payOverPositiveBalance() {
        assertFalse(account.pay(150_000));
    }
}