package com.example.singh.viewliftchallenge.utility;

import com.example.singh.viewliftchallenge.model.videolist.Rss;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by singh on 29-Mar-17.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://www.snagfilms.com";

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    public static Observable<Rss> createListObs() {
        Retrofit retrofit = create();
        RetroFitService service = retrofit.create(RetroFitService.class);
        return service.getVideos();
    }

    public interface RetroFitService {


        @GET("/feeds")
        rx.Observable<Rss> getVideos();
    }

}
