package com.pordiva.esraeken.photogllery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by esraeken on 24/08/16.
 */
public class photoviewholder extends RecyclerView.ViewHolder
{
    public ImageView image;
    public ImageView image2;
    private Context context;

    public photoviewholder(View itemView,Context c)
    {
        super(itemView);
        context=c;
        image= (ImageView) itemView.findViewById(R.id.small_image);
        image2= (ImageView) itemView.findViewById(R.id.big_image);
    }
}
