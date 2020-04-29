package hummer;

public class Cruise implements Expense {

  Destination destination;

  public Cruise(Destination newDestination){
    destination = newDestination;
  }

  public float getCost() {
    float cost = 0.0f;

    if( destination == Destination.Mexico) {
      cost = 1000.00f;
    } else if( destination == Destination.Europe) {
      cost = 2000.00f;
    } else if( destination == Destination.Japan) {
      cost = 3000.00f;
    }

    return cost;
  }
}
