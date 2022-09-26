package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreditAccountTest {

    CreditAccount account;

    @DisplayName("Создание объекта для тестов класса CreditAccount.")
    @BeforeEach
    void prepareData() {
        account = new CreditAccount("Тони Старк", -100_000);
    }

    @DisplayName("Проверка метода add(), не превышающая лимиты пополнения счёта.")
    @Test
    void addWithNegativeBalance() {
        assertTrue(account.add(90_000));
    }

    @DisplayName("Проверка метода add(), превышающая лимиты пополнения счёта.")
    @Test
    void addWithZeroBalance() {
        assertFalse(account.add(150_000));
    }
}