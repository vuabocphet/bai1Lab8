package com.example.bai1lab8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    List<Gioithieu> gioithieus;
    int myLayout;

    public MyAdapter(Context context, List<Gioithieu> gioithieus, int myLayout) {
        this.gioithieus = gioithieus;
        this.context = context;
        this.myLayout = myLayout;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.imageTo.setImageResource(gioithieus.get(i).AnhTo);
        myHolder.icon1.setImageResource(gioithieus.get(i).Icon1);
        myHolder.icon2.setImageResource(gioithieus.get(i).Icon2);

        myHolder.imageTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Bạn vừa click vào ảnh",Snackbar.LENGTH_SHORT).show();

            }
        });

        myHolder.icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Bạn vừa click vào nút chụp",Snackbar.LENGTH_SHORT).show();
            }
        });

        myHolder.icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Bạn vừa click vào nút share",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gioithieus.size();
    }
}
