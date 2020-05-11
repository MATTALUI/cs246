package hummer;

public class User {
  String email;
  String firstName;
  String lastName;
  String nickname;
  String description;

  public void display() {
    System.out.println("User {");
    System.out.println("\temail: " + email);
    System.out.println("\tfirstName: " + firstName);
    System.out.println("\tlastName: " + lastName);
    System.out.println("\tnickname: " + nickname);
    System.out.println("\tdescription: " + description);
    System.out.println("}");
  }
}
