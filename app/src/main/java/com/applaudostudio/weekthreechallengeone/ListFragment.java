package com.applaudostudio.weekthreechallengeone;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applaudostudio.weekthreechallengeone.adapter.ListAdapter;
import com.applaudostudio.weekthreechallengeone.model.CardItem;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_LIST";
    private List<CardItem> mItemsList;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    public static ListFragment newInstance(List<CardItem> itemsList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PAGE, (ArrayList<? extends Parcelable>) itemsList);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemsList = getArguments().getParcelableArrayList(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerViewPlaces);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ListAdapter(mItemsList);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
