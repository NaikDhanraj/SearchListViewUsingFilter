package com.dssp.dhanrajnaik522.searchlistviewusingfilter;

/**
 * Created by dhanrajnaik522 on 12/5/2015.
 */

public class WorldPopulation {
    private String rank;
    private String country;
    private String population;

    public WorldPopulation(String rank, String country, String population) {
        this.rank = rank;
        this.country = country;
        this.population = population;
    }

    public String getRank() {
        return this.rank;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPopulation() {
        return this.population;
    }
}
