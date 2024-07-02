package ex5;

import java.util.ArrayList;

public class Bank {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void openAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public static void closeAccount(BankAccount bankAccount) {
        accounts.remove(bankAccount);
    }

    public static void deposit(BankAccount bankAccount, double value) {
        bankAccount.setBalance(value);
    }

    public static void withdraw(BankAccount bankAccount, double value) {
        if ((bankAccount.getBalance() - value) <= 0) {
            System.out.println("you have no available balance");
        } else {
            bankAccount.setBalance(bankAccount.getBalance()-value);
        }
    }

    public static void transfer(BankAccount bankAccount1, BankAccount bankAccount2, double value) {
        if ((bankAccount1.getBalance() - value) <= 0) {
            System.out.println("you have no available balance");
        } else {
            bankAccount1.setBalance(bankAccount1.getBalance()-value);
            bankAccount2.setBalance(bankAccount2.getBalance()+value);
        }
    }
}
