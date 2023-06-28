package com.example.tik_tok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tik_tok.databinding.ReelDgBinding;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.videoHolder>{
     Context context;
     ArrayList<model> modelArrayList=new ArrayList<>();

    public adapter(Context context, ArrayList<model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
     @Override
     public videoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_dg,parent,false);
         return new videoHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull videoHolder holder, int position) {
        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideourl());
        holder.binding.name.setText(modelArrayList.get(position).getName());
        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });

     }

     @Override
     public int getItemCount() {
         return modelArrayList.size();
     }

     public class videoHolder extends RecyclerView.ViewHolder {
        ReelDgBinding binding;
        public videoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelDgBinding.bind(itemView);
        }
    }
}
