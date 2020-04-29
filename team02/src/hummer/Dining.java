package hummer;

public class Dining implements Expense {

  Destination destination;
  int nights;

  public Dining(Destination newDestination, int numberOfNights){
    destination = newDestination;
    nights = numberOfNights;
  }


  public float getCost() {
    float cost = 0.0f;

    if( destination == Destination.Mexico) {
      cost = 10.00f;
    } else if( destination == Destination.Europe) {
      cost = 20.00f;
    } else if( destination == Destination.Japan) {
      cost = 30.00f;
    }

    return cost * nights;
  }
}
