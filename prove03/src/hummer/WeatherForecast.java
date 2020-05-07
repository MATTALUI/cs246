package hummer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast {

  @SerializedName("list")
  List<WeatherForecastItem> forecastData;
}
