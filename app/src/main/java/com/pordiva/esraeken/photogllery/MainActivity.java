package com.pordiva.esraeken.photogllery;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pordiva.esraeken.photogllery.constans.constans;
import com.pordiva.esraeken.photogllery.model.photo;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    photoadapter userAdapter;
    ImageView imageView;
    Context c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(c,3));
        recyclerView.setHasFixedSize(true);
        userAdapter=new photoadapter(this);
        recyclerView.setAdapter(userAdapter);


 SingeletonPhoto.getInstance().retrofitphoto().getPhotoList(new Callback<List<photo>>() {
        @Override
        public void success(List<photo> photos, Response response) {
            userAdapter.updateList(photos);
        }

        @Override
        public void failure(RetrofitError error)
        {
            String merror = error.getMessage();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Gelen Veri Yok");
            builder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.setMessage(merror);

            builder.create().show();
        }
    });
    }
}
