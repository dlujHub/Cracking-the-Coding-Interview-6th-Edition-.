package Ch09.RecursionAndDynamicProgramming;


public class FibonacciMemoisation {

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

    private static long fibonacci(int i) {
        return fibonacci(i, new long[i+1]);
    }

    private static long fibonacci(int i, long[] memo) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (memo[i] == 0) {
            memo[i] = fibonacci(i-1, memo) + fibonacci(i-2, memo);
        }
        return memo[i];
    }
}
