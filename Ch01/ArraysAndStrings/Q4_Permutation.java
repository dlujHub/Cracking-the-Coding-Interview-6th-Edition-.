package Ch01.ArraysAndStrings;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 dictionary words.
 EXAMPLE
 Input: Tact Coa
 Output: True (permutations:"taco cat'; "atco cta'; etc.)
 */
public class Q4_Permutation {

    private static boolean isPermutation(String s) {
        int[] charSet = new int[128];

        for(char c: s.toCharArray()){
            charSet[c]++;
        }
        boolean oneCharEven = false;

        for (int n: charSet) {
            if (n % 2 != 0) {
                if (oneCharEven) {
                    return false;
                }
                oneCharEven = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("tllllacxxootcoapapa"));
    }
}
