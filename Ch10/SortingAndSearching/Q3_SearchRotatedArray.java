package Ch10.SortingAndSearching;

/**
 * Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
 number of times, write code to find an element in the array. You may assume that the array was
 originally sorted in increasing order.

 */
public class Q3_SearchRotatedArray {


    public static void main(String[] args) {
        //int[] arr = {15, 16, 19, 20, 25, 1, 3,4,5,7,10, 14};
        //int[] arr = {5,6,9,26,2,3};
        int[] arr = {10, 15, 20, 0, 5};
        int[] arr2 = {50,5, 20, 30, 40};
        int[] arr3 = {2, 2, 2, 3, 4, 2};
        System.out.println(search(arr, 5));
        System.out.println(search(arr2, 5));
        System.out.println(search(arr3, 3));
    }
    private static int search(int[] arr, int key) {
        return binarySearch(arr, 0, arr.length-1, key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key){
        int mid = low + (high-low)/2;
        if (arr[mid] == key){
            return mid;
        }
        if (high < low) {
            return -1;
        }
        System.out.println("mid " + arr[mid] + " low " + arr[low] + " high " + arr[high]);

        if (arr[low] < arr[mid]) { // left is ordered
            if (key >= arr[low] && key < arr[mid]){
                return binarySearch(arr, low, mid - 1, key);
             } else {
                return binarySearch(arr, mid + 1, high, key);
            }
        } else if (arr[mid] < arr[high]) { // right is ordered
            if (key <= arr[high] && key > arr[mid]){
                return binarySearch(arr, mid + 1, high, key);
            } else {
                return binarySearch(arr, low, mid - 1, key);
            }
        } else if(arr[low] == arr[mid]) { //duplicate elements
            if (arr[mid] != arr[high]){
                System.out.println("here " );
                return binarySearch(arr, mid + 1, high, key);
            } else{
                int result =  binarySearch(arr, low, mid - 1, key);
                if (result == -1){
                    return binarySearch(arr, mid+1, high, key);
                } else{
                    return result;
                }

            }
        }

        return -1;
    }


}
