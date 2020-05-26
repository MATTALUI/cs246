package com.mattalui.prove06.services;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.google.gson.Gson;
import com.mattalui.prove06.BuildConfig;
import com.mattalui.prove06.GetForecast;
import com.mattalui.prove06.models.WeatherForecast;
import com.mattalui.prove06.models.WeatherForecastItem;
import java.util.HashMap;
import java.util.List;

public class ForecastFetcher implements Runnable {
    private String location;
    private GetForecast context;

    public ForecastFetcher(GetForecast _context, String _location){
        location = _location;
        context = _context;
    }

    public void run(){
        Log.d("WEATHERAPI", "Getting forecast for " + this.location);
        String forecastResponseData = getForecastData();
        parseData(forecastResponseData);
    }

    private String getForecastData(){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("apiKey", BuildConfig.WEATHER_API_KEY);
        params.put("units", "imperial");
        params.put("q", this.location);

        return QuickHTTP.get("https://api.openweathermap.org/data/2.5/forecast", params);
    }

    private WeatherForecast parseData(String response){
        final ForecastFetcher _that = this;
        Gson gson = new Gson();
        ResponseChecker checker = gson.fromJson(response, ResponseChecker.class);

        WeatherForecast forecast;
        if (checker.code.equals("200")){
            forecast = gson.fromJson(response, WeatherForecast.class);
        }else{
            this.context.runOnUiThread(new Runnable(){
                @Override
                public void run(){
                    String message = "Unable to get a forecast for " + _that.location;
                    Toast myToast = Toast.makeText(_that.context, message, Toast.LENGTH_LONG);
                    myToast.show();
                }
            });
            forecast = new WeatherForecast();
        }

        List<WeatherForecastItem> forecastItems = forecast.forecastData;
        final ArrayAdapter<WeatherForecastItem> itemsAdapter = new ArrayAdapter<WeatherForecastItem>(_that.context, android.R.layout.simple_list_item_1, forecastItems);
        this.context.runOnUiThread(new Runnable(){
            @Override
            public void run(){
                _that.context.setForecastData(itemsAdapter);
            }
        });
        return forecast;
    }
}
