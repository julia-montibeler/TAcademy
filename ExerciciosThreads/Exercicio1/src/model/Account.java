package model;

import model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }

    public synchronized List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }
}