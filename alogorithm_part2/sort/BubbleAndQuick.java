package alogorithm_part2.sort;

import java.util.Arrays;
import java.util.Queue;

public class BubbleAndQuick {
    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        int[] Qnums = Quicksort(nums, 0, nums.length-1);
        System.out.println("Quick sorted num = " + Arrays.toString(Qnums));
    }

    public static int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int left = lo;
        for (int right = lo; right < hi; right++) {
            if (A[right] < pivot) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
            }
        }
        int temp = A[left];
        A[left] = A[hi];
        A[hi] = temp;
        return left;
    }

    public static int[] Quicksort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(A, lo, hi);
            Quicksort(A, lo, pivot - 1);
            Quicksort(A, pivot+1, hi);
        }
        return A;
    }

    public static int[] Bubblesort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length-1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

}
