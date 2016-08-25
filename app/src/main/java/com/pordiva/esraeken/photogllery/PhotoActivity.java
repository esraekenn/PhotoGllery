package com.pordiva.esraeken.photogllery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        image=(ImageView)findViewById(R.id.big_image);

String url =getIntent().getExtras().getString("photo");
        Picasso.with(this).load (url)
                .centerCrop()
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(image);

    }
}
