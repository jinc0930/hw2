package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

interface TransactionFilter {

    public List<Transaction> filter(List<Transaction> transactions);

}


class CategoryFilter implements TransactionFilter {
    
    private String category;

    public CategoryFilter(String category) {
        this.category = category;
    }

    public void setCategoryFilter(String category) {
        this.category = category;
    }

    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction item : transactions) {
            if (item.getCategory() == this.category) {
                filteredTransactions.add(item);
            }
        }
        return filteredTransactions;
    }
}


class AmountFilter implements TransactionFilter {
    
    private Double amount;

    public AmountFilter(Double amount) {
        this.amount = amount;
    }

    public void setAmountFilter(Double amount) {
        this.amount = amount;
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

