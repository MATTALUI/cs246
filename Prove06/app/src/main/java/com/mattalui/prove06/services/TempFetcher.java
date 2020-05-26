package com.mattalui.prove06.services;



import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import com.mattalui.prove06.BuildConfig;
import com.mattalui.prove06.GetForecast;
import com.mattalui.prove06.models.WeatherConditions;

import java.util.HashMap;

public class TempFetcher implements Runnable {
    public String location;
    public GetForecast context;

    public TempFetcher(GetForecast _context, String _location){
        this.context = _context;
        this.location = _location;
    }

    @Override
    public void run(){
        Log.d("WEATHERAPI", "Getting temperature for " + this.location);
        String weatherDataResponse = getWeatherData();

        final TempFetcher _that = this;
        final String temperatureString = formatTemperatureMessage(weatherDataResponse);
        this.context.runOnUiThread(new Runnable(){
            @Override
            public void run(){
                Toast myToast = Toast.makeText(_that.context, temperatureString, Toast.LENGTH_LONG);
                myToast.show();
            }
        });
    }

    private String getWeatherData(){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("apiKey", BuildConfig.WEATHER_API_KEY);
        params.put("units", "imperial");
        params.put("q", this.location);

        return QuickHTTP.get("https://api.openweathermap.org/data/2.5/weather", params);
    }

    private String formatTemperatureMessage(String responseData){
        Gson gson = new Gson();

        ResponseChecker checker = gson.fromJson(responseData, ResponseChecker.class);

        String temperatureMessage = "An error has occured. Don't know what happened!";
        if (checker.code.equals("200")){
            WeatherConditions weather = gson.fromJson(responseData, WeatherConditions.class);
            float temp = weather.measurements.get("temp");
            temperatureMessage = "The temperature in " + this.location + " is " + temp + " degrees (F).";
        }else if(checker.code.equals("404")) {
            temperatureMessage = "Unable to get the weather for " + this.location + ". Please try a different location!";
        }else if (checker.code.equals("401")){
            temperatureMessage = "Unable to get the weather for " + this.location + ". API KEY is incorrect! :(";
        }

        return temperatureMessage;
    }
}
