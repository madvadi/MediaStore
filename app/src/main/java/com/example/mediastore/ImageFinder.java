package com.example.mediastore;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ImageFinder extends ArrayAdapter<Uri> {

    Uri somestring;
    public ImageView image;

    public ImageFinder(@NonNull Context context, ArrayList<Uri>  AA) {

        super(context,0, AA);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        Log.d("position","which is " + position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.imagedraw_temp, parent, false);
        }

        somestring = getItem(position);

        Log.d("",somestring.getPath());


        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        if (somestring != null && !somestring.equals(Uri.EMPTY)) {

            image.setImageURI(somestring);
            Log.d("","Success loading");
        }
       /* else
        {
            image.setImageResource(R.drawable.ic_launcher_background);
            Log.d("","Fucking nothing");
        }*/



        /*TextView TV = (TextView)convertView.findViewById(R.id.text1);

        TV.setText(somestring);*/

        return convertView;
    }



}
