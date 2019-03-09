package Ch01.ArraysAndStrings;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 cannot use additional data structures?

 */
public class Q1_IsUnique {

    private static boolean isUnique(String s){
        if (s.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (char c: s.toCharArray()) {
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
            }
        return true;
        }

    public static void main(String[] args) {
        String[] words = {"lack", "crap", "aaaa", "", "sefwfffwef", "xyz169", "11"};

        for(String word : words) {
            System.out.println("Is word " + word + " unique? " + isUnique(word));
        }
    }
}
