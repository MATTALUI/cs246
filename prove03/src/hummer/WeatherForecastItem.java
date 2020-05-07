package hummer;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WeatherForecastItem {

  @SerializedName("dt_txt")
  String date;
  @SerializedName("main")
  HashMap<String, Float> measurements;
  HashMap<String, Float> wind;
  List<WeatherItem> weather;

  public WeatherForecastItem() {
    measurements = new HashMap<String, Float>();
    wind = new HashMap<String, Float>();
  }

  public void display() {
    System.out.println("Date: " + date);
    System.out.println("Temperature: " + measurements.get("temp"));
    System.out.println("Wind Speed: " + wind.get("speed"));
    System.out.println("Weather Conditions:");
    for (WeatherItem item : weather) {
      System.out.println("\t" + item.description);
    }
    System.out.println();
  }
}
