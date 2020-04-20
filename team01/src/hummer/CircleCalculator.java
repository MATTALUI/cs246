package hummer;

public class CircleCalculator {

  private double getRadius() {
    Scanner scanner = new Scanner( System.in );
    System.out.print( "Please provide a radius for you new circle: " );
    double radius = scanner.nextLine();
    return radius;
  }

  
}
