package algorithm_part1.arr;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        productExceptSelf(arr);
    }
    public static int[] productExceptSelf(int[] nums) {

        int p = 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p = p * nums[i];
        }

        p = 1;
        for (int i = nums.length-1; i >=0; i--) {
            result[i] = result[i] * p;
            p = p * nums[i];
        }

        System.out.println("result = " + Arrays.toString(result));
        return null;
    }
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static int arrayPairSum(int[] num) {

        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
            if (list.size() == 2) {
                sum +=Collections.min(list);
                list.clear();
            }

        }
        return sum;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int left = 0;
        int right = 0;
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
                        //-1 -1 .... 2
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i+1;
            right = nums.length-1;

            while (left < right) {
                if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    answer.add((Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int volume = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
