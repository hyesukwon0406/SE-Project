package com.hyesuhandh.dasoni.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hyesuhandh.dasoni.Model.Img_rc_Model;
import com.hyesuhandh.dasoni.R;

import java.util.ArrayList;


public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.MyViewHolder> {

    private ArrayList<Img_rc_Model> arrayList;
    private Context context;

    public ImgAdapter(ArrayList<Img_rc_Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImage())
                .into(holder.tv_img);
        holder.tv_txt.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        //삼항 연산자
        return (arrayList !=null ? arrayList.size():0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_img;
        TextView tv_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_img = itemView.findViewById(R.id.tv_img);
            this.tv_txt = itemView.findViewById(R.id.tv_txt);

        }
    }
}


