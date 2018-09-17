package com.applaudostudio.weekthreechallengeone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.applaudostudio.weekthreechallengeone.R;


import com.applaudostudio.weekthreechallengeone.model.CardItem;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ItemSelectedListener mCallback;
    private List<CardItem> mDataSet;
    public static final String BUNDLE_KEY = "DATA_DETAIL";
    protected CardItem mActualItem;

    public ListAdapter(List<CardItem> dataList, ItemSelectedListener callback) {
        mDataSet = new ArrayList<>();
        mDataSet = dataList;
        this.mCallback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_list, viewGroup, false);
        mActualItem = mDataSet.get(i);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CardViewHolder cardHolder = (CardViewHolder) viewHolder;
        cardHolder.bindData(mDataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    private class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTxtTitle;
        private TextView mTxtDescription;
        private ImageView mImgPlace;
        private ConstraintLayout layoutContainer;
        private View mDivBar;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtTitle = itemView.findViewById(R.id.textViewTitle);
            mTxtDescription = itemView.findViewById(R.id.textViewPlaceDescription);
            mImgPlace = itemView.findViewById(R.id.imageViewPlace);
            mDivBar = itemView.findViewById(R.id.dividerBar);
            itemView.setOnClickListener(this);
        }

        void bindData(CardItem data) {
            mTxtTitle.setText(data.getCardPlaName());
            mTxtDescription.setText(data.getDescription().substring(0,30)+ "...");
            mImgPlace.setImageResource(data.getLogo());
            mDivBar.setBackgroundColor(data.getColorBarRs());
            mTxtTitle.setTextColor(data.getColorBarRs());
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.layoutContainer:
                    if (mCallback != null) {
                        mCallback.onClickItemToShow(mDataSet.get(getAdapterPosition()));
                    }
                    break;
            }
        }
    }

    public interface ItemSelectedListener {

        void onClickItemToShow(CardItem cardItem);

    }

}
