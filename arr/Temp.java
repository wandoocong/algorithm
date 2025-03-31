package arr;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int answer = trap(arr);
        System.out.println("answer = " + answer);

    }

    public static int trap(int[] height) {
        int vol = 0;
        int left = 0, right = height.length - 1;
        int leftmax = height[left];
        int rightmax = height[right];

        while (left < right) {
            leftmax = Math.max(height[left], leftmax);
            rightmax = Math.max(height[right], rightmax);

            // 오른
            if (leftmax <= rightmax) {
                vol += leftmax - height[left];
                left++;
            } else {
                vol += rightmax - height[right];
                right--;
            }
        }
        return vol;
    }
}
