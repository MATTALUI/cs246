package com.mattalui.autologpocclient.models;

public class AutoLog {
  public int id;
  public float miles;
  public float fillupAmount;
  public float fillupCost;
  String note;
  String location;
  String coords;
  // Associative IDs
  // int user;
  int vehicle;

  public void display() {
    System.out.println("AutoLog {");
    System.out.println("\tid: " + id);
    System.out.println("\tmiles: " + miles);
    System.out.println("\tfillupAmount: " + fillupAmount);
    System.out.println("\tfillupCost: " + fillupCost);
    System.out.println("\tnote: " + note);
    System.out.println("\tlocation: " + location);
    System.out.println("\tcoords: " + coords);
    System.out.println("}");
  }
}
