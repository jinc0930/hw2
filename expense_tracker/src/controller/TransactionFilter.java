package controller;

import java.util.List;

import model.Transaction;

interface TransactionFilter {

    public List<Transaction> filter(List<Transaction> transactions);

    public void setEnabled(boolean isEnabled);

    public boolean getEnabled();

}