package hummer;

import java.util.Scanner;

class Test {
  public static void main(String[] args) {
    Scanner scanner = new Scanner( System.in );
    User user = new User();
    Boolean passwordNeeded = true;

    do {
      // Have user input a password
      System.out.println("Please enter a password: ");
      String password = scanner.nextLine();
      user.setPassword(password);

      // Print data of User before it is hashed
      System.out.println("====BEFORE HASHING====");
      System.out.println("Password: " + user.getPassword());
      System.out.println("Salt: " + user.getSalt());
      System.out.println("HashedPassword: " + user.getHashedPassword());

      // Driver! Hash! That! Password!
      try {
        NSALoginController.hashUserPassword(user);
        passwordNeeded = false;
      } catch (WeakPasswordException error) {
        System.out.println();
        System.out.println(error.getMessage());
      } catch (Exception error) {
        System.out.println("An error occurred.");

        return;
      }
    } while (passwordNeeded);

    // Print data after it's hashed to make sure it worked
    System.out.println("====AFTER HASHING=====");
    System.out.println("Password: " + user.getPassword());
    System.out.println("Salt: " + user.getSalt());
    System.out.println("HashedPassword: " + user.getHashedPassword());
    System.out.println("======================");

    // Reenter password and confirm it matches
    System.out.println("Please reenter a password: ");
    String password = scanner.nextLine();
    user.setPassword(password);
    Boolean match;
    try {
      match = NSALoginController.verifyPassword(user);
    } catch (Exception e) {
      match = false;
    }
    if (match) {
      System.out.println("Password Matches!");
    } else {
      System.out.println("Password does not Match! :(");
    }


  }
}
