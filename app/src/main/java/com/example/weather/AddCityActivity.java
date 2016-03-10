package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class AddCityActivity extends AppCompatActivity {

    EditText city,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        city = (EditText) findViewById(R.id.editText);
        state = (EditText) findViewById(R.id.editText2);
        setSupportActionBar(toolbar);
        setTitle("AddCityActivity");


    }


    public void saveCityClicked(View v) throws IOException {
        ArrayList <String> a1= new ArrayList<String>();
        String a=city.getText().toString();
        String b=state.getText().toString();
        if(a.length()==0 || b.length()==0)
        {
            Toast.makeText(this,"Please enter data in both fields",Toast.LENGTH_SHORT).show();
        }
        else if(b.length()!=2)
        {
            Toast.makeText(this,"Please enter only 2 letter intial of state",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //if(check(a,b)) {
                a1.add(a);
                a1.add(b);
                Intent i = new Intent(this, MainActivity.class);
                i.putStringArrayListExtra("place", a1);
                finish();
                startActivity(i);
            //}

        }
    }
/*public boolean check(String a,String b) throws IOException {
    URL u = new URL( "http://api.wunderground.com/api/2ccf82ffe190f1fd/hourly/q/b/a.json");
    HttpURLConnection huc = null;
    huc = (HttpURLConnection) u.openConnection();
    huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD");
    huc.connect () ;
    int code = huc.getResponseCode() ;
    Log.d("code", code + "");
    if(code==HttpURLConnection.HTTP_OK)
    return true;
    else
        return false;
}*/
}
