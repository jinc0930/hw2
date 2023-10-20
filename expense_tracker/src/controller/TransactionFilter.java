package controller;

import java.util.List;

import model.Transaction;

interface TransactionFilter {

    public List<Transaction> filter(List<Transaction> transactions); //the filter function

    public void setEnabled(boolean isEnabled); // allows for enabling and disabling the filter

    public boolean getEnabled(); //check to see if the filter should be enabled or not

}