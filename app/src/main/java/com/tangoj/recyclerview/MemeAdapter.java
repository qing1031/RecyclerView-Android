package com.tangoj.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeViewHolder> {

    private JSONArray dataList;

    public MemeAdapter(JSONArray list) {
        this.dataList = list;
    }

    @Override
    public int getItemCount() {
        return dataList.length();
    }

    @Override
    public void onBindViewHolder(MemeViewHolder holder, int position) {

        try {
            JSONObject jsonObject = dataList.getJSONObject(position);

            String largeCard = jsonObject.getString("LargeCardView");
            String smallCard = jsonObject.getString("SmallCardView");

            if (!largeCard.equals("")) {
                holder.mLargeImage.setImageResource(R.drawable.card_mark);

            } else {
                holder.mLargeImage.setImageResource(0);
            }

            if (!smallCard.equals("")) {
                holder.mSmallImage.setImageResource(R.drawable.card_mark);
            } else {
                holder.mSmallImage.setImageResource(0);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public MemeAdapter.MemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cardview, parent, false);

        return new MemeViewHolder(item);
    }

    public static class MemeViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mLargeImage;
        public ImageView mSmallImage;

        public MemeViewHolder(View v) {
            super(v);
            mLargeImage = (ImageView) v.findViewById(R.id.large_card);
            mSmallImage = (ImageView) v.findViewById(R.id.small_card);
        }
    }
}
