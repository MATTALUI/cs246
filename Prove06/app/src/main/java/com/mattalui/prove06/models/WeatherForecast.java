package com.mattalui.prove06.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecast {

  @SerializedName("list")
  public List<WeatherForecastItem> forecastData;

  public WeatherForecast(){
    this.forecastData = new ArrayList<WeatherForecastItem>();
  }
}
