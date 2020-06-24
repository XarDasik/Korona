package cz.osu;

import java.time.Duration;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        PerformanceChecker pch = new PerformanceChecker();
        pch.testSearch("a");
        pch.testSearch("london");
        pch.testSearch("zurich");
        pch.testSearch("berlin123");


        DataManager dataManager = new DataManager(FileManager.fileFromResourceToArrayList("COVID-19.csv"), true);

        //dataManager.printAllDataItems();
        //for (String region : dataManager.getAvailableRegions()) System.out.println(region);
        //for (String country : dataManager.getAvailableCountries("EU")) System.out.println(country);

        ArrayList<DataResult> dataResults = dataManager.getCountriesStatistic("EU");
        //ArrayList<DataResult> dataResults = dataManager.getCountriesStatistic(null);

        System.out.println("---------- Sort by COUNTRIES ----------");
        dataManager.sortDataResultsByCountries(dataResults);
        for (DataResult result : dataResults) System.out.println(result);

        System.out.println("---------- Sort by CONFIRMED CASES ----------");
        dataManager.sortDataResultsByConfCases(dataResults);
        for (DataResult result : dataResults) System.out.println(result);

        System.out.println("---------- Sort by DEATHS ----------");
        dataManager.sortDataResultsByDeaths(dataResults);
        for (DataResult result : dataResults) System.out.println(result);
    }
}
