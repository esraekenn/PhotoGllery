package com.pordiva.esraeken.photogllery;

import com.pordiva.esraeken.photogllery.constans.constans;

import retrofit.RestAdapter;

/**
 * Created by esraeken on 24/08/16.
 */
public class SingeletonPhoto

{
    private PhotoInterface restInterface;

    private static SingeletonPhoto instance;
    private SingeletonPhoto(){}


        public synchronized  static  SingeletonPhoto getInstance()

        {
            if(instance==null)
            {
                instance=new SingeletonPhoto();
            }
            return instance ;
        }

    public PhotoInterface retrofitphoto()
    {

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(constans.URL).setLogLevel(RestAdapter.LogLevel.FULL).build();
        restInterface = restAdapter.create(PhotoInterface.class);
        return restInterface;
    }

}
