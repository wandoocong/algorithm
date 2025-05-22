package algorithm_part2.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] a = {3, 30, 34, 8, 9};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        String s = largestNumber(a);
        String[] superFast = isSuperFast(a);
        System.out.println("superFast = " + Arrays.toString(superFast));
//        System.out.println("s = " + s);

    }

    public static String[] isSuperFast(int [] nums) {

        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo((o1+o2));
            }
        });

        return str;
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
