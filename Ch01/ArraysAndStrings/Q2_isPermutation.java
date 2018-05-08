package Ch01.ArraysAndStrings;

/**
 * Check Q4_Permutation: Given two strings, write a method to decide if one is a permutation of the
 other.
 */
public class Q2_isPermutation {

   private static boolean isPermutation(String word1, String word2){
     if (word1.length() != word2.length()) {
         return false;
     }
     int[] charWord1 = new int[128];
     int[] charWord2 = new int[128];

     for(int i =0; i<word1.length(); i++) {
         charWord1[word1.charAt(i)] += 1;
         charWord2[word2.charAt(i)] += 1;
     }
       for(int i =0; i<charWord1.length; i++) {
         if (charWord1[i] != charWord2[i]) {
             return false;
         }
       }
       return true;
    }

    public static void main(String[] args) {
       String w1 = "god";
       String w2 = "dog";
       System.out.println(isPermutation(w1, w2));
    }
}
