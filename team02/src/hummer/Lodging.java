package hummer;

public class Lodging implements Expense {

  Destination destination;
  int nights;
  float taxRate

  public Dining(Destination newDestination, int numberOfNights){
    destination = newDestination;
    nights = numberOfNights;

    if( destination == Destination.Mexico) {
      taxRate = 0.0f;
    } else if( destination == Destination.Europe) {
      taxRate = 0.1f;
    } else if( destination == Destination.Japan) {
      taxRate = 0.3f;
    }
  }


  public float getCost() {
    float rate = 0.0f;

    if( destination == Destination.Mexico) {
      rate = 10.00f;
    } else if( destination == Destination.Europe) {
      rate = 20.00f;
    } else if( destination == Destination.Japan) {
      rate = 30.00f;
    }
    float cost = rate * nights

    return cost *= 1 + taxRate;
  }
}
