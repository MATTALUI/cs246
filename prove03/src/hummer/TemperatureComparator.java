package hummer;

import java.util.Comparator;

public class TemperatureComparator implements Comparator<TopWeatherWidget> {
  public int compare(TopWeatherWidget w1, TopWeatherWidget w2) {
    return Float.compare(w1.maxTemp, w2.maxTemp);
  }
}
