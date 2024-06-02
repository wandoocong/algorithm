package arr;

import java.util.*;
public class ArrayPartition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};

        ArrayPartition arrayPartition = new ArrayPartition();
        System.out.println("sum = " + arrayPartition.arrayPairSum(arr));
        System.out.println("sum = " + arrayPartition.arrayPairSum2(arr));
    }

    public int arrayPairSum(int[] num) {
        List<Integer> pair = new ArrayList<>();
        int sum = 0;

        Arrays.sort(num);

        for (int i : num) {
            pair.add(i);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        return sum;
    }

    public int arrayPairSum2(int[] num) {

        int sum = 0;
        Arrays.sort(num);

        for (int i = 0; i < num.length ; i++) {
            if (i % 2 == 0) {
                sum += num[i];
            }
        }
        return sum;
    }
}
