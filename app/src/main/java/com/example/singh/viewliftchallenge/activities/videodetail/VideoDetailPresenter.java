package com.example.singh.viewliftchallenge.activities.videodetail;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;

import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.model.videolist.Item;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * Created by singh on 01-Apr-17.
 */

public class VideoDetailPresenter implements VideoDetailContract.Presenter {

    private VideoDetailContract.View view;
    private Context context;
    private SimpleExoPlayer player;
    private static final DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

    @Override
    public void addView(VideoDetailContract.View view) {
        this.view = view;

    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void restrieveData(Item item) {


        view.updateViews(item);
    }

    @Override
    public void setVideoResource(Context context, Item item) {
        this.context = context;
        String videoUrl = item.getPlayer().getUrl();

        createPlayer();
        preparePlayer(videoUrl);

        view.updatePlayerView(player);
    }


    public void createPlayer() {
        TrackSelection.Factory videoTrackSelectionFactory
                = new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        LoadControl loadControl = new DefaultLoadControl();

        player = ExoPlayerFactory.newSimpleInstance(context, trackSelector, loadControl);
    }

    public void preparePlayer(String videoUrl) {

        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context,
                context.getString(R.string.app_name)), bandwidthMeter);
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource videoSource = new ExtractorMediaSource(Uri.parse(videoUrl),
                dataSourceFactory, extractorsFactory, new Handler(), null);

        player.prepare(videoSource);
    }


}
