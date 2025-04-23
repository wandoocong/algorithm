package alogorithm_part2.binary_Search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12, 15};
        int target = 9;
                                            //0         //6
//        int index = binarySearch(nums, target, 0, nums.length - 1);
        int index = binaryMethod(nums, target, 0, nums.length - 1);
        System.out.println("index = " + index);



    }

    public static int binarySearchW(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                return binarySearchW(nums, target, mid + 1, right);
            } else if (nums[mid] > target) {
                return binarySearchW(nums, target, left, mid-1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binaryMethod(int[] nums, int target, int left, int right) {
        return Arrays.binarySearch(nums, target) >=0 ? Arrays.binarySearch(nums, target) : -1;
    }

}
