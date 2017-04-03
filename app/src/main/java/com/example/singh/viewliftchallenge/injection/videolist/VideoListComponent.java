package com.example.singh.viewliftchallenge.injection.videolist;

import com.example.singh.viewliftchallenge.activities.videolist.VideoListActivity;

import dagger.Component;

/**
 * Created by singh on 01-Apr-17.
 */

@Component(modules = VideoListModule.class)
public interface VideoListComponent {

    void inject(VideoListActivity videoListActivity);

}
