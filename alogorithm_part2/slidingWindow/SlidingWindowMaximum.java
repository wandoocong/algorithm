package alogorithm_part2.slidingWindow;

import java.util.*;
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 8};
        int k = 3;
        int[] ints = maxSlidingWindowByDeque(nums, k);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i+1; j < i+k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            result.add(max);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] maxSlidingWindowByQueue(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> window = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            window.add(nums[i]);

            if (i < k-1)
                continue;

            if (max == Integer.MIN_VALUE) {
                max = Collections.max(window);
            } else if (max < nums[i]) {
                max = nums[i];
            }
            result.add(max);

            // window 는 K개로 계속 유지
            // 삭제하면서 최대값이 빠진다면 최대값 다시 구해야함
            if (max == window.poll()) {
                max = Integer.MIN_VALUE;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] maxSlidingWindowByDeque(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.add(i);

            if (i < k - 1) {
                continue;
            }
            result.add(nums[dq.peek()]);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }


}
