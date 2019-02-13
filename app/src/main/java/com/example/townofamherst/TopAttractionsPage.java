package com.example.townofamherst;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TopAttractionsPage extends Fragment {

    private List<TopAttractionsClass> topAttractions;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.recycler_view_top_attractions, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv_top_attractions);

//        Creating a Layout Manager
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();

        RecyclerViewTopAttractionsAdapter adapter = new RecyclerViewTopAttractionsAdapter(topAttractions);
        rv.setAdapter(adapter);

        return rootView;
    }

    private void initializeData(){
        Resources resourcesTopAttractions = getResources();
        String[] topAttractionsTitle = resourcesTopAttractions.getStringArray(R.array.top_attractions_title);
        String[] topAttractionsDescription = resourcesTopAttractions.getStringArray(R.array.top_attractions_description);
        TypedArray topAttractionsImage = resourcesTopAttractions.obtainTypedArray(R.array.top_attractions_images);

        topAttractions = new ArrayList<>();

        for(int i = 0; i<topAttractionsTitle.length; i++){
            topAttractions.add(new TopAttractionsClass(topAttractionsTitle[i], topAttractionsDescription[i], topAttractionsImage.getResourceId(i, -1)));
        }

        topAttractionsImage.recycle();
    }
}
