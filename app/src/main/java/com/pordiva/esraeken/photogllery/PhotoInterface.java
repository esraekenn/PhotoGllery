package com.pordiva.esraeken.photogllery;

import com.pordiva.esraeken.photogllery.model.photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by esraeken on 24/08/16.
 */
public interface PhotoInterface
{
    @GET("/photos")
    void getPhotoList(Callback<List<photo>> response);
}
