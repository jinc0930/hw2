package controller;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class CategoryFilter implements TransactionFilter {
    
    private String category;
    private boolean enabled;

    public CategoryFilter(String category) {
        this.category = category;
        this.enabled = false;
    }

    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }

    public void disableFilter() {
        this.enabled = false;
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

    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction item : transactions) {
            // System.out.print("Item category: ");
            // System.out.println(item.category);
            // System.out.print("Filter category: ");
            // System.out.println(getCategoryFilter());
            System.out.print("Filter is equivalent: ");
            System.out.println(item.getCategory().equals(getCategoryFilter()));
            if (item.getCategory().equals(this.category)) {
                filteredTransactions.add(item);
            }
        }
        return filteredTransactions;
    }
}

