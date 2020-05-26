package com.mattalui.prove06.models;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class WeatherConditions {
  int id;
  String name;

  @SerializedName("main")
  public HashMap<String, Float> measurements;

  public WeatherConditions() {
    measurements = new HashMap<String, Float>();
  }

  public void display() {
    System.out.println("id: " + id);
    System.out.println("name: " + name);
    System.out.println("measurements: " + measurements);
  }
}
