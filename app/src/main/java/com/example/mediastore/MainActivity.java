package com.example.mediastore;


import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

//import static com.example.mediastore.ImageFinder.AddImage;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    Button button;
    Button button1;
    static public ImageView image;
    static public ArrayList<Uri> AddImage;
    public ImageFinder T;
    public Animate obj_ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddImage = new ArrayList<Uri>();

        // they where added here

        AddImage.add(Uri.parse("android.resource://com.example.mediastore/drawable/ic_launcher_background"));

        T = new ImageFinder(this,AddImage);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(T);
        addListenerOnButton();
        addListenerOnButton1();

        //AttachT();
    }
    public void addListenerOnButton() {

        button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                opengallery();
            }
        });
    }
    private void opengallery()
    {
        Log.d(null,"AddImage.get() = "+AddImage.get(0));
        Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        startActivityForResult(g, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            T.add(intent.getData());
        }

    }
    public void addListenerOnButton1() {

        button1=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.d(null," onClick(View arg0)");

                Intent intent = new Intent(MainActivity.this,Animate.class);

                Log.d(null," startActivity Before");
                startActivity(intent);

            }
        });
    }

}