package arr;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2, 6, 11, 15};
        int target = 8;

        TwoSum twoSum = new TwoSum();
        int [] answer = twoSum.twoSum(nums, target);

        System.out.println("answer = " + Arrays.toString(answer));

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != (numsMap.get(target - nums[i]))) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }
        return null;
    }
}
