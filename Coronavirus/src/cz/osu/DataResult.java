package cz.osu;

public class DataResult {

    private String country;
    public Integer confCases;
    public int deaths;

    public String getCountry() {
        return country;
    }

    public DataResult(String country, int confCasesInit, int deathsInit){

        this.country = country;
        this.confCases = confCasesInit;
        this.deaths = deathsInit;
    }

    @Override
    public String toString(){

        return String.format("%s %d %d", country, confCases, deaths);
    }
}
