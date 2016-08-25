package com.pordiva.esraeken.photogllery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pordiva.esraeken.photogllery.model.photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esraeken on 24/08/16.
 */
public class photoadapter extends RecyclerView.Adapter<photoviewholder> {
    private List<photo> photoList;
    private Context c;
    private Picasso picasso;

    public photoadapter(Context context) {
        photoList = new ArrayList<>();
        this.c = context;
        picasso = Picasso.with(context);
    }

    @Override
    public photoviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satir, parent, false);

        photoviewholder photoviewholder = new photoviewholder(view, c);
        return photoviewholder;
    }

    @Override
    public void onBindViewHolder(photoviewholder holder,final int position) {

        picasso.load(photoList.get(position).getThumbnailUrl())
                .centerCrop()
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(holder.image);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(c, PhotoActivity.class);
                    i.putExtra("photo",photoList.get(position).getThumbnailUrl()) ;
                    c.startActivity(i);
                }
            });

    }


    public void updateList(List<photo> list) {
        photoList = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
