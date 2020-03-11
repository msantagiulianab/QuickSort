import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Type integers separated by spaces,\nthen press enter when you are done:");
        int[] A = input();
        // Creating an instance (object) of the QuickSort class
        QuickSort quick = new QuickSort();
        // Printing the given array
        System.out.println(Arrays.toString(A));
        // Calling the quickSort method
        quick.quickSort(A, 0, A.length-1);
        // Printing the sorted array
        System.out.println(Arrays.toString(A));
    }

    // Taking the input from the user: integers separated by spaces
    private static int[] input() {
        Scanner sc = new Scanner(System.in);
        String textNumbers = sc.nextLine();
        sc.close();
        String[] strNumbers = textNumbers.split(" ");
        int[] A = new int[strNumbers.length];
        for(int i=0; i<A.length; i++) {
            A[i] = Integer.parseInt(strNumbers[i]);
        }
        return A;
    }

    // quickSort is a RECURSIVE method, that has average time complexity = O(n*log n)
    private void quickSort ( int[] A, int low, int high){
        if (low < high + 1) {
            int p = partition(A, low, high);
            quickSort(A, low, p - 1);
            quickSort(A, p + 1, high);
        }
    }

    // Swapping method
    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    // Choosing a random pivot within the range [low, high] inclusive
    private int pivot ( int low, int high){
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    /* Moving each n<pivot to the left of the pivot and each n>pivot to the right
    of the pivot, returning the pivot index
     */
    private int partition(int[] A, int low, int high) {
        swap(A, low, pivot(low, high));
        int border = low + 1;
        for(int i = border; i<=high; i++) {
            if(A[i]<A[low]) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border-1);
        return border-1;
    }
}
