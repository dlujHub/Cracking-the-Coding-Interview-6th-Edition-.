package Ch09.RecursionAndDynamicProgramming;

public class FibonacciWithoutMemo {

    public static void main(String[] args){
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(5000));
    }

    private static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        for (int i = 2; i<n; i++) {
            long tempb = b;
            b = a + b;
            a = tempb;

        }
        return a+b;
    }

}
