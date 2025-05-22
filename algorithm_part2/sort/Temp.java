package algorithm_part2.sort;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 2, 1, 0};
        sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length;

        while (white < blue) {
            if (nums[white] < 1) {
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;
                white ++;
                red++;
            } else if (nums[white] > 1) {
                blue--;

                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;

            } else {
                white++;
            }

        }

    }
}
