package com.example.mediastore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


public class Animate extends Activity {

    private ImageSwitcher imageS;



    @Override
    protected void onCreate(Bundle State_an)
    {
        super.onCreate(State_an);
        setContentView(R.layout.animate_layout);

        Log.d(null,"Animate's onCreate()");

        addListenerOnButton12();

        //ImageView
        imageS = (ImageSwitcher) findViewById(R.id.image);

        imageS.setFactory(new ViewSwitcher.ViewFactory() {

        public View makeView() {
            ImageView imageView = new ImageView(getApplicationContext());
            return imageView;
        }
      });

        Log.d(null,"After find view" + MainActivity.AddImage.get(0)+ " at this position");

       imageS.setImageURI(MainActivity.AddImage.get(0));

    }

    public void animate_frames(View view) throws InterruptedException {

        // stuffffjslafjl;as
        Handler Handle = new Handler(Looper.getMainLooper());
        Handle.post(new Runnable() {
            int i = 0;
            @Override
            public void run() {

                    //Log.d(null,"Loop at "+ i + "\n");
                    imageS.setImageURI(MainActivity.AddImage.get(i));

                    if(i<(MainActivity.AddImage.size()-1))
                    {
                        imageS.postDelayed(this::run,500);
                        i = i + 1;
                    }

            }
        });
    }
    public void addListenerOnButton12() {

        Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                Intent intent = new Intent(Animate.this,MainActivity.class);

                startActivity(intent);

            }
        });
    }



}
