package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;


public class AmountFilter implements TransactionFilter {
    
    private double amount;
    private boolean enabled;

    public AmountFilter(double amount) {
        this.amount = amount;
        this.enabled = false;
    }

    public void setAmountFilter(double amount) {
        this.amount = amount;
    }

    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public double getAmountFilter(){
        return this.amount;
    }

    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction item : transactions) {
            if (item.getAmount() == this.amount) {
                filteredTransactions.add(item);
            }
        }
        return filteredTransactions;
    }
}

