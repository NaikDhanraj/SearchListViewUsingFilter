package com.dssp.dhanrajnaik522.searchlistviewusingfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Declare Variables
    ListView list;
    EditText editsearch;
    List<String> rank = new ArrayList<String>();
    List<String> country = new ArrayList<String>();
    List<String> population = new ArrayList<String>();
    ArrayList<WorldPopulation> alldatalist = new ArrayList<WorldPopulation>();
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rank.add("1");
        rank.add("2");
        rank.add("3");
        rank.add("4");
        rank.add("5");
        rank.add("6");
        rank.add("7");
        rank.add("8");
        rank.add("9");
        rank.add("10");
        rank.add("11");
        rank.add("12");
        rank.add("13");
        rank.add("14");
        rank.add("15");
        rank.add("16");
        rank.add("17");
        rank.add("18");
        rank.add("19");
        rank.add("20");
        rank.add("21");
        rank.add("22");
        rank.add("23");
        rank.add("24");
        rank.add("25");
        rank.add("26");
        rank.add("27");
        rank.add("28");
        rank.add("29");
        rank.add("30");

        country.add("China");
        country.add("India");
        country.add("United States");
        country.add("Indonesia");
        country.add("Brazil");
        country.add("Pakisthan");
        country.add("Nigeria");
        country.add("Bangladesh");
        country.add("Russia");
        country.add("Japan");
        country.add("Afgansthan");
        country.add("Turkey");
        country.add("Sri Lanka");
        country.add("Switzland");
        country.add("England");
        country.add("Zimbambey");
        country.add("West Indies");
        country.add("Poland");
        country.add("Bengel");
        country.add("Denmark");
        country.add("Guyana");
        country.add("Iraq");
        country.add("Kenya");
        country.add("Nepal");
        country.add("Yemen");
        country.add("Finland");
        country.add("Bermuda");
        country.add("Cuba");
        country.add("Finland");
        country.add("Korea");

        population.add("11,70000");
        population.add("11,20000");
        population.add("10,80000");
        population.add("10,50000");
        population.add("10,30000");
        population.add("10,20000");
        population.add("10,10000");
        population.add("9,90000");
        population.add("9,60000");
        population.add("9,50000");
        population.add("9,47000");
        population.add("9,40000");
        population.add("9,20000");
        population.add("9,00000");
        population.add("8,68000");
        population.add("8,60000");
        population.add("8,57000");
        population.add("8,50000");
        population.add("8,48000");
        population.add("8,48900");
        population.add("8,48000");
        population.add("8,45000");
        population.add("7,45000");
        population.add("7,42000");
        population.add("7,38000");
        population.add("7,34000");
        population.add("7,30000");
        population.add("6,28000");
        population.add("6,18000");
        population.add("5,8000");

        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < rank.size(); i++)
        {
            WorldPopulation wp = new WorldPopulation(rank.get(i), country.get(i),
                    population.get(i));
            // Binds all strings into an array
            alldatalist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, alldatalist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        editsearch = (EditText) findViewById(R.id.search);

        //capture the text in the edittext
        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text =editsearch.getText().toString().toLowerCase(Locale.getDefault());
                //The filter class captures the user input text from the MainActivity and
                // refreshes the listview to show a matched result
                adapter.filter(text);

            }
        });



    }
}
