class BankAccount {
    String accNumber;
    String ssNumber;
    int balance = 0;
    
    public BankAccount(String acc, String ss, int bal) {
        accNumber = acc;
        ssNumber = ss;
        balance = bal;
    }

    public int deposit(int amount) {
        return balance += amount;
    }

    public int withdraw(int amount) {
        return balance -= amount;
    }
    public int checkMyBalance() {
        System.out.println("계좌 번호 : " + accNumber);
        System.out.println("주민등록 번호 : " + ssNumber);
        System.out.println("잔액 : " + balance);
        System.out.println();
        return balance;
    }
}

public class Chapter7 {
    public static void main(String[] args) {
        BankAccount yoon = new BankAccount("12-34-89", "990990-9090909", 10000);
        BankAccount park = new BankAccount("33-55-09", "770088-5959007", 20000);

        yoon.deposit(3000);
        park.withdraw(200);
        check(yoon);
        check(park);
    }
    public static void check(BankAccount acc) {
        acc.checkMyBalance();
    }
}
