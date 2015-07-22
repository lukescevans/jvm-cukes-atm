package support;

import support.model.AtmModel;
import support.model.TransactionHistoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by luke.evans on 02/07/15.
 */
public class AtmHelper {
    List<TransactionHistoryModel> thmList = new ArrayList<>();

    /**
     * Calculate the balance of an account after a transaction
     *
     * @param atmModel
     * @param depositAmount
     * @param withdrawalAmount
     * @return
     */
    public AtmModel doTransaction(AtmModel atmModel, int depositAmount, int withdrawalAmount) {
        //Get current account balance
        final int balance = atmModel.getBalance();

        int newBalance = (balance + depositAmount) - withdrawalAmount;
        atmModel.setBalance(newBalance);

        return atmModel;
    }

    public AtmModel makeDeposit(AtmModel atmModel, int depositAmount) {
        final int balance = atmModel.getBalance() + depositAmount;
        atmModel.setBalance(balance);

        //Add txn to history
        addTransactionToHistory(atmModel, depositAmount, AtmModel.transactionType.DEPOSIT);

        return atmModel;
    }

    public AtmModel makeWithdrawal(AtmModel atmModel, int withdrawalAmount) {
        final int balance = atmModel.getBalance() - withdrawalAmount;
        atmModel.setBalance(balance);

        //Add txn to history
        if(atmModel.getBalance() < 0) {
            addTransactionToHistory(atmModel, withdrawalAmount, AtmModel.transactionType.OVERDRAWN);
        }
        else {
            addTransactionToHistory(atmModel, withdrawalAmount, AtmModel.transactionType.WITHDRAWAL);
        }

        return atmModel;
    }

    private AtmModel addTransactionToHistory(AtmModel atmModel, int transAmount, AtmModel.transactionType transactionType) {
        TransactionHistoryModel thm = new TransactionHistoryModel();

        thm.amount = transAmount;
        thm.setTransType(transactionType);

        this.thmList.add(thm);
        atmModel.thm = thmList;

        return atmModel;
    }

    public int balanceEnquiry(AtmModel atmModel) {
        addTransactionToHistory(atmModel, 0, AtmModel.transactionType.BALANCE_ENQUIRY);
        return atmModel.getBalance();
    }

    public String getRandomPin(int length) {
        return getRandomPinNumber(6);
    }

    private String getRandomPinNumber(int length) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            result += random.nextInt(9 - 0 + 1) + 0;
        }
        return result;
    }

    public Boolean getPinStatus(AtmModel atmModel) {
        if (atmModel.getPinAttemptsLeft() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}