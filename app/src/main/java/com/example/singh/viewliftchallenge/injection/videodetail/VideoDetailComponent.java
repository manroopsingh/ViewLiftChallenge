package com.example.singh.viewliftchallenge.injection.videodetail;

import com.example.singh.viewliftchallenge.activities.videodetail.VideoDetailActivity;

import dagger.Component;

/**
 * Created by singh on 01-Apr-17.
 */

@Component(modules = VideoDetailModule.class)
public interface VideoDetailComponent {

    void inject(VideoDetailActivity videoDetailActivity);
}
