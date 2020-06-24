package cz.osu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataItem {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private static String separator = ";";

    private String country;
    private int newConfCases;
    private int newDeaths;
    private String region;

    public Date getDateOfItem() {
        return dateOfItem;
    }

    private Date dateOfItem;

    public String getCountry() {
        return country;
    }

    public int getNewConfCases() {
        return newConfCases;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public String getRegion() {
        return region;
    }

    public static DataItem createDataItemFromLine(String line){

        //DateRep;CountryExp;NewConfCases;NewDeaths;GeoId;Gaul1Nuts1;EU

        try{
            String[] values = line.split(separator);

            return new DataItem(dateFormatter.parse(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), values[6]);

        }catch (Exception ex){

            ex.printStackTrace();
        }

        return null;
    }

    public DataItem(Date dateOfItem, String country, int newConfCases, int newDeaths, String region){

        this.dateOfItem = dateOfItem;
        this.country = country;
        this.newConfCases = newConfCases;
        this.newDeaths = newDeaths;
        this.region = region;

    }

    @Override
    public String toString(){

        return String.format("%s %s %d %d %s", dateFormatter.format(dateOfItem), country, newConfCases, newDeaths, region);
    }
}
