import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import model.Transaction;
import controller.InputValidation;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    view.getAmountFilter().addActionListener(e -> {
      double amount = 0;
      if(!view.getAmountFilter().getText().isEmpty()) {
        amount = Double.parseDouble(view.getAmountFilter().getText());
      }
      controller.setAmountFilterValue(amount);
      System.out.println(amount);

    });

    view.getCategoryFilter().addActionListener(e -> {
      String category = view.getCategoryFilter().getText();
      controller.setCategoryFilterValue(category);
      System.out.println(category);
    });

    view.getAmountFilterEnable().addActionListener(e -> {
      controller.setAmountFilterEnabled(view.getAmountFilterEnable().isSelected());
      System.out.println("Enabled amount");

    });

    view.getCategoryFilterEnable().addActionListener(e -> {
      controller.setCategoryFilterEnabled(view.getCategoryFilterEnable().isSelected());
      System.out.println("Enabled category");

    });

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

  }

}