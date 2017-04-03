package com.example.singh.viewliftchallenge.activities.videolist;

import android.content.Context;

import com.example.singh.viewliftchallenge.BasePresenter;
import com.example.singh.viewliftchallenge.BaseView;
import com.example.singh.viewliftchallenge.model.videolist.Item;

import java.util.List;

/**
 * Created by singh on 01-Apr-17.
 */

public interface VideoListContract {

    interface View extends BaseView {

        void updateList(List<Item> items);
        void updateSearchResults(List<Item> items);

    }

    interface Presenter extends BasePresenter<View> {

        void getVideoList();
        void searchList(String searchString);
        void showDialog(Context context);

    }
}
