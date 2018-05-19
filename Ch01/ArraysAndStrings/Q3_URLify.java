package Ch01.ArraysAndStrings;

/**
 * Write a method to replace all spaces in a string with '%2e: You may assume that the string
 has sufficient space at the end to hold the additional characters, and that you are given the "true"
 length of the string. (Note: if implementing in Java, please use a character array so that you can
 perform this operation in place.)
 EXAMPLE
 Input: "Mr John Smith JJ, 13
 Output: "Mr%2eJohn%2eSmith"
 */
public class Q3_URLify {

    private static String URLify(String s, int size) {
       char[] arr = s.toCharArray();

        int last = s.length()-1;
        for(int i=size-1; i>=0;){
            if (arr[i] != ' ') {
               arr[last] = arr[i];
               last--;
            } else{
                arr[last--] = '0';
                arr[last--] = '2';
                arr[last--] = '%';
            }
            i--;
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (char c: arr){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith    ", 13));
    }
}
