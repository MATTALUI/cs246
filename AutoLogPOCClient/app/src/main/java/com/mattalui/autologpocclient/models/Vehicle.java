package com.mattalui.autologpocclient.models;

import java.util.List;

public class Vehicle {
  public int id;
  public String make; // required
  public String model; // required
  public String year;
  public String nickname;
  public String description;
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
