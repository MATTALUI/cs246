package hummer;

import java.util.HashMap;

public class Player {
  String name;
  int health;
  int mana;
  int gold;
  public HashMap<String, Integer> equipment;

  public Player() {
    equipment = new HashMap<String, Integer>();
  }


  void display() {
    System.out.println("name: " + name);
    System.out.println("health: " + health);
    System.out.println("mana: " + mana);
    System.out.println("gold: " + gold);
    System.out.println("equipment: " + equipment);
  }
}
