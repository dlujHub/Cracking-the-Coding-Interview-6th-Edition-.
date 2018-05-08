package Ch10.SortingAndSearching;

import java.util.Arrays;

/**
 * Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
 each other.

 */
public class Q2_GroupAnagrams {

    private static String[] sort(String[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1; j<arr.length; j++){

                if (equals(arr[i], arr[j])) {
                    String temp = arr[i + 1];
                    arr[i + 1] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
        }
        return arr;
    }

    private static boolean equals(String a, String b){
        if (a.length() != b.length()){
            return false;
        }
        int[] charSet1 = new int[26];
        int[] charSet2 = new int[26];
        for (int i =0; i<a.length(); i++) {
            char c = Character.toLowerCase(a.charAt(i));
            if (isChar(c)) {
                charSet1[c - 'a']++;
            }
            c = Character.toLowerCase(b.charAt(i));
            if (isChar(c)) {
                charSet2[c - 'a']++;
            }


        }
        for (int i=0; i<charSet1.length; i++) {
            if (charSet1[i] != charSet2[i]){
                return false;
            }
        }

        return true;
    }

    private static boolean isChar(char c) {
        return c - 'a' < 26 && c - 'a' >= 0;
    }

    public static void main(String[] args) {
        String[] arr = {"anad", "caL", "dAnA", "lac", "piss", "aadn"};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
