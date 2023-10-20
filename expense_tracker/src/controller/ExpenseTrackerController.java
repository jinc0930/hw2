package controller;

import view.ExpenseTrackerView;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.ExpenseTrackerModel;
import model.Transaction;

public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  private AmountFilter amountFilter;
  private CategoryFilter categoryFilter;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;
    this.amountFilter = new AmountFilter(0);
    this.categoryFilter = new CategoryFilter("");


    // Set up view event handlers
  }

  public void refresh() {
    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();
    List<Transaction> highlightedTransactions = applyFilters(); //apply filters to the transactions list
    JTable table = view.getTransactionsTable();

    //override the default renderer for the table so we can set some rows green
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                        boolean hasFocus, int row, int column) {
              Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
              //if any rows are also found in the highlighted table change them to green
              if ( !highlightedTransactions.isEmpty() && row < transactions.size() && highlightedTransactions.contains(transactions.get(row))) {
                  c.setBackground(new Color(173, 255, 168)); // Light green
              } else {
                  c.setBackground(table.getBackground());
              }
              return c;
          }
      });




    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }



  public List<Transaction> applyFilters() {
    List<Transaction> transactions = model.getTransactions();
    boolean filtered = false;

    //apply the amount filter if it is enabled and it is a valid amount
    if (this.amountFilter.getEnabled() && InputValidation.isValidAmount(amountFilter.getAmountFilter())) {
      filtered = true;
          transactions = amountFilter.filter(transactions);
    }

    //apply the category filter if it is enabled and it is a valid category
    if (this.categoryFilter.getEnabled() && InputValidation.isValidCategory(categoryFilter.getCategoryFilter())) {
      filtered = true;
      transactions = categoryFilter.filter(transactions);
    }

    if (filtered) {
      return transactions;
    }
    //return an empty list if nothing was filtered
    return new ArrayList<Transaction>();
  }

  public void setAmountFilterValue(double amount) {
    this.amountFilter.setAmountFilter(amount);
    refresh();
  }

  public void setAmountFilterEnabled(boolean isEnabled) {
    this.amountFilter.setEnabled(isEnabled);
    refresh();
  }

  public void setCategoryFilterValue(String category) {
    this.categoryFilter.setCategoryFilter(category);
    refresh();
  }

  public void setCategoryFilterEnabled(boolean isEnabled) {
    this.categoryFilter.setEnabled(isEnabled);
    refresh();
  }
  
  // Other controller methods
}