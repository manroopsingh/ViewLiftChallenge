package com.example.singh.viewliftchallenge.activities.videodetail;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.injection.videodetail.DaggerVideoDetailComponent;
import com.example.singh.viewliftchallenge.model.videolist.Item;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.Toast.makeText;

public class VideoDetailActivity extends AppCompatActivity implements VideoDetailContract.View {

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvContent)
    TextView tvContent;

    @BindView(R.id.tvTags)
    TextView tvTags;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvCredits)
    TextView tvCredits;

    @BindView(R.id.videoExoplayer)
    SimpleExoPlayerView simpleExoPlayerView;

    @Inject
    VideoDetailPresenter videoDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setupDaggerComponent();
        videoDetailPresenter.addView(this);
        videoDetailPresenter.restrieveData((Item) getIntent().getSerializableExtra("item"));
        videoDetailPresenter.setVideoResource(this, (Item) getIntent().getSerializableExtra("item"));
    }

    private void setupDaggerComponent() {
        DaggerVideoDetailComponent.create()
                .inject(this);
    }

    @Override
    public void updateViews(Item item) {

        setTitle(item.getFilmType());
        tvTitle.setText(item.getTitle());
        tvContent.setText(item.getEncoded());
        tvDescription.setText(item.getDescription());
        tvTags.setText(item.getKeywords());

        if(!((item.getCredit()) == null)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < item.getCredit().size(); i++) {
                sb.append(item.getCredit().get(i).getRole() + ": " + item.getCredit().get(i).getCredit());
                if(i<item.getCredit().size()-1)
                sb.append("\n");
            }
            tvCredits.setText(sb.toString());
        }
    }

    @Override
    public void updatePlayerView(SimpleExoPlayer player) {
        simpleExoPlayerView.setPlayer(player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.videodetail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        if (id == R.id.action_bookmark) {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_download) {
            makeText(this, "Downloading..", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String error) {
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoDetailPresenter.removeView();
    }
}
