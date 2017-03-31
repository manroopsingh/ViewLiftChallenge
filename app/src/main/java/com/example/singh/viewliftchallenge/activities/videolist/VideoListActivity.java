package com.example.singh.viewliftchallenge.activities.videolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.model.Rss;
import com.example.singh.viewliftchallenge.utility.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VideoListActivity extends AppCompatActivity {

    private static final String TAG = "VideoListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);




        rx.Observable<Rss> videosObservable = RetrofitHelper.createListObs();
        videosObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Rss>() {
                    @Override
                    public void onCompleted() {


                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Rss rss) {
                        testRss(rss);
                        //Log.d(TAG, "onNext: " + rss.getChannel().get(0).getDesciption());

                    }
                });
    }

    private void testRss(Rss rss) {

        Log.d(TAG, "testRss: " + rss.getChannel().getTitle());
        Log.d(TAG, "testRss: " + rss.getChannel().getDescription());
        Log.d(TAG, "testRss: " + rss.getChannel().getCurrentPageLink());
        Log.d(TAG, "testRss: " + rss.getChannel().getLanguage());
        Log.d(TAG, "testRss: " + rss.getChannel().getItems().size());

    }
}
