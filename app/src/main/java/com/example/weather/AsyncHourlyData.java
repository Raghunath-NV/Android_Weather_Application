package com.example.weather;

import android.os.AsyncTask;
import android.util.Log;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Raghu on 3/3/16.
 */
public class AsyncHourlyData extends AsyncTask<String,Void,ArrayList<Weather>> {

    IWeather activity;

    public AsyncHourlyData(IWeather activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<Weather> doInBackground(String... params)
    {


        try {
            URL url =new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.connect();

            int statusCode = con.getResponseCode();

            if(statusCode == HttpURLConnection.HTTP_OK)
            {
                InputStream in = con.getInputStream();

                return WeatherUtilPull.WeatherPullParser.parseWeather(in);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    protected void onPostExecute(ArrayList<Weather> weathers)
    {
        super.onPostExecute(weathers);
       Log.d("raghu", "entred post" + weathers.size());
        int min = Integer.parseInt(weathers.get(0).getTemperature());
        int max =min;
        for(Weather w:weathers)
        {
            if(min > Integer.parseInt(w.getTemperature()))
            {
                min = Integer.parseInt(w.getTemperature());
            }

            if(max < Integer.parseInt(w.getTemperature()))
            {
                max = Integer.parseInt(w.getTemperature());
            }

        }

        for(Weather w:weathers)
        {
            w.setMaximumTemp(max+"");
            w.setMinimumTemp(min+"");
        }
        activity.getWeather(weathers);


    }


    public static interface IWeather
    {
        public void getWeather(ArrayList<Weather> Wlist);
    }
}
