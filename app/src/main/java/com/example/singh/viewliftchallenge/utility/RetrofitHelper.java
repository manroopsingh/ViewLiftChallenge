package com.example.singh.viewliftchallenge.utility;

import com.example.singh.viewliftchallenge.model.Rss;

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
    private static final String BASE_URL1 = "http://api.ratings.food.gov.uk";

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    public static Observable<Rss> createListObs() {
        Retrofit retrofit = create();
        GithubService service = retrofit.create(GithubService.class);

        return service.getVideos();
    }

    public interface GithubService {

        @GET("/feeds")
        rx.Observable<Rss> getVideos();



    }

}
