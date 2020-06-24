package cz.osu;

import java.util.*;

public class DataManager {

    private ArrayList<DataItem> dataItems;

    public DataManager(ArrayList<String> sourceDataList, boolean sourceDataContainsHeader){

        dataItems = new ArrayList<>(sourceDataList.size());

        for (int i = (sourceDataContainsHeader) ? 1 : 0; i < sourceDataList.size(); i++){

            DataItem item = DataItem.createDataItemFromLine(sourceDataList.get(i));

            if(item != null) dataItems.add(item);
        }
    }

    public void printAllDataItems(){

        for (DataItem item : dataItems) System.out.println(item);
    }

    public ArrayList<String> getAvailableRegions(){

        HashSet<String> regionsAsHashSet = new HashSet<>();

        for (DataItem item : dataItems) regionsAsHashSet.add(item.getRegion());

        ArrayList<String> regions = new ArrayList<>(regionsAsHashSet);

        Collections.sort(regions);

        return regions;
    }

    public ArrayList<String> getAvailableCountries(String requiredRegion){

        HashSet<String> countriesAsHashSet = new HashSet<>();

        for (DataItem item : dataItems) if(requiredRegion == null || item.getRegion().equals(requiredRegion)) countriesAsHashSet.add(item.getCountry());

        ArrayList<String> countries = new ArrayList<>(countriesAsHashSet);

        Collections.sort(countries);

        return countries;
    }

    public ArrayList<DataResult> getCountriesStatistic(String requiredRegion){

        HashMap<String, DataResult> statistic = new HashMap<>();

        for (DataItem item : dataItems) {

            if(requiredRegion == null || item.getRegion().equals(requiredRegion)){

                DataResult dataResult = statistic.get(item.getCountry());

                if(dataResult == null){

                    statistic.put(item.getCountry(), new DataResult(item.getCountry(), item.getNewConfCases(), item.getNewDeaths()));
                }else {

                    dataResult.confCases += item.getNewConfCases();
                    dataResult.deaths += item.getNewDeaths();
                }
            }
        }

        return new ArrayList<DataResult>(statistic.values());
    }

    public void sortDataResultsByCountries(ArrayList<DataResult> results){

        results.sort((r1, r2) -> r1.getCountry().compareTo(r2.getCountry()));
    }

    public void sortDataResultsByConfCases(ArrayList<DataResult> results){

        results.sort((r1, r2) -> r2.confCases.compareTo(r1.confCases));
    }

    public void sortDataResultsByDeaths(ArrayList<DataResult> results){

        bubbleSort(results);
    }

    private static void bubbleSort(ArrayList<DataResult> results){

        for (int i = 0; i < results.size() - 1; i++) {
            for (int j = 0; j < results.size() - i - 1; j++) {

                if(results.get(j).deaths < results.get(j + 1).deaths){

                    DataResult temp = results.get(j);
                    results.set(j, results.get(j + 1));
                    results.set(j + 1, temp);
                }
            }
        }
    }
}
