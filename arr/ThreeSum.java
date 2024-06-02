package arr;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

//        int[] arr = {-1, 0, 1, 2, -1, -5};
        int[] arr = {-4, -4, -4, -3, 2, -1, 8, 8};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(arr);
        System.out.println("threeSum = " + lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, sum;

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            // -4, -4, -4, -3, 2, -1, 8 >> 요 중복 막아줌
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    left ++;
                } else if (sum < 0) {
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 조건 넣어주는 부분 good
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 정답이 나왔으므로 투포인터 모두 이동해야 한다.
                    // 합이 0 인 상황이므로 양쪽다 이동
                    left ++;
                    right--;
                }

            }

        }
        return results;
    }
}
