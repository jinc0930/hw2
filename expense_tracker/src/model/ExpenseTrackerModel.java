package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerModel {

  //encapsulation to transactions 
  private List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    //make a copy of the transactions list in the getter function to ensure immutability
    List<Transaction> copyOfTransactions = new ArrayList<Transaction>();
    copyOfTransactions.addAll(this.transactions);
    return copyOfTransactions;
  }

}