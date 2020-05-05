public class Test {
  public static void main(String[] args) {
    System.out.println("running a Test");

    Test.initint();
  }

  public static void checkEquality() {
    Integer x = 200;
    Integer y = 200;

    if(x == y) {
      System.out.println("infinite loop");
    } else {
      System.out.println("doesnt run");
    }
  }

  public static void initint() {
    Integer num = 34;
    System.out.println(34);
  }
}
