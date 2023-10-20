package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class CategoryFilter implements TransactionFilter {
    
    private String category; //holds the category the user wishes to filter on
    private boolean enabled; //holds whether this filter is enabled or not

    public CategoryFilter(String category) { //ctor
        this.category = category;
        this.enabled = false;
    }

    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setCategoryFilter(String category) {
        this.category = category;
    }

    public String getCategoryFilter(){
        return this.category;
    }

    //filters a transaction list to only those who contain the category stored in this filter
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction item : transactions) {
            if (item.getCategory().equals(this.category)) {
                filteredTransactions.add(item);
            }
        }
        return filteredTransactions;
    }
}

