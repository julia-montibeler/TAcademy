package model;

public class CustomerThread extends Thread {
    private Bank bank;
    private int accountNumber;
    private boolean isDeposit;
    private double amount;

    public CustomerThread(Bank bank, int accountNumber, boolean isDeposit, double amount) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            bank.deposit(accountNumber, amount);
        } else {
            bank.withdraw(accountNumber, amount);
        }
    }
}
