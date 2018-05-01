package Ch10.SortingAndSearching;

import java.util.Arrays;

/**
 * Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
 end to hold B. Write a method to merge B into A in sorted order.
 Hints:
 */
public class Q1_Sorted_Merge {

    private static int[] sort(int[] A, int sizeA, int[] B) {
        int curr = A.length -1;
        int lastA = sizeA-1;
        int lastB = B.length - 1;

        while (lastB >= 0){
            if (lastA>= 0 && A[lastA] > B[lastB]) {
                A[curr--] = A[lastA--];
            } else{
                A[curr--] = B[lastB--];
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 1;A[1] = 2;A[2] = 5;A[3] = 6;A[4] = 8;A[5] = 30;
        int[] B = {3, 5, 7, 20};

        System.out.println("A is " + Arrays.toString(A));
        System.out.println("B is " + Arrays.toString(B));
        System.out.println(Arrays.toString(sort(A, 6, B)));
    }
}
