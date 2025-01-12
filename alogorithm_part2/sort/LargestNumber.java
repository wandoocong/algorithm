package alogorithm_part2.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] a = {3, 30, 34, 8, 9};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        String s = largestNumber(a);
        System.out.println("s = " + s);

    }

    public static boolean isNeedSwap(int n1, int n2) {
        return Long.valueOf(String.valueOf(n1) + n2) < Long.valueOf(String.valueOf(n2) + n1);
    }

    public static String largestNumber(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;

            while (j > 0 && isNeedSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }
        if (nums[0] == 0) {
            return "0";
        }else{
            return Arrays.toString(nums).replaceAll("\\[ | \\] | , | \\s", "");
        }
    }
}
