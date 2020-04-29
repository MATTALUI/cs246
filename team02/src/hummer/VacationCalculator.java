package hummer;

import java.util.List;
import java.util.ArrayList;

public class VacationCalculator {

  public static void main(String[] args) {

    VacationCalculator vc = new VacationCalculator();

    // Calculate some vacation costs...
    float japanCost = vc.calculateVacationCost(Destination.Japan);

    // Print the cost...
    System.out.format("The cost of a trip to japan is %.2f", japanCost);
  }

  /**
  * Calculates the total cost for vacationing at a given location for
  * a specific number of nights.
  *
  * @param  dest the destination of the vacation
  * @return      the total cost of the vacation
  */
  public float calculateVacationCost(Destination dest)
  {
    List<Expense> expenses = new ArrayList<Expense>();

    expenses.add(new Cruise(dest));

    return tallyExpenses(expenses);
  }

  /**
  * An internal method used by VacationCalculator to loop through
  * a List of items that implement the Expense interface and
  * determine their cost
  *
  * @param  expenses A list of items that implement the Expense interface
  * @return          the total cost calculated by the items
  */
  float tallyExpenses(List<Expense> expenses)
  {
    float totalCosts = 0.0f;

    for (int i = 0; i < expenses.size(); i++) {
      totalCosts += expenses.get(i).getCost();
    }

    return totalCosts;
  }
}
