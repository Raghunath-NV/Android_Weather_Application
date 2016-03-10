package com.example.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import com.squareup.picasso.Picasso;

/**
 * Created by Raghu on 3/2/16.
 */
public class WeatherAdapter extends ArrayAdapter {



    List<Weather> mData;
    Context mContext;
    int resource;
    String [] imageUrls;



    ImageView img;
    public WeatherAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext=context;
        this.resource=resource;
        mData=objects;
        this.imageUrls = imageUrls;
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }
        Weather c= mData.get(position);
        TextView tv1= (TextView) convertView.findViewById(R.id.textView4);
        TextView tv2= (TextView) convertView.findViewById(R.id.textView5);
        TextView tv3= (TextView) convertView.findViewById(R.id.textView6);
         img= (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.with(getContext()).load(c.getIconUrl()).into(img);


        tv1.setText(c.getTime());
        tv2.setText(c.getClimateType()+"  ");
        tv3.setText(c.getTemperature() + "°F");
        return convertView;


    }





 /*   public class getImage extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... params)
        {
            try {
                URL url = new URL(params[0]);

                HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                urlConn.setRequestMethod("GET");
                InputStream in = urlConn.getInputStream();
                Bitmap image = BitmapFactory.decodeStream(in);
                return image;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);

        }

    }*/


}
