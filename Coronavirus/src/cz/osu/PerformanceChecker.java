package cz.osu;

import java.util.ArrayList;
import java.util.HashSet;

public class PerformanceChecker {

    private ArrayList<String> wordsAsList;
    private HashSet<String> wordsAsHashSet;

    public PerformanceChecker(){

        wordsAsList = FileManager.fileFromResourceToArrayList("words_alpha.txt");
        wordsAsHashSet = new HashSet<>(FileManager.fileFromResourceToArrayList("words_alpha.txt"));
    }

    public boolean containsWord_SearchInArrayList(String word){

        return wordsAsList.contains(word);
    }

    public boolean containsWord_SearchInHashSet(String word){

        return wordsAsHashSet.contains(word);
    }

    public void testSearch(String word){

        String temp = new String(word);

        System.out.println("Search: " + temp);

        long startTime = System.nanoTime();
        System.out.print(containsWord_SearchInArrayList(temp));
        long endTime = System.nanoTime();
        System.out.println(" > SearchArrayList: " + (endTime - startTime) / 1000 + " ms");

        startTime = System.nanoTime();
        System.out.print(containsWord_SearchInHashSet(temp));
        endTime = System.nanoTime();
        System.out.println(" > SearchHashSet: " + (endTime - startTime) / 1000 + " ms");

        System.out.println("-----------");
    }
}
