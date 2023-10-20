import javax.swing.JOptionPane;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);
    
    //Add a listener that passes the changed filter amount to the controller amountfilter
    view.getAmountFilter().addActionListener(e -> {
      double amount = 0;
      if(!view.getAmountFilter().getText().isEmpty()) {
        amount = Double.parseDouble(view.getAmountFilter().getText());
      }
      controller.setAmountFilterValue(amount);

    });
    //Add a listener that passes the changed filter category to the controller categoryfilter

    view.getCategoryFilter().addActionListener(e -> {
      String category = view.getCategoryFilter().getText();
      controller.setCategoryFilterValue(category);
    });
    //passes a change in checkbox to the amountFilter in the controller
    view.getAmountFilterEnable().addActionListener(e -> {
      controller.setAmountFilterEnabled(view.getAmountFilterEnable().isSelected());

    });

    //passes a change in checkbox to the categoryFilter in the controller
    view.getCategoryFilterEnable().addActionListener(e -> {
      controller.setCategoryFilterEnabled(view.getCategoryFilterEnable().isSelected());

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