package com.example.bai1lab8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

class MyHolder extends RecyclerView.ViewHolder {

    public ImageView imageTo;
    public ImageView icon1;
    public ImageView icon2;



    public MyHolder(@NonNull View itemView) {
        super(itemView);

        imageTo = (ImageView) itemView.findViewById(R.id.imageTo);
        icon1 = (ImageView) itemView.findViewById(R.id.icon1);
        icon2 = (ImageView) itemView.findViewById(R.id.icon2);

    }
}
