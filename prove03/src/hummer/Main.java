package hummer;

import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

public class Main {
  public final Gson gson;
  public final String apiKey;


  public static void main(String[] args) {
    new Main(args[0], new Gson()).useWeatherAPI();
  }

  public Main(String _apiKey, Gson _gson) {
    apiKey = _apiKey;
    gson = _gson;
  }

  public void useWeatherAPI(){
    System.out.println("WEATHER ========================");
    String url = buildWeatherUrl();
    String data = getData(url);
    WeatherConditions conditions = gson.fromJson(data, WeatherConditions.class);
    conditions.display();

    System.out.println("FORECAST =======================");
    url = buildForecastUrl();
    data = getData(url);
    WeatherForecast forecast = gson.fromJson(data, WeatherForecast.class);
    for (WeatherForecastItem forecastItem : forecast.forecastData) {
      forecastItem.display();
    }

    System.out.println("FIVE CITIES ====================");
    System.out.println("BY TEMP  =======================");
    List<TopWeatherWidget> fiveCities = new ArrayList<TopWeatherWidget>();
    fiveCities.add(new TopWeatherWidget("Fort Collins", apiKey));
    fiveCities.add(new TopWeatherWidget("Denver", apiKey));
    fiveCities.add(new TopWeatherWidget("Moira", apiKey));
    fiveCities.add(new TopWeatherWidget("San Diego", apiKey));
    fiveCities.add(new TopWeatherWidget("Orlando", apiKey));

    Collections.sort(fiveCities,  new Comparator<TopWeatherWidget>() {
      @Override
      public int compare(TopWeatherWidget w1, TopWeatherWidget w2) {
        return Float.compare(w2.maxTemp, w1.maxTemp);
      }
    });

    for (TopWeatherWidget widget : fiveCities) {
      widget.display();
    }

    System.out.println("BY WIND SPEED  ==================");
    Collections.sort(fiveCities,  new Comparator<TopWeatherWidget>() {
      @Override
      public int compare(TopWeatherWidget w1, TopWeatherWidget w2) {
        return Float.compare(w2.maxWindSpeed, w1.maxWindSpeed);
      }
    });

    for (TopWeatherWidget widget : fiveCities) {
      widget.display();
    }
  }

  public String getLocation() {
    System.out.println("ENTER LOCATION: ");
    return new Scanner(System.in).nextLine();
  }

  public String buildWeatherUrl() {
    String baseUrl = "https://api.openweathermap.org/data/2.5/weather";
    String location = getLocation();
    String query = String.format("units=imperial&apiKey=%s&q=%s", apiKey, URLEncoder.encode(location));

    return baseUrl + "?" + query;
  }

  public String buildForecastUrl() {
    String baseUrl = "https://api.openweathermap.org/data/2.5/forecast";
    String location = getLocation();
    String query = String.format("units=imperial&apiKey=%s&q=%s", apiKey, URLEncoder.encode(location));

    return baseUrl + "?" + query;
  }

  public String getData(String url) {
    String data = new String();
    try{
      InputStream response = new URL(url).openStream();
      data = new Scanner(response).useDelimiter("\\A").next();

    } catch (MalformedURLException e){
      System.out.println("Your URL is bad.");
    } catch (IOException e){
      System.out.println("An Error has occured.");
    }

    return data;
  }
}
