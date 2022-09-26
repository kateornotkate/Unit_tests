package accounts;

public class CreditAccount extends Account {

    public CreditAccount(String name, long balance) { // конструктор для CreditAccount;
        super(name, balance); // наследуем необходимые параметры от Account;
    }

    // можем только пополнять счёт, т.к. в данном случае это кредит, а не кредитная карта;
    @Override
    public boolean add(long amount) {
        if ((balance + amount) <= 0) {
            balance += amount;
            logOperator.append(String.format("Пополнение счёта на сумму %s. Текущий баланс %s\n", amount, balance));
            return true;
        }
        logOperator.append(String.format("Операция по пополнению счёта на сумму %s отклонена. Текущий баланс %s \n", amount, balance));
        return false;
    }

    @Override
    public String toString() {
        return "Имя владельца счёта: " + name + "\n" + "Баланс по кредитному счёту: " + balance + " рублей. ";
    }
}