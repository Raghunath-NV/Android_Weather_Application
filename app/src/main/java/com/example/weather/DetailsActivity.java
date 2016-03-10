package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ImageView img;
    TextView place,temp,maxtemp,mintemp,climate;
    TextView feelsLike,humidity,dewPoint,pressure,clouds,winds;

    ArrayList<Weather> weatherList;
    Place p;
    int position;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DetailsActivity");

        img = (ImageView) findViewById(R.id.imageView2);
        place = (TextView) findViewById(R.id.textView9);
        temp = (TextView) findViewById(R.id.textView10);
        climate = (TextView) findViewById(R.id.textView11);
        maxtemp = (TextView) findViewById(R.id.textView14);
        mintemp = (TextView) findViewById(R.id.textView15);
        feelsLike = (TextView) findViewById(R.id.textView17);
        humidity = (TextView) findViewById(R.id.textView19);
        dewPoint = (TextView) findViewById(R.id.textView21);
        pressure = (TextView) findViewById(R.id.textView23);
        clouds = (TextView) findViewById(R.id.textView25);
        winds = (TextView) findViewById(R.id.textView27);

        if(getIntent().getExtras()!=null)
        {
            Intent i = getIntent();
            p=i.getParcelableExtra("place");
            position = i.getIntExtra("position", 0);
            weatherList = i.getParcelableArrayListExtra("list");

        }
        maxtemp.setText(weatherList.get(position).getMaximumTemp()+" Fahrenheit");
        mintemp.setText(weatherList.get(position).getMinimumTemp()+" Fahrenheit");
        Display(position);
    }

    public void Display(int position)
    {
        Picasso.with(this).load(weatherList.get(position).getIconUrl()).into(img);
        place.setText(p.getCity().replace("_"," ") + ", " + p.getState() + " (" + weatherList.get(position).getTime() + ")");
        temp.setText(weatherList.get(position).getTemperature() + "°F");
        climate.setText(weatherList.get(position).getClimateType());
        feelsLike.setText(weatherList.get(position).getFeelsLike()+"Fahrenheit");
        humidity.setText(weatherList.get(position).getHumidity()+"%");
        dewPoint.setText(weatherList.get(position).getDewpoint()+" Fahrenheit");
        pressure.setText(weatherList.get(position).getPressure()+" hPa");
        clouds.setText(weatherList.get(position).getClouds());
        winds.setText(weatherList.get(position).getWindSpeed()+" mph,"+weatherList.get(position).getWindDegree()+"°"+weatherList.get(position).getWindDirection());
    }

    public void leftClicked(View v)
    {
        if(position-1 <0)
        {
            position=weatherList.size()-1;
        }
        else
        {
            position--;
        }
        Display(position);
    }

    public void rightClicked(View v)
    {
        if(position+1 >= weatherList.size())
        {
            position=0;
        }
        else
        {
            position++;
        }
        Display(position);
    }

}
