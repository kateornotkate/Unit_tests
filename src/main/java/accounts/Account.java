package accounts;

public class Account {
    protected String name;
    protected long balance;
    protected StringBuilder logOperator;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
        this.logOperator = new StringBuilder();
    }

    public long getBalance() { // геттер баланса;
        return balance;
    }

    public String getName() { // геттер имени;
        return name;
    }

    public boolean pay(long amount) { // метод для оплаты/снятие денег со счёта;
        if ((balance - amount) >= 0) {
            balance -= amount;
            logOperator.append(String.format("Произведено снятие на сумму %s. Текущий баланс %s \n", amount, balance));
            return true;
        }
        logOperator.append(String.format("Операция по снятию на сумму %s отклонена. Текущий баланс %s \n", amount, balance));
        return false;
    }

    public boolean add(long amount) { // метод пополнения счёта;
        if (amount > 0) {
            balance += amount;
            logOperator.append(String.format("Пополнение счёта на сумму %s. Текущий баланс %s\n", amount, balance));
            return true;
        }
        logOperator.append(String.format("Операция по пополнению счёта на сумму %s отклонена. Текущий баланс %s \n", amount, balance));
        return false;
    }

    public void readLogOperator() {
        System.out.println(logOperator);
    }

    public String toString() {
        return "Имя владельца счёта: " + name + "\n" + "Ваш баланс: " + balance + " рублей";
    }
}