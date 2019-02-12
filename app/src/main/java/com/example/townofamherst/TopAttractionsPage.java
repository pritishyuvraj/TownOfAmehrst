package com.example.townofamherst;

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
        Log.e("PRITISH TAG","See Linear Layout Manager: " + llm.toString());

        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();

        Log.e("PRITISH TAG", "Top Attractions -> " + topAttractions.toString());
        RecyclerViewTopAttractionsAdapter adapter = new RecyclerViewTopAttractionsAdapter(topAttractions);
        rv.setAdapter(adapter);

        return rootView;
    }

    private void initializeData(){
        topAttractions = new ArrayList<>();

        topAttractions.add(new TopAttractionsClass("Emily Dickinson",
                "She was born in Amherst, MA",
                R.mipmap.emily_dickison_foreground));

        topAttractions.add(new TopAttractionsClass("Puffer's Pond",
                "Great place to go with friends",
                R.mipmap.puffers_pond_foreground));



        topAttractions.add(new TopAttractionsClass("Puffer's Pond",
                "Great place to go with friends",
                R.mipmap.puffers_pond_foreground));

        topAttractions.add(new TopAttractionsClass("Emily Dickinson",
                "She was born in Amherst, MA",
                R.mipmap.emily_dickison_foreground));


    }
}
