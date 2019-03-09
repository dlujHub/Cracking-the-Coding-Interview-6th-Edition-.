package Ch01.ArraysAndStrings;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 "compressed" string would not become smaller than the original string, your method should return
 the original string. You can assume the string has only uppercase and lowercase letters (a - z).

 */
public class Q6_Compression {

    private static String compress(String word){
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(int i =0; i<word.length(); i++){
            count++;
            if (i+1 >= word.length() || word.charAt(i+1) != word.charAt(i)) {
                sb.append(word.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return word.length()<sb.length() ? word : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aaaaabbbbaaaabx"));
    }
}
