package accounts;

public class SavingsAccount extends Account { // наследование класса
    private int minBalance; // переменная для минимального баланса; или protected

    public SavingsAccount(String name, long balance, int minBalance) { // конструктор для SavingsAccount;
        super(name, balance); // наследуем от Account;
        this.minBalance = minBalance; // дописываем новый параметр, необходимый только для SavingsAccount;
    }

    // мы можем, как пополнять накопительный счёт, так и снимать с него деньги;

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            logOperator.append(String.format("Пополнение счёта на сумму %s. Текущий баланс %s\n", amount, balance));
            return true;
        }
        logOperator.append(String.format("Операция по пополнению счёта на сумму %s отклонена. Текущий баланс %s \n", amount, balance));
        return false;
    }

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
        return "Имя владельца счёта: " + name + "\n" + "Баланс по накопительному счёту: " + balance + " рублей. ";
    }
}