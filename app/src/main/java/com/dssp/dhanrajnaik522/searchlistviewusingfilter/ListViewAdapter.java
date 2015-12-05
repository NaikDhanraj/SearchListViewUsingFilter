package com.dssp.dhanrajnaik522.searchlistviewusingfilter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by dhanrajnaik522 on 12/5/2015.
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<WorldPopulation> worldpopulationlist = null;
    private ArrayList<WorldPopulation> alldatalist;

    public ListViewAdapter(Context mContext, List<WorldPopulation> worldpopulationlist) {
        this.mContext = mContext;
        this.worldpopulationlist = worldpopulationlist;

        inflater = LayoutInflater.from(mContext);
        this.alldatalist = new ArrayList<WorldPopulation>();
        this.alldatalist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public WorldPopulation getItem(int position) { //object-->worldpopulation
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.lv_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) convertView.findViewById(R.id.rank);
            holder.country = (TextView) convertView.findViewById(R.id.country);
            holder.population = (TextView) convertView.findViewById(R.id.population);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //setting the result in textviews
        holder.rank.setText(worldpopulationlist.get(position).getRank());
        holder.country.setText(worldpopulationlist.get(position).getCountry());
        holder.population.setText(worldpopulationlist.get(position).getPopulation());

        //listen for listview item click
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("rank",(worldpopulationlist.get(position).getRank()));
                // Pass all data country
                intent.putExtra("country",(worldpopulationlist.get(position).getCountry()));
                // Pass all data population
                intent.putExtra("population",(worldpopulationlist.get(position).getPopulation()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });


        return convertView;
    }

    //filter class
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(alldatalist);
        }
        else
        {
            for (WorldPopulation wp : alldatalist)
            {
                if (wp.getCountry().toLowerCase(Locale.getDefault()).contains(charText) //for country only
                      ||  wp.getPopulation().contains(charText)                         //for population
                       || wp.getRank().contains(charText) )                             //for rank
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();

    }
}
