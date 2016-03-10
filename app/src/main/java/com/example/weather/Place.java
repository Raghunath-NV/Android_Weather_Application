package com.example.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Raghu on 3/1/16.
 */
public class Place implements Parcelable{


    String city,state;

    public Place(String city, String state) {
        this.city = city.trim().replace(" ","_");
        this.state = state;
    }

    protected Place(Parcel in) {
        city = in.readString();
        state = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getCity()
    {
        return city;
    }

    public String getState() {
        return state;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(state);
    }
}
