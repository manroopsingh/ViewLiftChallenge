package com.example.singh.viewliftchallenge.injection.videolist;

import com.example.singh.viewliftchallenge.activities.videolist.VideoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 01-Apr-17.
 */

@Module
public class VideoListModule {

    @Provides
    public VideoListPresenter provideVideoListPresenter(){
        return new VideoListPresenter();
    }

}
