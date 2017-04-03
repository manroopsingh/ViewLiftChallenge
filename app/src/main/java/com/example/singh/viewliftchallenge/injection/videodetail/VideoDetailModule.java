package com.example.singh.viewliftchallenge.injection.videodetail;

import com.example.singh.viewliftchallenge.activities.videodetail.VideoDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 01-Apr-17.
 */

@Module
public class VideoDetailModule {

    @Provides
    public VideoDetailPresenter provideVideoDetailPresenter(){
        return new VideoDetailPresenter();
    }
}
