package com.example.weather;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.XMLFormatter;

/**
 * Created by Raghu on 3/3/16.
 */



public class WeatherUtilPull
{

    static public class WeatherPullParser
    {


        static ArrayList<Weather> parseWeather(InputStream in) throws XmlPullParserException, IOException {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(in,"UTF-8");
            ArrayList<Weather> weatherList =new ArrayList<Weather>();
            Weather weather = null;
            int event=parser.getEventType();
            int flag = 0,flag2=0;

            while(event!=XmlPullParser.END_DOCUMENT)
            {
                switch(event)
                {

                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("forecast"))
                        {

                            weather = new Weather();
                            flag=0;
                        }
                       else if(parser.getName().equals("hour"))
                        {
                            int hr =Integer.parseInt(parser.nextText().trim());
                            String time;
                            {
                                if(hr>12)
                                {
                                    hr=hr%12;
                                    time="pm";
                                }
                                else
                                {
                                    time="am";
                                }
                            }
                            weather.setTime(hr+":00"+time);

                        }
                        else if(parser.getName().equals("english"))
                        {
                            flag++;
                            if(flag==1)
                            {
                                weather.setTemperature(parser.nextText());

                            }
                            else if(flag==2)
                            {
                                weather.setDewpoint(parser.nextText());
                            }
                            else if(flag==3)
                            {
                                weather.setWindSpeed(parser.nextText());
                            }
                            else if(flag==6)
                            {
                                weather.setFeelsLike(parser.nextText());
                            }


                        }

                        else if(parser.getName().equals("condition"))
                        {
                            weather.setClouds(parser.nextText().trim());

                        }

                        else if (parser.getName().equals("icon_url"))
                        {
                            weather.setIconUrl(parser.nextText().trim());
                            Log.d("condition", "raghu in" + weather.getIconUrl());
                        }

                        else if(parser.getName().equals("wx"))
                        {
                            weather.setClimateType(parser.nextText().trim());

                        }
                        else if(parser.getName().equals("humidity"))
                        {
                            weather.setHumidity(parser.nextText().trim());

                        }

                        else if(parser.getName().equals("mslp"))
                        {
                            flag2=1;
                        }

                        else if(parser.getName().equals("metric") && flag2==1)
                        {
                            weather.setPressure(parser.nextText().trim());
                            flag2=0;
                        }

                        else if(parser.getName().equals("wdir"))
                        {
                            event = parser.nextTag();
                            if(event== XmlPullParser.START_TAG)
                            {
                                weather.setWindDirection(parser.nextText().trim());
                            }
                            event = parser.nextTag();
                            if(event== XmlPullParser.START_TAG)
                            {
                                weather.setWindDegree(parser.nextText().trim());
                            }

                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("forecast"))
                        {
                            weatherList.add(weather);
                        }

                        break;
                }

                event = parser.next();
            }

            return weatherList;
        }
    }
}

