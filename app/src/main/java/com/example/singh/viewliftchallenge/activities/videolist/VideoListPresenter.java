package com.example.singh.viewliftchallenge.activities.videolist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.model.videolist.Item;
import com.example.singh.viewliftchallenge.model.videolist.Rss;
import com.example.singh.viewliftchallenge.utility.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 01-Apr-17.
 */

public class VideoListPresenter implements VideoListContract.Presenter {

    VideoListContract.View view;
    private List<Item> items = new ArrayList<>();

    @Override
    public void addView(VideoListContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getVideoList() {

        rx.Observable<Rss> videosObservable = RetrofitHelper.createListObs();
        videosObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Rss>() {
                    @Override
                    public void onCompleted() {
                        view.updateList(items);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Rss rss) {
                        items.addAll(rss.getChannel().getItems());
                    }
                });

    }

    @Override
    public void searchList(String searchString) {

        List<Item> newList = new ArrayList<>();
        if (searchString.isEmpty()) {
            view.updateSearchResults(items);
        } else {
            for (Item d : items) {
                if (d.getTitle().toLowerCase().contains(searchString)) {
                    newList.add(d);
                }
            }
            view.updateSearchResults(newList);
        }

    }

    @Override
    public void showDialog(final Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select a category")
                .setItems(R.array.filmtype_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        filterVideoList(which);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void filterVideoList(int type) {

        List<Item> newList = new ArrayList<>();
        String filmType;

        if ((type == 2)) {
            view.updateSearchResults(items);
        } else {
            if (type == 0) filmType = "trailer";
            else filmType = "full film";

            for (Item d : items) {
                if (d.getFilmType().toLowerCase().contains(filmType)) {
                    newList.add(d);
                }
            }
            view.updateSearchResults(newList);
        }
    }
}
