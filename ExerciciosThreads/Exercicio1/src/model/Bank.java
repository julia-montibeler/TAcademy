package model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized void addAccount(int accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new Account(accountNumber, initialBalance));
        } else {
            throw new IllegalArgumentException("Account number already exists.");
        }
    }

    public synchronized Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            throw new IllegalArgumentException("Account number not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            throw new IllegalArgumentException("Account number not found.");
        }
    }
}