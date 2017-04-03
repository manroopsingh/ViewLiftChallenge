package com.example.singh.viewliftchallenge.activities.videodetail;

import android.content.Context;

import com.example.singh.viewliftchallenge.BasePresenter;
import com.example.singh.viewliftchallenge.BaseView;
import com.example.singh.viewliftchallenge.model.videolist.Item;
import com.google.android.exoplayer2.SimpleExoPlayer;

/**
 * Created by singh on 01-Apr-17.
 */

public interface VideoDetailContract {

    interface View extends BaseView{

        void updateViews(Item item);
        void updatePlayerView(SimpleExoPlayer player);
    }

    interface Presenter extends BasePresenter<View>{

        void restrieveData(Item item);
        void setVideoResource(Context context,Item item);

    }

}
