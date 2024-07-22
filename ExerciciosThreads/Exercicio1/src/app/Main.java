package app;

import model.Account;
import model.Bank;
import model.CustomerThread;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.addAccount(0001, 0.0);
        bank.addAccount(0002, 1000.0);
        bank.addAccount(0003, 0.0);
        bank.addAccount(0004, 2000.0);

        CustomerThread[] threads = new CustomerThread[8];
        threads[0] = new CustomerThread(bank, 0001, true, 1000.0);
        threads[1] = new CustomerThread(bank, 0001, false, 100.0);
        threads[2] = new CustomerThread(bank, 0002, true, 3000);
        threads[3] = new CustomerThread(bank, 0002, false, 2000);
        threads[4] = new CustomerThread(bank, 0003, true, 300);
        threads[5] = new CustomerThread(bank, 0003, false, 15);
        threads[6] = new CustomerThread(bank, 0004, true, 100);
        threads[7] = new CustomerThread(bank, 0004, false, 10000);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Account acc1 = bank.getAccount(0001);
        Account acc2 = bank.getAccount(0002);
        Account acc3 = bank.getAccount(0003);
        Account acc4 = bank.getAccount(0004);

        List<Account> accountList = new ArrayList<>();
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        accountList.add(acc4);

        for (Account acc : accountList) {
            System.out.println("Balance of account " + acc.getAccountNumber() + ": " + acc.getBalance());
            System.out.println("Transaction history of account " + acc.getAccountNumber() + ": ");
            for (Transaction t : acc.getTransactionHistory()) {
                System.out.println(t);
            }
            System.out.println();
        }
    }
}
