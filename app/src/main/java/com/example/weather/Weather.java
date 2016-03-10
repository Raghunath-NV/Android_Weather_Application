package com.example.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Raghu on 3/2/16.
 */
public class Weather implements Parcelable
{
    String time;
    String temperature;
    String dewpoint;
    String clouds;
    String iconUrl;
    String windSpeed;
    String windDirection;
    String climateType;
    String humidity;
    String feelsLike;
    String maximumTemp;
    String minimumTemp;
    String pressure;
    String windDegree;

    protected Weather(Parcel in) {
        time = in.readString();
        temperature = in.readString();
        dewpoint = in.readString();
        clouds = in.readString();
        iconUrl = in.readString();
        windSpeed = in.readString();
        windDirection = in.readString();
        climateType = in.readString();
        humidity = in.readString();
        feelsLike = in.readString();
        maximumTemp = in.readString();
        minimumTemp = in.readString();
        pressure = in.readString();
        windDegree = in.readString();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    @Override
    public String toString() {
        return "Weather{" +
                "time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", dewpoint='" + dewpoint + '\'' +
                ", clouds='" + clouds + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", climateType='" + climateType + '\'' +
                ", humidity='" + humidity + '\'' +
                ", feelsLike='" + feelsLike + '\'' +
                ", maximumTemp='" + maximumTemp + '\'' +
                ", minimumTemp='" + minimumTemp + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }




    public void setTime(String time) {
        this.time = time;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setDewpoint(String dewpoint) {
        this.dewpoint = dewpoint;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(String windDirection)
    {
        String dir="East";
        if(windDirection.charAt(0)=='S')
        {
            dir="South";
        }
        else if(windDirection.charAt(0)=='N')
        {
            dir="North";
        }
        else if(windDirection.charAt(0)=='W')
        {
            dir="West";
        }
        this.windDirection = dir;
    }

    public void setClimateType(String climateType) {
        this.climateType = climateType;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setMaximumTemp(String maximumTemp) {
        this.maximumTemp = maximumTemp;
    }

    public void setMinimumTemp(String minimumTemp) {
        this.minimumTemp = minimumTemp;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Weather() {

    }

    public String getTime() {

        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getDewpoint() {
        return dewpoint;
    }

    public String getClouds() {
        return clouds;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getClimateType() {
        return climateType;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getMaximumTemp() {
        return maximumTemp;
    }

    public String getMinimumTemp() {
        return minimumTemp;
    }

    public String getPressure() {
        return pressure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(String windDegree) {
        this.windDegree = windDegree;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(temperature);
        dest.writeString(dewpoint);
        dest.writeString(clouds);
        dest.writeString(iconUrl);
        dest.writeString(windSpeed);
        dest.writeString(windDirection);
        dest.writeString(climateType);
        dest.writeString(humidity);
        dest.writeString(feelsLike);
        dest.writeString(maximumTemp);
        dest.writeString(minimumTemp);
        dest.writeString(pressure);
        dest.writeString(windDegree);
    }
}
