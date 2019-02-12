package com.example.townofamherst;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewTopAttractionsAdapter extends RecyclerView.Adapter<RecyclerViewTopAttractionsAdapter.AttractionViewHolder> {

    public static class AttractionViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView title;
        TextView description;
        ImageView icon;

        AttractionViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            title = (TextView) itemView.findViewById(R.id.heading_top_attractions);
            description = (TextView) itemView.findViewById(R.id.description_top_attractions);
            icon = (ImageView)  itemView.findViewById(R.id.icon_top_attractions);
        }
    }

    List<TopAttractionsClass> topAttractions;

    RecyclerViewTopAttractionsAdapter(List<TopAttractionsClass> topAttractions){
        this.topAttractions = topAttractions;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_attractions_page, viewGroup, false);
        AttractionViewHolder attractionViewHolder = new AttractionViewHolder(view);
        return attractionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder attractionViewHolder, int i) {
        attractionViewHolder.title.setText(topAttractions.get(i).title);
        attractionViewHolder.description.setText(topAttractions.get(i).description);
        attractionViewHolder.icon.setImageResource(topAttractions.get(i).image);
    }

    @Override
    public int getItemCount() {
        return topAttractions.size();
    }
}
