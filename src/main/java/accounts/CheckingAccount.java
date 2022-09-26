package accounts;

public class CheckingAccount extends Account {
    private int minBalance = 0;

    public CheckingAccount(String name, long balance) { // конструктор для CheckingAccount;
        super(name, balance); // наследуем необходимые параметры от Account;
    }

    // можем пополнять и снимать деньги с расчётного счёта;
    @Override
    public boolean pay(long amount) {
        if ((balance - amount) >= minBalance) {
            balance -= amount;
            logOperator.append(String.format("Произведено снятие на сумму %s. Текущий баланс %s \n", amount, balance));
            return true;
        }
        logOperator.append(String.format("Операция по снятию на сумму %s отклонена. Текущий баланс %s \n", amount, balance));
        return false;
    }

    @Override
    public String toString() {
        return "Имя владельца счёта: " + name + "\n" + "Баланс по расчётному счёту: " + balance + " рублей. ";
    }
}