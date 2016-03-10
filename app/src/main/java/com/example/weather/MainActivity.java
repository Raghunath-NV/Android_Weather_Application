package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Place> places=new ArrayList<Place>();
    ListView lv;
    PlaceAdapter adapter;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lv= (ListView) findViewById(R.id.listView);
        tv= (TextView) findViewById(R.id.textView2);
        setSupportActionBar(toolbar);
        adapter = new PlaceAdapter(this, R.layout.row_layout, places);
        lv.setAdapter(adapter);
        setTitle("Homework 5");
        if(getIntent().getExtras()==null)
        {
            tv.setVisibility(View.VISIBLE);
        }
        else {
            tv.setVisibility(View.INVISIBLE);

                ArrayList<String> a = getIntent().getStringArrayListExtra("place");
                places.add(new Place(a.get(0), a.get(1)));


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Toast.makeText(MainActivity.this, "Pressed at position " + position, Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,HourlyDataActivity.class);
                    i.putExtra("place",places.get(position));
                    startActivity(i);


                }
            });

            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
                {
                    places.remove(position);
                    adapter.remove(position);

                    if(places.size()==0)
                    {
                        tv.setVisibility(View.VISIBLE);
                    }
                    return false;

                }
            });
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addCity)
        {
            Intent i =new Intent(this,AddCityActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
