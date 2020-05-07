package hummer;

import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;

public class TopWeatherWidget {
  String location;
  WeatherForecast forecast;
  float maxTemp;
  float maxWindSpeed;

  public TopWeatherWidget(String _location, String apiKey){
    location = _location;
    maxTemp = 0;
    maxWindSpeed = 0;

    String baseUrl = "https://api.openweathermap.org/data/2.5/forecast";
    String query = String.format("units=imperial&apiKey=%s&q=%s", apiKey, URLEncoder.encode(location));
    String url = baseUrl + "?" + query;

    try{
      InputStream response = new URL(url).openStream();
      String data = new Scanner(response).useDelimiter("\\A").next();
      forecast = new Gson().fromJson(data, WeatherForecast.class);

    } catch (MalformedURLException e){
      System.out.println("Your URL is bad.");
    } catch (IOException e){
      System.out.println("An Error has occured.");
    }

    for (WeatherForecastItem item : forecast.forecastData) {
      float temp = item.measurements.get("temp");
      if (temp > maxTemp){
        maxTemp = temp;
      }

      float windSpeed = item.wind.get("speed");
      if (windSpeed > maxWindSpeed){
        maxWindSpeed = windSpeed;
      }
    }
  }

  public void display () {
    System.out.println(location);
    System.out.println("\tHigh Temp: " + maxTemp);
    System.out.println("\tHigh Wind Speed: " + maxWindSpeed);
    System.out.println();

  }
}
