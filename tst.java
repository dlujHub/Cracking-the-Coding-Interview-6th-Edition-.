import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class tst {


    public static void main(String[] args) {
       System.out.println(13 % 10);
    }

    private static class MyRegex {
        private String zeroTo255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d||25[0-5])";
        public String pattern = "(" + zeroTo255 + "\\.){3}" + zeroTo255;
    }
}
