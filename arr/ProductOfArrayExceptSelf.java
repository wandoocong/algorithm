package arr;

import java.util.*;
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int [] answer = productOfArrayExceptSelf.productExceptSelf(arr);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length-1; i > 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
}
