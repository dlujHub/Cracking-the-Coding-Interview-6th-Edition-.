package Ch01.ArraysAndStrings;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 remove a character, or replace a character. Given two strings, write a function to check if they are
 one edit (or zero edits) away.
 EXAMPLE
 pale, pIe -> true
 pales. pale -> true
 pale. bale -> true
 pale. bake -> false
 */
public class Q5_OneAway {
    private static boolean oneAway(String w1, String w2){
        if (Math.abs(w1.length()-w2.length()) > 1) {
            return false;
        }

        String word1 = (w1.length()<w2.length())? w1 : w2;
        String word2 = (w1.length()<w2.length())? w2 : w1;

        int edits = 0;
        int j = 0;
        for(int i = 0; i<word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(j)){
                j++;
            } else{
                if (edits >= 1){
                    return false;
                }
                edits++;
                if (word1.length() != word2.length()) {
                    j++;
                    i--;

                } else{
                    j++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));
        System.out.println(oneAway("", "x"));
    }
}
