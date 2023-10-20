## HW2 New features
The list of transactions was encapsulated and made immutable.

Other things added in this revision include a filter for an amount and a filter for a category.

To apply these filters they need to be filled with valid categories or amounts, enter needs to be pressed to confirm the text, and the checkbox needs to be checked.

Both filters can be applied at the same time.

New filters can be added by adding new implementations of the Transaction filter, adding the components to the view and adding event listeners to the App for these components.

## implementation
Modularity: Open-Closed Principle:
Apply encapsulation for the list of transactions. 

    In the file ExpenseTrackerModel.java – Changed List<Transacion> transactions from public to private. 

Apply immutability on the list of transactions when the getter method is invoked.

    In the file ExpenseTrackerModel.java – Instead of returning the transactions list, the getter is modified to now return a copy of the list; this prevents direct access to the original list and, therefore, provides immutability when the getter method is invoked.

Apply changes to the “‘Transaction” class to prevent external data modification. Ensure information hiding for the declared fields. Some methods may be necessary to remove to make the class immutable.

    In the file Transaction.java – Changed the three variables, amount, category, and timestamp, from public to private final to imply immutability. Then, setter methods are removed to prevent possible external modifications further.


Extensibility: Strategy Design Pattern:

    The file “TransactionFilter.java” was created with the interface “TransactionFilter” where the filter method is defined, as well as setters and getters for an enable for the filter

    Next, two files “AmountFilter.java” and “CategoryFilter.java” were created, each containing the corresponding methods AmountFilter and CategoryFilter, both implement the methods from TransactionFilter. They also each contain a private filter value and enable boolean that holds the value used to filter and whether to filter at all. 

    In the Controller a method called applyFilters was created, which takes the transactions list from the model and applies both the amountFilter and Category filter to it if they were enabled, using the values stored in each filter respectively. This is also where the inputValidation is used to make sure the values are valid for the filters before applying them

    In the View the fields that the user types into for each filter were added, as well as a checkbox for each filter to enable it. Each of these user inputs has a getter method written for it as well. 

    In the App each of these user inputs were grabbed from their getter and had an actionListener attached to them that set the values and enables in the filters that are in the controller.

    Last but not least in the refresh method in the controller we override the default renderer for the transactionTable of the view to display rows that match the filters in a highlighted background.
