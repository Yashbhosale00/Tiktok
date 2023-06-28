package com.example.tik_tok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.tik_tok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<model> arrayList  = new ArrayList<>();
    Adapter adapter; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

//        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.sample,R.drawable.man,"Yash Bhosale"));
//        int rawId = getResources().getIdentifier("sample",  "raw", getPackageName());
////        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.habibi,R.drawable.man,"Yash Bhosale"));
////        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.habibi,R.drawable.man,"Yash Bhosale"));
////        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.habibi,R.drawable.man,"Yash Bhosale"));
////        arrayList.add(new model("android.resource://" + getPackageName() + "/" + R.raw.habibi,R.drawable.man,"Yash Bhosale"));
//
//        Log.d("video path", arrayList.get(0).toString());
//        adapter Adapter = new adapter(MainActivity.this, arrayList);
//
//        //Somewhere set the video name variable
//        String videoname="myvideo";
//setup up and play video

        VideoView videoView=(VideoView)findViewById(R.id.videoViewmain);
        videoView.setVisibility(View.VISIBLE);
        String uriPath = "android.resource://"+getPackageName()+"/raw/"+ R.raw.fortuner ;


        Uri UrlPath=Uri.parse(uriPath);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(UrlPath);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                    try{
                        videoView.requestFocus();
                        videoView.start();
                    }catch (Exception e) {
                        System.out.printf("Error playing video %s\n", e);
                    }

            }
        });

    }
}