package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime timestamp;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %.2f", getFormattedTimestamp(), type, amount);
    }
}
