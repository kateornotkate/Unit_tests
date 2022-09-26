import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount("Питер Паркер", 100_000, 30_000);
        System.out.println(account);
        account.add(5_000);
        account.pay(80_000); // проверим, пройдет ли снятие, превышающее лимиты минимального баланса;
        account.pay(50_000);
        account.readLogOperator();

        CheckingAccount account1 = new CheckingAccount("Брюс Бэннер", 200_000);
        System.out.println(account1);
        account1.pay(150_000);
        account1.pay(50_000);
        account1.pay(5_000); // проверим возможность снятия при нулевом счёте;
        account1.add(50_000);
        account1.readLogOperator();

        CreditAccount account2 = new CreditAccount("Тони Старк", -1_000_000);
        System.out.println(account2);
        account2.add(300_000);
        account2.pay(50_000); // проверим возможность снятия денег при отрицательном балансе;
        account2.add(700_000);
        account2.add(50_000); // проверим, сможем ли пополнить уже закрытый кредит;
        account2.readLogOperator();
    }
}