package hummer;

import java.util.HashMap;

public class App {

  public App(String[] args){
    HashMap<String, String> data = new HashMap<String, String>();
    data.put("city", "fort collins");
    data.put("need money", "true");
    data.put("third", "parameters are fun!");
    System.out.println(QuickHTTP.get("www.cats.com", data));
  }
}
