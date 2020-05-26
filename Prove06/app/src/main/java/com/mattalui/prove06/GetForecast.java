package com.mattalui.prove06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.mattalui.prove06.models.WeatherForecastItem;
import com.mattalui.prove06.services.ForecastFetcher;
import com.mattalui.prove06.services.TempFetcher;

public class GetForecast extends AppCompatActivity {
    public EditText locationInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        locationInput = (EditText)findViewById(R.id.locationInput);
    }


    public void getTemperature(View v) {
        System.out.println("Get temperature for: " + locationInput.getText().toString());
        String location = locationInput.getText().toString();
        Thread thread = new Thread(new TempFetcher(this, location));

        thread.start();

    }

    public void getForecast(View v) {
        System.out.println("Get forecast for: " + locationInput.getText().toString());
        String location = locationInput.getText().toString();
        Thread thread = new Thread(new ForecastFetcher(this, location));

        thread.start();
    }

    public void setForecastData(ArrayAdapter<WeatherForecastItem> itemsAdapter){
        ListView listView = (ListView) findViewById(R.id.forecastView);
        listView.setAdapter(itemsAdapter);
    }
}
