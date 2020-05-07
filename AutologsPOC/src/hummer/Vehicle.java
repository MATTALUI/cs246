package hummer;

import java.util.List;

public class Vehicle {
  int id;
  String make; // required
  String model; // required
  String year;
  String nickname;
  String description;
  // Associative IDs
  // int owner;
  // List<AutoLog> logs;

  public void display() {
    System.out.println("Vehicle {");
    System.out.println("\tmake: " + make);
    System.out.println("\tmodel: " + model);
    System.out.println("\tyear: " + year);
    System.out.println("\tnickname: " + nickname);
    System.out.println("\tdescription: " + description);
    System.out.println("}");
  }
}
