package algorithm_part2.binary_Search;

import java.util.Arrays;

public class TwoSumBS {
    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        int[] ints = twoSumBS(nums, target);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    public static int[] twoSumBS(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i;
            int right = numbers.length - 1;

            int expected = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < expected) {
                    left = mid + 1;
                } else if (numbers[mid] > expected) {
                    right = mid - 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return null;
    }

}
