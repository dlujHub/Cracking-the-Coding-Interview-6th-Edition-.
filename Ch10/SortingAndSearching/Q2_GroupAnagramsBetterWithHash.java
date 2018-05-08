package Ch10.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
 each other.
Better approach, using HashMap.
 */
public class Q2_GroupAnagramsBetterWithHash {

    private static String[] sort(String[] arr){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String word: arr) {
            word = word.toLowerCase();
            char[] word_arr = word.toCharArray();
            Arrays.sort(word_arr);
            String word_sorted = String.valueOf(word_arr);

            ArrayList<String> list = map.get(word_sorted);
            if (list == null) {
                list = new ArrayList<>();
                list.add(word);
                map.put(word_sorted, list);
            } else {
                list.add(word);
                map.put(word_sorted, list);
            }
        }

        int i = 0;
        for(String word: map.keySet()){
            System.out.println(word+ " " + map.get(word));
            for(String w: map.get(word)){
                arr[i++] = w;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        String[] arr = {"anad", "caL", "dAnA", "lac", "piss", "aadn"};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
