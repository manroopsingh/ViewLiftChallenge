package com.example.singh.viewliftchallenge.utility;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.singh.viewliftchallenge.R;
import com.example.singh.viewliftchallenge.activities.videodetail.VideoDetailActivity;
import com.example.singh.viewliftchallenge.model.videolist.Item;

import java.util.List;

/**
 * Created by singh on 01-Apr-17.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    List<Item> videoList;
    Context context;

    public VideoListAdapter(Context context, List<Item> videoList) {
        this.videoList = videoList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, director, pubDate;
        private ImageView thumbnail;
        private LinearLayout itemLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            thumbnail = (ImageView) itemView.findViewById(R.id.imgThumbnail);
            director = (TextView) itemView.findViewById(R.id.tvDirector);
            pubDate = (TextView) itemView.findViewById(R.id.tvPubDate);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.llList);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Item item = videoList.get(position);
        holder.title.setText(item.getTitle());
        if (!(item.getThumbnail() == null))
            Glide.with(context).load(item.getThumbnail().get(0).getUrl()).into(holder.thumbnail);

        if (!(item.getCredit() == null))
            holder.director.setText(item.getCredit().get(0).getCredit());
        holder.pubDate.setText((item.getPubDate()));

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoDetailActivity.class);
                intent.putExtra("item", item);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


    public void updateList(List<Item> list){
        videoList = list;
        notifyDataSetChanged();
    }
}
