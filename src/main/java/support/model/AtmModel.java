package support.model;

import java.util.List;

/**
 * Created by luke.evans on 06/07/15.
 */
public class AtmModel {
    public List<TransactionHistoryModel> thm;
    private int balance;
    private int pin;
    private int pinAttemptsLeft;
    private Boolean cardBlocked;
    private int transactionCount;

    public AtmModel(int initialBalance) {
        System.out.println("Initial balance: " + initialBalance);
        this.balance = initialBalance;
        this.cardBlocked = false;
        this.pinAttemptsLeft = 3;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        System.out.println("Pin set to: " + pin);
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        System.out.println("Current balance: " + balance);
        this.balance = balance;
    }

    public int getPinAttemptsLeft() {
        return pinAttemptsLeft;
    }

    public void setPinAttemptsLeft(int pinAttemptsLeft) {
        this.pinAttemptsLeft = pinAttemptsLeft;
    }

    public Boolean getCardBlocked() {
        return cardBlocked;
    }

    public void setCardBlocked(Boolean cardBlocked) {
        this.cardBlocked = cardBlocked;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    /**
     * Types of transaction
     */
    public enum transactionType {
        WITHDRAWAL,
        BALANCE_ENQUIRY,
        OVERDRAWN,
        DEPOSIT
    }
}