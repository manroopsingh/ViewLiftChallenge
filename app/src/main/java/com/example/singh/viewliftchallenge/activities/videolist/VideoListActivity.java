package com.example.singh.viewliftchallenge.activities.videolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.injection.videolist.DaggerVideoListComponent;
import com.example.singh.viewliftchallenge.model.videolist.Item;
import com.example.singh.viewliftchallenge.utility.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VideoListActivity extends AppCompatActivity implements VideoListContract.View {

    @BindView(R.id.rvVideoList)
    RecyclerView rvVideoList;

    @BindView(R.id.etSearch)
    EditText etSearch;

    private List<Item> videoList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator defaultItemAnimator;
    private VideoListAdapter adapter;
    private int backButtonCount = 0;

    @Inject
    VideoListPresenter videoListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        ButterKnife.bind(this);
        setTitle("Videos");

        setupRecyclerView();
        setupDaggerComponent();
        videoListPresenter.addView(this);
        videoListPresenter.getVideoList();

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                videoListPresenter.searchList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(getApplicationContext());
        defaultItemAnimator = new DefaultItemAnimator();
        adapter = new VideoListAdapter(this, videoList);
        rvVideoList.setAdapter(adapter);
        rvVideoList.setLayoutManager(layoutManager);
        rvVideoList.setItemAnimator(defaultItemAnimator);
    }

    private void setupDaggerComponent() {
        DaggerVideoListComponent.create()
                .inject(this);
    }

    @Override
    public void updateList(List<Item> items) {

        videoList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateSearchResults(List<Item> items) {
        adapter.updateList(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.videolist_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_sort) {
            videoListPresenter.showDialog(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

    @Override
    public void showError(String error) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoListPresenter.removeView();

    }
}
