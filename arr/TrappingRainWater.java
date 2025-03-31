package arr;

import java.awt.font.TransformAttribute;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int answer = trappingRainWater.trap(arr);
        System.out.println("answer = " + answer);
    }

    public int trap(int[] height) {

        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {

            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            //오른쪽 장벽이 더 높으면
            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                //왼쪽을 채워가고
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}
