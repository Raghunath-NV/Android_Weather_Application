package com.example.weather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HourlyDataActivity extends AppCompatActivity implements AsyncHourlyData.IWeather{

   ArrayList<Weather> weather=new ArrayList<Weather>();

    TextView tv;
    Place place;
    ListView lv;
    WeatherAdapter adapter;
    static ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("HourlyDataActivity");
        lv= (ListView) findViewById(R.id.listView2);
        adapter = new WeatherAdapter(this, R.layout.row_layout_hourly, weather);
        lv.setAdapter(adapter);
        adapter.setNotifyOnChange(true);
        pd=new ProgressDialog(this);
        pd.setMessage("Loading Hourly Data");
        pd.setCancelable(false);


        tv= (TextView) findViewById(R.id.textView3);
        place = getIntent().getParcelableExtra("place");
        tv.setText("Current Location: " + place.getCity().replace("_"," ") + ", " + place.getState());

        pd.show();
        new AsyncHourlyData(this).execute("http://api.wunderground.com/api/2ccf82ffe190f1fd/hourly/q/"+place.getState().trim()+"/"+place.getCity().trim()+".xml");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i=new Intent(HourlyDataActivity.this,DetailsActivity.class);
                i.putExtra("place",place);
                i.putExtra("position",position);
                i.putExtra("list",weather);
                startActivity(i);

            }
        });
    }

    @Override
    public void getWeather(ArrayList<Weather> Wlist)
    {
        weather = Wlist;

        pd.dismiss();

    }
}
